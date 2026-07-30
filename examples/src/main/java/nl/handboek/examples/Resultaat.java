package nl.handboek.examples;

import java.util.Objects;
import java.util.function.Function;

/**
 * Een gesloten resulttype voor een verwacht succes of een verwachte fout.
 */
public sealed interface Resultaat<T>
        permits Resultaat.Succes, Resultaat.Mislukking {

    <R> Resultaat<R> map(Function<? super T, ? extends R> functie);

    record Succes<T>(T waarde) implements Resultaat<T> {
        public Succes {
            Objects.requireNonNull(waarde, "waarde");
        }

        @Override
        public <R> Resultaat<R> map(
                Function<? super T, ? extends R> functie) {
            return new Succes<>(functie.apply(waarde));
        }
    }

    record Mislukking<T>(String code, String melding)
            implements Resultaat<T> {
        public Mislukking {
            Objects.requireNonNull(code, "code");
            Objects.requireNonNull(melding, "melding");
        }

        @Override
        public <R> Resultaat<R> map(
                Function<? super T, ? extends R> functie) {
            Objects.requireNonNull(functie, "functie");
            return new Mislukking<>(code, melding);
        }
    }
}
