package nl.handboek.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResultaatTest {

    @Test
    void mapTransformeertAlleenSucces() {
        Resultaat<Integer> succes =
                new Resultaat.Succes<>("Java").map(String::length);
        Resultaat<Integer> fout =
                new Resultaat.Mislukking<String>("E1", "mislukt")
                        .map(String::length);

        assertEquals(new Resultaat.Succes<>(4), succes);
        assertEquals(new Resultaat.Mislukking<>("E1", "mislukt"), fout);
    }
}
