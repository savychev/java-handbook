package nl.handboek.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GeldTest {

    @ParameterizedTest
    @CsvSource({
            "10.00, 2.50, 12.50",
            "0.00, 0.01, 0.01",
            "-1.00, 1.00, 0.00"
    })
    void teltExactOp(String links, String rechts, String verwacht) {
        assertEquals(
                Geld.euro(verwacht),
                Geld.euro(links).plus(Geld.euro(rechts)));
    }

    @Test
    void weigertOnverwachteDecimalen() {
        assertThrows(
                ArithmeticException.class,
                () -> Geld.euro("1.001"));
    }

    @Test
    void weigertVerschillendeValutas() {
        Geld euro = Geld.euro("1.00");
        Geld dollar = new Geld(
                new BigDecimal("1.00"),
                Currency.getInstance("USD"));

        assertThrows(IllegalArgumentException.class, () -> euro.plus(dollar));
    }
}
