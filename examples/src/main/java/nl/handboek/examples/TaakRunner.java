package nl.handboek.examples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Voert blocking taken op virtual threads uit en begrenst de echte resource.
 */
public final class TaakRunner {

    private TaakRunner() {
    }

    public static <T> List<T> voerUit(
            List<? extends Callable<T>> taken,
            int maximaalGelijktijdig,
            Duration deadline)
            throws Exception {
        Objects.requireNonNull(taken, "taken");
        Objects.requireNonNull(deadline, "deadline");
        if (maximaalGelijktijdig <= 0) {
            throw new IllegalArgumentException(
                    "maximaalGelijktijdig moet positief zijn");
        }
        if (deadline.isNegative() || deadline.isZero()) {
            throw new IllegalArgumentException("deadline moet positief zijn");
        }

        Semaphore grens = new Semaphore(maximaalGelijktijdig);
        long eindtijd = Math.addExact(System.nanoTime(), deadline.toNanos());

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<T>> futures = taken.stream()
                    .map(taak -> executor.submit(() -> {
                        grens.acquire();
                        try {
                            return taak.call();
                        } finally {
                            grens.release();
                        }
                    }))
                    .toList();

            try {
                List<T> resultaten = new ArrayList<>(futures.size());
                for (Future<T> future : futures) {
                    long resterend = eindtijd - System.nanoTime();
                    if (resterend <= 0) {
                        throw new TimeoutException("Globale deadline verstreken");
                    }
                    resultaten.add(future.get(resterend, TimeUnit.NANOSECONDS));
                }
                return List.copyOf(resultaten);
            } catch (ExecutionException e) {
                throw oorspronkelijkeFout(e);
            } finally {
                futures.forEach(future -> future.cancel(true));
            }
        }
    }

    private static Exception oorspronkelijkeFout(ExecutionException wrapper)
            throws Error {
        Throwable oorzaak = wrapper.getCause();
        if (oorzaak instanceof Error error) {
            throw error;
        }
        if (oorzaak instanceof Exception exception) {
            return exception;
        }
        return new RuntimeException(oorzaak);
    }
}
