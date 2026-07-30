# Uitvoerbare voorbeelden

Dit kleine Maven-project combineert meerdere concepten uit het handboek:

- immutable records en domeininvarianten;
- `BigDecimal` en `Currency`;
- generics en een sealed resultaat;
- defensieve collectionkopieën en streams;
- virtual threads, semaphore, deadlines en cancellation;
- JUnit 6 parameterized en concurrencytests.

## Vereisten

- JDK 25;
- Maven 3.9+.

Controle:

```bash
java --version
mvn --version
mvn --batch-mode --file examples/pom.xml verify
```

Applicatie starten:

```bash
mvn --file examples/pom.xml package
java -cp examples/target/java-handbook-examples-1.0.0.jar \
  nl.handboek.examples.Hoofdprogramma
```

De voorbeelden gebruiken geen Spring en geen runtime-dependency buiten Java SE.
Alleen de tests gebruiken JUnit.

## Bestanden

| Bestand | Onderwerp |
|---|---|
| [`Geld.java`](./src/main/java/nl/handboek/examples/Geld.java) | value object, exact geldrekenen |
| [`Bestelling.java`](./src/main/java/nl/handboek/examples/Bestelling.java) | records, invarianten, collecties, streams |
| [`Resultaat.java`](./src/main/java/nl/handboek/examples/Resultaat.java) | sealed generiek resulttype |
| [`TaakRunner.java`](./src/main/java/nl/handboek/examples/TaakRunner.java) | virtual threads, begrenzing, timeout |
| [`Hoofdprogramma.java`](./src/main/java/nl/handboek/examples/Hoofdprogramma.java) | composition en gebruik |
