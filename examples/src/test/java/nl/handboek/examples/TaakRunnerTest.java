package nl.handboek.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class TaakRunnerTest {

    @Test
    void bewaartVolgordeEnBegrenstConcurrency() throws Exception {
        AtomicInteger actief = new AtomicInteger();
        AtomicInteger maximum = new AtomicInteger();

        List<Callable<Integer>> taken = IntStream.range(0, 20)
                .mapToObj(index -> (Callable<Integer>) () -> {
                    int nu = actief.incrementAndGet();
                    maximum.accumulateAndGet(nu, Math::max);
                    try {
                        Thread.sleep(Duration.ofMillis(5));
                        return index;
                    } finally {
                        actief.decrementAndGet();
                    }
                })
                .toList();

        List<Integer> resultaten =
                TaakRunner.voerUit(taken, 3, Duration.ofSeconds(2));

        assertEquals(
                IntStream.range(0, 20).boxed().toList(),
                resultaten);
        assertTrue(maximum.get() <= 3);
    }

    @Test
    void respecteertEenGlobaleDeadline() {
        List<Callable<String>> taken = List.of(() -> {
            Thread.sleep(Duration.ofSeconds(1));
            return "te laat";
        });

        assertThrows(
                TimeoutException.class,
                () -> TaakRunner.voerUit(
                        taken,
                        1,
                        Duration.ofMillis(20)));
    }
}
