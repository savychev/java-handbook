# 18 — Praktijk, projecten en beheersing

[← Expertpraktijk](../17-expert/README.md) ·
[Inhoudsopgave](../../INHOUDSOPGAVE.md) ·
[Leerpad](../../LEERPAD.md)

Deze module verandert kennis in bewijs. Los eerst zonder antwoord op, schrijf
tests en noteer welke regel je beslissing onderbouwt.

## Oefenladder

Per onderwerp:

| Niveau | Opdracht |
|---|---|
| Herkennen | voorspel uitvoer/fout en leg elke stap uit |
| Toepassen | bouw een kleine correcte implementatie |
| Debuggen | reproduceer en herstel een subtiele bug |
| Ontwerpen | vergelijk minstens twee oplossingen met trade-offs |
| Uitleggen | schrijf een reviewcomment of korte technische uitleg |

## 54 gerichte oefeningen

### 00 — Oriëntatie

1. Compileer één packaged class handmatig en inspecteer hem met `javap -c -v`.
2. Laat terminal en IDE bewust verschillende JDK's gebruiken; diagnosticeer de
   classfileversionfout.
3. Bouw een JAR met main class en leg manifest, classpath en exitcode uit.

### 01 — Taalbasis

1. Voorspel twintig conversies met overflow, boxing, integerdeling en `NaN`.
2. Schrijf een Unicodeveilige teken-/codepointteller en test emoji/combinaties.
3. Refactor een geneste lus naar duidelijke methoden zonder gedrag te wijzigen.

### 02 — Objectoriëntatie

1. Modelleer `Geld`, `Rekening` en `Boeking` met expliciete invarianten.
2. Breek bewust het `equals`/`hashCode`-contract in een `HashSet`; herstel het.
3. Vergelijk class, record, enum en sealed hierarchy voor een betaalstatusmodel.

### 03 — Typesysteem

1. Implementeer generieke `kopieer(bron, doel)` met PECS.
2. Maak voorbeelden van raw-type heap pollution en analyseer de late fout.
3. Ontwerp een foutmodel met `Optional`, sealed result en exceptions; verdedig grenzen.

### 04 — Collecties

1. Benchmark membership met lijst/set bij realistische keygrootte.
2. Bouw een begrensde LRU-cache met `LinkedHashMap` en test eviction.
3. Zoek bugs door backed views, mutable keys en inconsistente comparator.

### 05 — Functioneel Java

1. Schrijf dezelfde dataflow als lus en stream; vergelijk leesbaarheid/allocatie.
2. Bouw een collector voor statistiek in één passage.
3. Maak een parallelle stream met side effect fout en herstel via reductie.

### 06 — Standaardbibliotheek

1. Bereken facturen met `BigDecimal`, btw en expliciete afrondpunten.
2. Plan een event rond een DST-overgang en test ontbrekende/dubbele lokale tijd.
3. Maak een veilige regex/parser voor begrensde logregels en fuzz de input.

### 07 — I/O en NIO

1. Kopieer een groot bestand met partial-readcorrectheid en checksum.
2. Publiceer configuratie via tempbestand + atomic move met fallback.
3. Bouw een veilige ZIP-extractor met grootte-, aantal- en pathlimieten.

### 08 — Concurrency

1. Reproduceer lost updates en herstel met lock, atomic en ownership; vergelijk.
2. Bouw een producer-consumer met bounded `BlockingQueue` en shutdownprotocol.
3. Maak een virtual-thread URL-inspecteur met semaphore, deadlines en cancellation.

### 09 — JVM

1. Koppel bronconstructies aan bytecode voor lambda, switch, record en exception.
2. Maak een beheerst heaplek; vind dominator en GC-rootpad.
3. Neem JFR van CPU + allocatie en schrijf een evidence-based conclusie.

### 10 — Reflectie/modules

1. Schrijf een annotation processor die ongeldige domeinannotaties compile-time afwijst.
2. Bouw twee modules met `uses`/`provides` en laad providers via `ServiceLoader`.
3. Maak een custom runtime met `jlink` en test ontbrekende dynamische dependency.

### 11 — Netwerk/security

1. Bouw een HTTP-client met statusmapping, limiet, timeout en idempotent retry.
2. Maak een lokaal framed TCP-protocol dat partial reads correct verwerkt.
3. Threat-model URL-fetch, file-upload en log-output; implementeer de grenzen.

### 12 — JDBC

1. Implementeer money transfer met rollback en constrainttests.
2. Reproduceer lost update; herstel met versionkolom en conflictresultaat.
3. Vergelijk offset- en keysetpagination onder gelijktijdige inserts.

### 13 — Testen

1. Refactor tijd/random/global state naar deterministische dependencies.
2. Schrijf unit-, integratie- en propertytest voor dezelfde parser.
3. Introduceer vijf mutations en controleer welke assertions ze doden.

### 14 — Build/tooling

1. Bouw vanaf schone checkout met wrapper/toolchain en inspecteer dependencytree.
2. Maak een librarycompatibiliteitsbreuk op bron-, binary- en behavioras.
3. Bouw CI met één artifact, cache, checks en reproduceerbare metadata.

### 15 — Architectuur

1. Verplaats businesslogica uit CLI/JDBC naar een use-case en domein.
2. Kies strategy/decorator/adapter voor drie echte variatieproblemen, niet op naam.
3. Schrijf ADR voor modulair monoliet versus services met herzieningssignalen.

### 16 — Modern Java

1. Migreer Java 8-modelcode naar records/sealed/patterns zonder API-semantiek te breken.
2. Compileer een previewvoorbeeld en toon waarom exact releasepinning nodig is.
3. Gebruik FFM voor een kleine native call en documenteer ownership/failure.

### 17 — Expert

1. Maak een slechte JMH-benchmark; identificeer dead-code/warm-up/setupfouten.
2. Simuleer queue-overload; relateer arrival rate, service time en p99.
3. Schrijf incidentrapport uit JFR, metrics, dumps en tijdlijn.

## Capstone A — Transactionele boekhouding

### Functioneel

- rekeningen en valuta;
- double-entry boekingen;
- idempotente opdrachten;
- saldo en audittrail;
- import/export in expliciet formaat;
- rapportage per periode.

### Technisch verplicht

- immutable value objects en aggregate-invarianten;
- JDBC zonder ORM;
- migrations en constraints;
- transacties en optimistic conflict;
- JUnit unit/integratie/propertytests;
- Maven of Gradle wrapper;
- structured logging;
- module/packagegrenzen;
- geen Spring.

### Acceptatie

- som van debet en credit blijft nul;
- dubbele command-id verandert state niet tweemaal;
- crash/fout tussen writes laat geen halve boeking;
- geld gebruikt geen floating point;
- concurrent conflict is zichtbaar, niet stil verloren.

## Capstone B — Concurrente URL-inspecteur

### Functioneel

Lees URL's, haal headers/beperkte body op en produceer een rapport met status,
duur, contenttype en foutcategorie.

### Technisch verplicht

- Java HTTP Client;
- virtual thread per task;
- begrensde in-flight requests per host/globaal;
- connect/request/deadline timeouts;
- allowlist tegen SSRF;
- redirect- en bodylimiet;
- interruption/cancellation;
- retry alleen voor veilige gevallen;
- JFR-profiel en loadtest.

### Acceptatie

- 10.000 trage URL's veroorzaken geen 10.000 database/hostslots;
- shutdown stopt intake en ruimt binnen deadline op;
- een hangende host blokkeert andere hosts niet;
- secrets/userinfo verschijnen niet in logs;
- rapport bewaart oorspronkelijke volgorde of documenteert alternatief.

## Capstone C — Modulaire pluginanalyse

### Functioneel

Een CLI ontdekt analyzers als providers en voert ze uit op Java-bron/classfiles.

### Technisch verplicht

- JPMS;
- `ServiceLoader`;
- minstens twee provider-modules;
- Class-File API voor één analyzer;
- custom runtime via `jlink`;
- pluginfoutisolatie/timeouts;
- compatibilitybeleid;
- test van duplicate/ontbrekende provider.

### Acceptatie

- kern compileert zonder dependency op providerimplementaties;
- alleen API-packages zijn exported;
- reflectie is alleen expliciet open;
- providerfout stopt niet stil alle resultaten;
- runtime bevat alleen nodige modules plus gedocumenteerde dynamische delen.

## Code-reviewchecklist

### Correctheid

- [ ] Zijn precondities, postcondities, invarianten en units expliciet?
- [ ] Zijn null, leegte, overflow, afronding en Unicode behandeld?
- [ ] Zijn equality, hashing en ordering consistent?
- [ ] Zijn resources bij ieder pad gesloten?

### Concurrency

- [ ] Wie bezit mutable state?
- [ ] Welke happens-before-relatie maakt publicatie veilig?
- [ ] Zijn samengestelde operaties werkelijk atomair?
- [ ] Werken interruption, cancellation, timeout en shutdown?
- [ ] Zijn queues/pools/connections begrensd?

### Data en security

- [ ] Is externe input begrensd en contextueel gevalideerd?
- [ ] Zijn SQL, pad, URL, shell en logcontext veilig?
- [ ] Blijven secrets/PII uit logs en dumps?
- [ ] Zijn transacties, retries en idempotentie consistent?
- [ ] Is least privilege toepasbaar in deployment?

### Onderhoud

- [ ] Is het publieke contract kleiner dan de implementatie?
- [ ] Zijn dependencies en side effects zichtbaar?
- [ ] Zijn tests op gedrag in plaats van interne callvolgorde?
- [ ] Is version-/preview-/compatibility-impact duidelijk?
- [ ] Kan productie het nieuwe foutpad observeren?

## Interviewvragen met antwoordrichting

1. **Is Java pass-by-reference?** Nee; altijd pass-by-value, ook van
   referentiewaarden. Zie [Taalbasis](../01-taalbasis/README.md#java-is-altijd-pass-by-value).
2. **Waarom moeten `equals` en `hashCode` samen?** Hashcollectie kiest eerst
   bucket en dan equality. Zie [Objectoriëntatie](../02-objectorientatie/README.md#object-contracten).
3. **Waarom is `List<Integer>` geen `List<Number>`?** Generics zijn invariant;
   anders kan een `Double` worden toegevoegd. Zie [Typesysteem](../03-typesysteem/README.md#invariantie).
4. **`volatile` of `synchronized`?** Visibility/single state versus atomische
   invariant en mutual exclusion. Zie [JMM](../08-concurrency/memory-model.md#volatile-versus-lock).
5. **Wanneer virtual threads?** Veel blocking I/O; niet om CPU sneller te maken.
6. **Waarom is een stream lui?** Pipelineoptimalisatie en short-circuiting;
   terminal operatie activeert.
7. **Wat is een Java-geheugenlek?** Logisch onnodige state blijft bereikbaar
   vanaf GC roots.
8. **Waarom is een naïeve benchmark fout?** Warm-up/JIT/DCE/forks/data zijn
   niet beheerst.
9. **Wat doet een classloader met type-identiteit?** Naam plus defining loader
   bepaalt type.
10. **`exports` versus `opens`?** API-toegang versus deep reflection.
11. **Waarom prepared statements?** Values blijven data; geen SQL-syntaxinjectie.
12. **Waar ligt transaction boundary?** Rond één consistency/businessoperatie.
13. **Waarom kan retry gevaarlijk zijn?** Duplicatie en unknown outcome zonder
    idempotentie/deadline.
14. **Waarom is coverage geen kwaliteit?** Uitvoering bewijst geen sterke
    assertion of ontbrekende eigenschap.
15. **Waarom niet meteen microservices?** Distributie voegt consistency,
    latency, failure en operations toe; modulegrenzen kunnen lokaal volstaan.

## Definitie van beheersing

Je beheerst een onderwerp pas wanneer je:

1. het mentale model zonder slogans kunt uitleggen;
2. minimaal voorbeeld en tegenvoorbeeld kunt bouwen;
3. typische failure kunt reproduceren;
4. alternatief met trade-offs kunt vergelijken;
5. test/metric/tool kunt kiezen die de claim controleert;
6. het in review bij iemand anders kunt herkennen;
7. weet welke details release-, provider- of databaseafhankelijk zijn.

Ga daarna terug naar de [Leerroute](../../LEERPAD.md) en kies het eerstvolgende
bewijsproject.
