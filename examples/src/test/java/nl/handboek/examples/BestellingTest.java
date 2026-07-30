package nl.handboek.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.junit.jupiter.api.Test;

class BestellingTest {

    @Test
    void berekentTotaalEnKopieertRegelsDefensief() {
        List<Bestelregel> bron = new ArrayList<>(List.of(
                new Bestelregel("Boek", 2, Geld.euro("10.00"))));
        Bestelling bestelling =
                new Bestelling(Currency.getInstance("EUR"), bron);

        bron.clear();

        assertEquals(Geld.euro("20.00"), bestelling.totaal());
        assertEquals(1, bestelling.regels().size());
        assertThrows(
                UnsupportedOperationException.class,
                () -> bestelling.regels().clear());
    }
}
