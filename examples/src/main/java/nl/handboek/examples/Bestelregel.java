package nl.handboek.examples;

import java.util.Objects;

/**
 * Eén productregel met een strikt positieve hoeveelheid.
 */
public record Bestelregel(String product, int aantal, Geld stukprijs) {

    public Bestelregel {
        Objects.requireNonNull(product, "product");
        Objects.requireNonNull(stukprijs, "stukprijs");
        if (product.isBlank()) {
            throw new IllegalArgumentException("product mag niet leeg zijn");
        }
        if (aantal <= 0) {
            throw new IllegalArgumentException("aantal moet positief zijn");
        }
    }

    public Geld totaal() {
        return stukprijs.maal(aantal);
    }
}
