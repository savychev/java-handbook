package nl.handboek.examples;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

/**
 * Een bestelling die haar lijst defensief kopieert.
 */
public record Bestelling(Currency valuta, List<Bestelregel> regels) {

    public Bestelling {
        Objects.requireNonNull(valuta, "valuta");
        regels = List.copyOf(regels);
        boolean andereValuta = regels.stream()
                .map(Bestelregel::stukprijs)
                .map(Geld::valuta)
                .anyMatch(v -> !valuta.equals(v));
        if (andereValuta) {
            throw new IllegalArgumentException(
                    "Alle regels moeten valuta " + valuta + " gebruiken");
        }
    }

    public Geld totaal() {
        Geld nul = new Geld(BigDecimal.ZERO, valuta);
        return regels.stream()
                .map(Bestelregel::totaal)
                .reduce(nul, Geld::plus);
    }
}
