# Inhoudsopgave

Deze inhoudsopgave is de lineaire route. Gebruik de
[Index A–Z](./INDEX-A-Z.md) als je vanuit een begrip zoekt.

## 00 — Oriëntatie

- [Overzicht](./docs/00-orientatie/README.md)
- Platform: Java-taal, Java SE, JDK, JVM en distributies
- Installatie en versiecontrole
- De cyclus broncode → bytecode → uitvoering
- `java`, `javac`, `jar`, `javadoc`, `javap` en JShell
- Projectstructuur, packages en classpath

## 01 — Taalbasis

- [Overzicht](./docs/01-taalbasis/README.md)
- Lexicale structuur, identifiers, keywords en comments
- Primitieve types, referentietypes, literals en conversies
- Variabelen, scope, `var`, constanten en operators
- `if`, `switch`, lussen, `break`, `continue` en `yield`
- Methoden, overloads, varargs en parameterdoorgifte
- Arrays, `String`, text blocks en mutabele tekst

## 02 — Objectoriëntatie

- [Overzicht](./docs/02-objectorientatie/README.md)
- Objecten, classes, constructors en initialisatie
- Encapsulatie, invariant en access modifiers
- Overerving, abstracte classes, interfaces en compositie
- Polymorfisme, substitutie en dynamische binding
- `Object`, `equals`, `hashCode`, `toString`
- Records, enums, sealed classes en pattern matching
- Nested, inner, local en anonymous classes

## 03 — Typesysteem

- [Overzicht](./docs/03-typesysteem/README.md)
- Compile-time- en runtime-types
- Generics, bounds, wildcards, PECS en type-erasure
- Nullability en `Optional`
- Checked en unchecked exceptions
- Eigen exceptionhiërarchieën en resourcebeheer
- Annotaties en type-use-annotaties

## 04 — Collecties

- [Overzicht](./docs/04-collecties/README.md)
- `Iterable`, `Collection`, `List`, `Set`, `Queue`, `Deque`, `Map`
- Implementaties en datastructuren
- Immutable, unmodifiable en concurrent collections
- Iterators, views, kopieën en mutatie
- Natuurlijke ordening, `Comparator`, gelijkheid en hashing
- Big-O en kiezen op toegangspatroon

## 05 — Functioneel Java

- [Overzicht](./docs/05-functioneel/README.md)
- Functionele interfaces, lambdas en closures
- Method- en constructor-references
- Stream-pipeline, luiheid en short-circuiting
- `map`, `flatMap`, `reduce`, collectors en grouping
- Primitive streams en parallelle streams

## 06 — Standaardbibliotheek

- [Overzicht](./docs/06-standaardbibliotheek/README.md)
- `Math`, `BigInteger`, `BigDecimal` en afronding
- `java.time`, tijdzones en klokinjectie
- Regex, formattering, locale en resource bundles
- UUID, randomgenerators, `Objects` en andere utilities

## 07 — I/O en NIO

- [Overzicht](./docs/07-io-nio/README.md)
- Bytes versus tekens en character encodings
- `InputStream`/`OutputStream`, `Reader`/`Writer`
- `Path`, `Files`, directory traversal en attributes
- Buffers, channels, selectors en memory-mapped files
- Serialisatie, compressie en resource safety

## 08 — Concurrency

- [Overzicht](./docs/08-concurrency/README.md)
- [Java Memory Model](./docs/08-concurrency/memory-model.md)
- Processen, platformthreads en virtual threads
- Race conditions, visibility, atomicity en ordering
- `synchronized`, `volatile`, locks en atomics
- Executors, tasks, futures en `CompletableFuture`
- Concurrent collections, semaphores, latches en barriers
- Cancellation, interruption, timeouts en structured concurrency

## 09 — JVM internals en performance

- [Overzicht](./docs/09-jvm/README.md)
- [Geheugen, GC en JIT](./docs/09-jvm/geheugen-gc-jit.md)
- Classfile, bytecode, verification en classloaders
- Stacks, heap, metaspace en native memory
- Reachability, references en garbage collectors
- Interpreter, tiered compilation, inlining en escape analysis
- JFR, JMC, `jcmd`, `jstack`, `jmap` en heap dumps

## 10 — Reflectie en modules

- [Overzicht](./docs/10-reflectie-modules/README.md)
- `Class`, reflectie, method handles en dynamische proxies
- Annotatieverwerking en codegeneratie
- Java Platform Module System (JPMS)
- `ServiceLoader`, sterke encapsulatie en `jlink`

## 11 — Netwerk en security

- [Overzicht](./docs/11-netwerk-security/README.md)
- URI, URL, DNS, TCP, UDP en sockets
- Java HTTP Client, async requests en WebSocket
- TLS, certificaten, hashing, MAC, encryptie en signatures
- Inputvalidatie, secrets, deserialisatie en least privilege

## 12 — Data en JDBC

- [Overzicht](./docs/12-data-jdbc/README.md)
- Drivers, connections, statements en result sets
- Prepared statements en SQL-injectie
- ACID, isolatieniveaus, transacties en savepoints
- Connection pools, batching, mapping en migraties

## 13 — Testen

- [Overzicht](./docs/13-testen/README.md)
- Testpiramide en testbare ontwerpen
- JUnit Jupiter, assertions, lifecycle en parameterized tests
- Stubs, fakes, spies en mocks
- Integratie-, contract-, property- en performancetests
- Dekkingsgraad, mutation testing en flaky tests

## 14 — Build en tooling

- [Overzicht](./docs/14-build-tooling/README.md)
- Maven- en Gradle-lifecycle
- Dependencies, scopes, conflicts, locks en SBOM
- JAR, manifest, modules, `jlink` en `jpackage`
- Logging, documentatie, formattering en statische analyse
- Git, CI/CD, containers en reproduceerbare builds

## 15 — Ontwerp en architectuur

- [Overzicht](./docs/15-architectuur/README.md)
- Cohesie, coupling, SOLID en tell-don't-ask
- Immutability, value objects en foutmodellering
- Creational, structural en behavioral patterns
- Layers, hexagonal architecture, events en boundaries
- API-compatibiliteit, packages en evolutie

## 16 — Modern Java

- [Overzicht](./docs/16-modern-java/README.md)
- Tijdlijn Java 8–26
- Modules, `var`, switch expressions, text blocks
- Records, sealed classes en pattern matching
- Virtual threads, sequenced collections en class-file API
- Preview- en incubatorbeleid
- Migratiestrategie en compatibility

## 17 — Expertpraktijk

- [Overzicht](./docs/17-expert/README.md)
- Evidence-based diagnose
- Correct benchmarken met JMH
- CPU-, allocatie-, lock- en latencyanalyse
- Geheugenlekken, classloaderlekken en native memory
- Productie-hardening, observability en incidentanalyse
- JNI, Foreign Function & Memory API en agents

## 18 — Praktijk

- [Overzicht](./docs/18-praktijk/README.md)
- Oefenladder per niveau
- Drie capstone-projecten
- Code-reviewchecklist
- Interviewvragen
- Definitie van beheersing

## 19 — Java SE-breedtekaart

- [Overzicht](./docs/19-platform-breedte/README.md)
- Java SE-modulekaart en API-discovery
- AWT, Swing, event dispatch thread en JavaFX-positionering
- Graphics, imaging, audio, print, clipboard en accessibility
- XML met DOM, SAX, StAX, XPath, XSLT en veilige parserconfiguratie
- JMX, management, monitoring en attach/instrumentation
- JNDI, RMI, JavaBeans en andere legacy-/niche-API's
- Compiler API, scripting, preferences en platformintegratie

## Extra naslag

- [Leerpad](./LEERPAD.md)
- [Dekkingsmatrix](./DEKKING.md)
- [Index A–Z](./INDEX-A-Z.md)
- [Woordenlijst](./WOORDENLIJST.md)
- [Versiebeleid](./VERSIES.md)
- [Bronnen](./BRONNEN.md)
- [Uitvoerbare voorbeelden](./examples/README.md)
