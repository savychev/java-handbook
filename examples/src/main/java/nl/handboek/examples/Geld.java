package nl.handboek.examples;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

/**
 * Een immutable geldwaarde met één canonieke schaal per valuta.
 */
public record Geld(BigDecimal bedrag, Currency valuta)
        implements Comparable<Geld> {

    public Geld {
        Objects.requireNonNull(bedrag, "bedrag");
        Objects.requireNonNull(valuta, "valuta");

        int decimalen = valuta.getDefaultFractionDigits();
        if (decimalen >= 0) {
            bedrag = bedrag.setScale(decimalen, RoundingMode.UNNECESSARY);
        }
    }

    public static Geld euro(String bedrag) {
        return new Geld(
                new BigDecimal(bedrag),
                Currency.getInstance("EUR"));
    }

    public Geld plus(Geld ander) {
        vereisDezelfdeValuta(ander);
        return new Geld(bedrag.add(ander.bedrag), valuta);
    }

    public Geld maal(int factor) {
        if (factor < 0) {
            throw new IllegalArgumentException("factor moet niet-negatief zijn");
        }
        return new Geld(
                bedrag.multiply(BigDecimal.valueOf(factor)),
                valuta);
    }

    @Override
    public int compareTo(Geld ander) {
        vereisDezelfdeValuta(ander);
        return bedrag.compareTo(ander.bedrag);
    }

    private void vereisDezelfdeValuta(Geld ander) {
        Objects.requireNonNull(ander, "ander");
        if (!valuta.equals(ander.valuta)) {
            throw new IllegalArgumentException(
                    "Valuta verschillen: " + valuta + " en " + ander.valuta);
        }
    }
}
