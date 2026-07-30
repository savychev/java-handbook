# Dekkingsmatrix

Deze matrix maakt de grens van “Java van A tot Z” controleerbaar. Het handboek
dekt het volledige **leerlandschap**: taal, Java SE, JVM en professioneel
Java-ontwikkelwerk. Het probeert niet iedere Javadoc-methode opnieuw te
beschrijven.

## Diepteniveaus

| Niveau | Betekenis |
|---|---|
| Beheersen | Nodig voor vrijwel iedere professionele Java-ontwikkelaar |
| Verdiepen | Nodig zodra je dit type systeem bouwt of beheert |
| Herkennen | Weten dat het bestaat, de contracten/risico's kennen en bronnen vinden |
| Historisch | Begrijpen voor onderhoud/migratie; niet kiezen voor nieuw ontwerp zonder reden |

## Taal en types

| Gebied | Niveau | Vindplaats |
|---|---|---|
| syntax, primitives, expressies, control flow | Beheersen | [Taalbasis](./docs/01-taalbasis/README.md) |
| methoden, arrays, strings en Unicode | Beheersen | [Taalbasis](./docs/01-taalbasis/README.md) |
| classes, interfaces, records, enums, sealed types | Beheersen | [Objectoriëntatie](./docs/02-objectorientatie/README.md) |
| generics, wildcards, erasure en inferentie | Beheersen | [Typesysteem](./docs/03-typesysteem/README.md) |
| exceptions, nullability, resources en annotaties | Beheersen | [Typesysteem](./docs/03-typesysteem/README.md) |
| previews, incubators en taalevolutie | Verdiepen | [Modern Java](./docs/16-modern-java/README.md) |

## Java SE-bibliotheek

| Gebied | Niveau | Vindplaats |
|---|---|---|
| collections, equality, ordering en complexiteit | Beheersen | [Collecties](./docs/04-collecties/README.md) |
| lambdas, streams en collectors | Beheersen | [Functioneel Java](./docs/05-functioneel/README.md) |
| numeriek, tijd, regex, locale en utilities | Beheersen | [Standaardbibliotheek](./docs/06-standaardbibliotheek/README.md) |
| bestanden, byte-/tekst-I/O, NIO en archieven | Beheersen | [I/O en NIO](./docs/07-io-nio/README.md) |
| HTTP, sockets, TLS en cryptografie | Verdiepen | [Netwerk en security](./docs/11-netwerk-security/README.md) |
| JDBC, transacties en connection pools | Verdiepen | [Data en JDBC](./docs/12-data-jdbc/README.md) |
| modules, services, reflectie en method handles | Verdiepen | [Reflectie en modules](./docs/10-reflectie-modules/README.md) |
| AWT, Swing, graphics, print, audio en accessibility | Herkennen/verdiepen | [Java SE-breedtekaart](./docs/19-platform-breedte/README.md) |
| XML: DOM, SAX, StAX, XPath, XSLT en schema | Herkennen/verdiepen | [Java SE-breedtekaart](./docs/19-platform-breedte/README.md) |
| JMX, JNDI, RMI, JavaBeans, preferences en scripting | Herkennen/historisch | [Java SE-breedtekaart](./docs/19-platform-breedte/README.md) |

## Concurrency en JVM

| Gebied | Niveau | Vindplaats |
|---|---|---|
| threads, executors, futures, locks en atomics | Beheersen | [Concurrency](./docs/08-concurrency/README.md) |
| virtual threads, scoped values en structured concurrency | Verdiepen | [Concurrency](./docs/08-concurrency/README.md) |
| visibility, ordering, atomicity en happens-before | Beheersen | [Java Memory Model](./docs/08-concurrency/memory-model.md) |
| classfiles, classloading en runtimegeheugen | Verdiepen | [JVM internals](./docs/09-jvm/README.md) |
| GC, JIT, reachability en profiling | Verdiepen | [Geheugen, GC en JIT](./docs/09-jvm/geheugen-gc-jit.md) |
| FFM, JNI, agents en instrumentation | Herkennen/verdiepen | [Expertpraktijk](./docs/17-expert/README.md) |

## Professionele engineering

| Gebied | Niveau | Vindplaats |
|---|---|---|
| unit-, integratie-, property- en performancetests | Beheersen | [Testen](./docs/13-testen/README.md) |
| Maven, Gradle, JAR, dependencies en CI/CD | Beheersen | [Build en tooling](./docs/14-build-tooling/README.md) |
| logging, statische analyse en documentatie | Beheersen | [Build en tooling](./docs/14-build-tooling/README.md) |
| SOLID, patronen, domeinmodellering en architectuur | Beheersen | [Ontwerp en architectuur](./docs/15-architectuur/README.md) |
| security, threat modeling en supply chain | Beheersen/verdiepen | [Netwerk en security](./docs/11-netwerk-security/README.md) |
| performance, JFR, JMH, resilience en incidenten | Verdiepen | [Expertpraktijk](./docs/17-expert/README.md) |
| oefeningen, capstones en interviewbewijs | Beheersen | [Praktijk](./docs/18-praktijk/README.md) |

## Bewuste grenzen

| Buiten de kern | Reden |
|---|---|
| Spring | Expliciet buiten scope; onderliggende Java-concepten zijn wel gedekt |
| Android | Eigen runtime, SDK, lifecycle en platform |
| productspecifieke cloud/application servers | Vendor- en deploymentgebonden |
| ieder individueel API-lid | De officiële Java SE Javadoc is daarvoor de autoriteit |

JavaFX staat in de breedtekaart als het moderne, afzonderlijk geleverde
desktop-ecosysteem; het is geen onderdeel van de Java SE 25-moduleverzameling.
