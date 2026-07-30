package nl.handboek.examples;

import java.time.Duration;
import java.util.Currency;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Laat de losse voorbeelden als één klein programma samenwerken.
 */
public final class Hoofdprogramma {

    private Hoofdprogramma() {
    }

    public static void main(String[] args) throws Exception {
        Bestelling bestelling = new Bestelling(
                Currency.getInstance("EUR"),
                List.of(
                        new Bestelregel("Boek", 2, Geld.euro("24.95")),
                        new Bestelregel("Notitieboek", 1, Geld.euro("5.10"))));

        Resultaat<Geld> resultaat =
                new Resultaat.Succes<>(bestelling.totaal());

        System.out.println(resultaat);

        List<Callable<String>> taken = List.of(
                () -> "taal",
                () -> "JVM",
                () -> "tooling");
        System.out.println(
                TaakRunner.voerUit(taken, 2, Duration.ofSeconds(1)));
    }
}
