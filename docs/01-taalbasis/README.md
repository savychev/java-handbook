# 01 — Taalbasis

[← Oriëntatie](../00-orientatie/README.md) ·
[Inhoudsopgave](../../INHOUDSOPGAVE.md) ·
[Objectoriëntatie →](../02-objectorientatie/README.md)

## 1. Broncode en namen

Java is hoofdlettergevoelig. `account`, `Account` en `ACCOUNT` zijn drie
verschillende identifiers.

Conventies:

| Element | Vorm | Voorbeeld |
|---|---|---|
| package | kleine letters | `nl.handboek.tijd` |
| class/interface/record/enum | PascalCase | `BankAccount` |
| methode/variabele | camelCase | `berekenSaldo` |
| constante | UPPER_SNAKE_CASE | `MAX_POGINGEN` |
| typeparameter | korte hoofdletter | `T`, `K`, `V`, `E` |

Comments:

```java
// Eén regel

/*
 * Meerdere regels
 */

/**
 * API-documentatie voor javadoc.
 */
```

Een comment verklaart intentie of contract, niet wat leesbare code al zegt.

## 2. Waarden en types

### Primitieve types

| Type | Grootte/karakter | Voorbeeld | Let op |
|---|---|---|---|
| `boolean` | `true`/`false` | `boolean actief = true;` | geen numerieke conversie |
| `byte` | 8-bit signed | `byte b = 100;` | -128..127 |
| `short` | 16-bit signed | `short s = 30_000;` | zelden nodig |
| `int` | 32-bit signed | `int n = 42;` | standaard integer |
| `long` | 64-bit signed | `long id = 42L;` | suffix `L` |
| `char` | 16-bit UTF-16 code unit | `char c = 'A';` | niet altijd volledig Unicode-teken |
| `float` | 32-bit IEEE 754 | `float f = 1.5F;` | suffix `F` |
| `double` | 64-bit IEEE 754 | `double d = 1.5;` | geen exact decimaal geldtype |

Een referentietypevariabele bevat een referentiewaarde of `null`; het object
zelf leeft elders. Voorbeelden: `String`, arrays, classes, interfaces, records
en enums.

```java
int aantal = 3;              // primitieve waarde
String naam = "Ada";         // referentie naar een String
String alias = naam;         // kopie van dezelfde referentiewaarde
```

### Literals

```java
int miljoen = 1_000_000;
int binair = 0b1010;
int hex = 0xFF;
long groot = 9_000_000_000L;
double wetenschappelijk = 6.022e23;
char newline = '\n';
String pad = "C:\\temp\\bestand.txt";
```

Integerberekeningen overflowen stil:

```java
int max = Integer.MAX_VALUE;
System.out.println(max + 1); // -2147483648
```

Gebruik `Math.addExact`, `multiplyExact` enzovoort wanneer overflow een fout
moet zijn.

Floating-point kent `NaN`, positieve/negatieve oneindigheid en `-0.0`.
Vergelijk berekende doubles meestal met een domeinafhankelijke tolerantie.
Gebruik `BigDecimal` voor exact decimaal rekenen.

## 3. Variabelen, scope en `final`

Een lokale variabele moet vóór lezen aantoonbaar geïnitialiseerd zijn.
Instancevelden krijgen standaardwaarden; dat maakt een geldig
constructorcontract des te belangrijker.

```java
final int minimumLeeftijd = 18;
var namen = new java.util.ArrayList<String>();
```

`var`:

- is lokale type-inferentie, geen dynamisch type;
- werkt bij lokale variabelen met initializer;
- bewaart exact het afgeleide compile-time-type;
- hoort leesbaarheid te verbeteren, niet type-informatie te verbergen.

`final` voorkomt een nieuwe toekenning. Het maakt het verwezen object niet
immutabel:

```java
final var lijst = new java.util.ArrayList<String>();
lijst.add("mag");       // mutatie mag
// lijst = new ArrayList<>(); // nieuwe referentie mag niet
```

Scope volgt blokken. Kies de kleinst nuttige scope en vermijd shadowing.

## 4. Conversies en casting

Een widening primitive conversion is meestal impliciet:

```java
int i = 42;
long l = i;
double d = l;
```

Narrowing kan informatie verliezen en vereist een cast:

```java
long groot = 3_000_000_000L;
int klein = (int) groot; // verlies; geen exception
```

Boxing koppelt primitives aan wrappers:

```java
Integer boxed = 42; // autoboxing
int unboxed = boxed;
```

Valkuilen:

- unboxing van `null` geeft `NullPointerException`;
- `Integer` vergelijken met `==` vergelijkt referenties na boxing;
- veel boxing in hot code veroorzaakt allocaties;
- wrappers zijn nodig als generiek typeargument: `List<Integer>`.

## 5. Operators en evaluatie

Categorieën: rekenkundig, relationeel, logisch, bitwise, shift, assignment,
conditioneel en typecontrole (`instanceof`).

```java
boolean geldig = leeftijd >= 18 && toestemming;
int absoluut = getal >= 0 ? getal : -getal;
```

`&&` en `||` zijn short-circuiting: rechts wordt alleen geëvalueerd als nodig.
`&` en `|` evalueren bij booleans beide kanten.

```java
if (gebruiker != null && gebruiker.isActief()) {
    // veilig door short-circuiting
}
```

Ken operatorprecedentie, maar gebruik haakjes wanneer de bedoeling anders
moet worden ontcijferd.

### Pre- en postincrement

```java
int x = 3;
int a = ++x; // x=4, a=4
int b = x++; // b=4, x=5
```

Vermijd meerdere side effects in één expressie.

## 6. Besturingsstructuren

### `if`

```java
if (score >= 90) {
    niveau = "uitstekend";
} else if (score >= 60) {
    niveau = "voldoende";
} else {
    niveau = "onvoldoende";
}
```

Java accepteert alleen een boolean conditie; integers zijn geen booleans.

### `switch`

Gebruik een switch expression wanneer je één waarde afleidt:

```java
String type = switch (dag) {
    case SATURDAY, SUNDAY -> "weekend";
    default -> "werkdag";
};
```

Een blok gebruikt `yield`:

```java
int tarief = switch (zone) {
    case "A" -> 10;
    case "B" -> {
        logBerekening(zone);
        yield 20;
    }
    default -> throw new IllegalArgumentException("Onbekende zone: " + zone);
};
```

Klassieke colon-switches kunnen fall-through hebben. Gebruik dat alleen
bewust en documenteer het.

### Lussen

```java
for (int i = 0; i < waarden.length; i++) {
    System.out.println(i + ": " + waarden[i]);
}

for (String waarde : waarden) {
    System.out.println(waarde);
}

while (heeftMeer()) {
    verwerk(volgende());
}

do {
    poging++;
} while (!gelukt() && poging < MAX_POGINGEN);
```

`break` verlaat een lus/switch; `continue` gaat naar de volgende iteratie.
Labels bestaan, maar zijn zelden de duidelijkste abstrahering.

## 7. Methoden

```java
static long som(int links, int rechts) {
    return (long) links + rechts;
}
```

Een signatuur bestaat uit naam en parametertypes, niet uit returntype.
Overloading kiest bij compile-time de best passende signatuur.
Overriding is runtime-polymorfisme en komt in de volgende module.

### Java is altijd pass-by-value

```java
static void wijzig(int getal, StringBuilder tekst) {
    getal = 99;             // wijzigt de argumentvariabele niet
    tekst.append("!");      // muteert het gedeelde object
    tekst = new StringBuilder("nieuw"); // wijzigt de argumentreferentie niet
}
```

De methode ontvangt kopieën: een primitieve waarde of een referentiewaarde.

### Varargs

```java
static int som(int... waarden) {
    int totaal = 0;
    for (int waarde : waarden) {
        totaal += waarde;
    }
    return totaal;
}
```

Een varargs-parameter is binnen de methode een array en moet de laatste
parameter zijn. Elke call kan een arrayallocatie veroorzaken.

### Recursie

Recursie vereist een basisgeval. Java garandeert geen tail-call-optimalisatie;
een diepe recursie kan `StackOverflowError` veroorzaken.

## 8. Arrays

Arrays:

- hebben vaste lengte;
- zijn objecten;
- zijn covariant (`String[]` is een `Object[]`);
- voeren runtime-storechecks uit;
- gebruiken nulgebaseerde indices.

```java
int[] cijfers = {7, 8, 9};
int[][] matrix = {
    {1, 2},
    {3, 4, 5} // rijen mogen verschillende lengtes hebben
};
```

Covariantie is een historische valkuil:

```java
Object[] objecten = new String[1];
objecten[0] = 42; // ArrayStoreException
```

Voor dynamische verzamelingen gebruik je meestal `List<T>`.

## 9. Tekst en Unicode

`String` is immutable. Concatenatie produceert conceptueel nieuwe waarden;
de compiler kan constanten samenvoegen.

```java
String naam = "Dijkstra";
String bericht = """
        Beste %s,

        Welkom bij Java.
        """.formatted(naam);
```

Veel herhaalde mutaties:

```java
StringBuilder builder = new StringBuilder();
for (String woord : woorden) {
    if (!builder.isEmpty()) {
        builder.append(' ');
    }
    builder.append(woord);
}
String zin = builder.toString();
```

### `==` versus `equals`

```java
String a = new String("java");
String b = new String("java");

System.out.println(a == b);      // false: referentie-identiteit
System.out.println(a.equals(b)); // true: inhoud
```

String interning kan `==` soms toevallig `true` maken. Vertrouw daar nooit op
voor inhoudsvergelijking.

### Code units en code points

`char` is één UTF-16-code unit. Sommige Unicode-tekens bestaan uit twee
`char`-waarden (surrogate pair), en een zichtbaar grapheme kan uit meerdere
code points bestaan.

```java
int codePoints = tekst.codePointCount(0, tekst.length());
tekst.codePoints().forEach(System.out::println);
```

Gebruik bij externe bytes altijd een expliciete charset, meestal UTF-8.

## 10. Assertions

```java
assert percentage >= 0 && percentage <= 100 : "ongeldig percentage";
```

Assertions zijn standaard uitgeschakeld en kunnen met `-ea` worden aangezet.
Gebruik ze voor interne aannames, nooit voor gebruikersinput of noodzakelijke
businessvalidatie.

## Veelgemaakte fouten

- Integerdeling: `5 / 2` is `2`; cast vóór de deling voor `2.5`.
- `double` gebruiken voor geld.
- Een lokale `var` zo breed initialiseren dat betekenis verdwijnt.
- Strings met `==` vergelijken.
- Een array-index verwarren met lengte.
- State wijzigen in een ingewikkelde conditie.
- Exceptions gebruiken als normale lusbesturing.
- Defaultwaarden van velden verwarren met geldige domeinwaarden.

## Checklist

- [ ] Ik kan primitives, wrappers en references vergelijken.
- [ ] Ik kan widening, narrowing, boxing en unboxing voorspellen.
- [ ] Ik begrijp scope, definite assignment, `final` en `var`.
- [ ] Ik kan een switch expression en passende lus kiezen.
- [ ] Ik kan pass-by-value met een objectreferentie uitleggen.
- [ ] Ik ken de verschillen tussen array, `List`, `String` en `StringBuilder`.
- [ ] Ik vergelijk tekst met `equals` en houd rekening met Unicode/charset.
- [ ] Ik herken overflow, integerdeling en floating-point-afwijkingen.

## Verder

- [Objectoriëntatie](../02-objectorientatie/README.md)
- [Typesysteem](../03-typesysteem/README.md)
- [Standaardbibliotheek](../06-standaardbibliotheek/README.md)
