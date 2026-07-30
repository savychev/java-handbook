# 14 — Build, dependencies en tooling

[← Testen](../13-testen/README.md) ·
[Inhoudsopgave](../../INHOUDSOPGAVE.md) ·
[Ontwerp en architectuur →](../15-architectuur/README.md)

Een build vertaalt broncode en declaratieve metadata naar een reproduceerbaar,
testbaar en publiceerbaar artifact.

## Reproduceerbare keten

```mermaid
flowchart LR
    A["Bron + lock/config"] --> B["Compile"]
    B --> C["Test"]
    C --> D["Analyse"]
    D --> E["Package"]
    E --> F["Artifact + provenance"]
```

Dezelfde commit hoort onder vastgelegde toolchains en dependencies hetzelfde
functionele artifact te leveren. Vermijd tijdstempels, netwerkafhankelijke
generatie en ongespecificeerde pluginversies.

## Maven

Maven gebruikt een Project Object Model (`pom.xml`) en conventies.

Kernlifecycle:

```text
validate → compile → test → package → verify → install → deploy
```

Een latere fase voert eerdere fasen uit. Typisch:

```bash
./mvnw --batch-mode verify
```

Minimaal:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>nl.handboek</groupId>
  <artifactId>voorbeeld</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <properties>
    <maven.compiler.release>25</maven.compiler.release>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
</project>
```

Leg pluginversies centraal vast. Parent-POM's en BOM's kunnen configuratie en
dependencyversies beheren; begrijp wat je erft.

### Scopes

| Scope | Compile | Test | Runtime artifact/classpath |
|---|:---:|:---:|:---:|
| `compile` | ✓ | ✓ | ✓ |
| `provided` | ✓ | ✓ | verwacht extern |
| `runtime` |  | ✓ | ✓ |
| `test` |  | ✓ |  |

`system` is vrijwel altijd een slecht portable pad. `optional` beïnvloedt hoe
consumers transitieve dependency zien; het is geen runtime feature flag.

## Gradle

Gradle modelleert taken en een dependencygraph. Gebruik bij voorkeur de
Gradle Wrapper en Kotlin DSL voor typeondersteuning:

```kotlin
plugins {
    java
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.test {
    useJUnitPlatform()
}
```

Taken moeten inputs/outputs declareren voor up-to-date checks, caching en
reproduceerbaarheid. Vermijd side effects tijdens configuration phase.

Maven en Gradle zijn alternatieven; kies op team/ecosysteem en houd één
autoritatieve build.

## Wrapper en toolchains

- Wrapper pinnt buildtoolversie en downloadbron/checksum.
- Java toolchain pinnt compile/test JDK onafhankelijk van de JVM waarmee de
  buildtool zelf draait.
- `--release` bepaalt taal, classfile en zichtbare Java SE-API.

Commit wrapperconfiguratie en scripts; verifieer de distributiechecksum.

## Dependencyresolution

Een dependencygraph bevat directe en transitieve dependencies.

```bash
mvn dependency:tree
./gradlew dependencies
```

Risico's:

- versieconflict/nearest-wins;
- duplicate classes;
- split packages/modules;
- compile/runtimeverschil;
- kwetsbare of verlaten dependency;
- dynamische/SNAPSHOT-versie;
- licentie/provenance.

Pin versions via dependency management/version catalog. Lock waar
reproduceerbaarheid dat vraagt. Update regelmatig in kleine, geteste stappen.

### API versus implementation dependency

Een dependency in publieke signatures lekt naar consumers en beperkt evolutie.
Houd implementatiedetails achter eigen interfaces en modules. Shading kan
conflicten isoleren, maar verandert resources, licenses en reflectieve namen;
test het artifact.

## Semantische versie en compatibility

`MAJOR.MINOR.PATCH` is alleen betekenisvol met een gepubliceerd
compatibiliteitsbeleid. Java-librarycompatibiliteit heeft meerdere assen:

| As | Voorbeeld van breuk |
|---|---|
| bron | methode-overload maakt call ambigu |
| binair | bestaande methode/field verwijderd |
| gedrag | resultaat/exception verandert |
| serialisatie | wire/objectvorm verandert |
| performance | complexiteit of latency verslechtert |
| module | package niet meer exported |

Een additive overload kan dus broncode breken zonder bestaande binaries te
breken.

## Artifacts

### JAR

Een JAR is ZIP plus metadata:

```bash
jar --create --file app.jar --main-class nl.handboek.App -C target/classes .
java -jar app.jar
```

Types:

- library JAR;
- executable/fat/uber JAR;
- modular JAR met `module-info.class`;
- multi-release JAR voor versiespecifieke classes.

Fat JAR assembly moet servicefiles, signatures en duplicates correct
behandelen.

### Runtime en installer

- `jdeps`: moduledependencies.
- `jlink`: custom runtime-image.
- `jpackage`: OS-pakket met runtime/app.

Een containerimage is een andere distributielaag; kies een ondersteunde JRE/JDK,
non-root user, resource awareness en kleine, patchbare base.

## Logging

Gebruik een logging facade/API en configureer implementatie op applicatiegrens.
Java SE bevat `System.Logger` en `java.util.logging`; ecosystemen gebruiken
vaak SLF4J met een backend.

Goed event:

```java
logger.atInfo()
        .addKeyValue("bestellingId", bestelling.id())
        .addKeyValue("duurMs", duur.toMillis())
        .log("Bestelling verwerkt");
```

Principes:

- severity heeft operationele betekenis;
- structured fields boven geparste zinnen;
- correlation/trace-id;
- exception één keer op verantwoordelijke grens;
- geen secrets/gevoelige payload;
- rate limiting/sampling bij volume;
- parameterized/lazy logging voor duur werk.

`System.out.println` is bruikbaar in kleine oefeningen, geen observabilityplan.

## Codekwaliteit

| Toolcategorie | Vindt |
|---|---|
| formatter | consistente layout |
| compilerwarnings | type/deprecation/uncheckedproblemen |
| static analysis | bugpatronen/dataflow |
| style checker | conventies en verboden constructies |
| dependency scanner | bekende supply-chainrisico's |
| coverage/mutation | testgaten |
| API compatibility | publieke breuken |

Maak waarschuwingen actiegericht en baselines tijdelijk. Een toolregel zonder
begrepen risico leidt tot suppressions in plaats van kwaliteit.

## Javadoc

Documenteer publieke contracts:

- betekenis, units en nullability;
- pre-/postcondities;
- exceptions;
- mutability/thread-safety;
- ownership/lifecycle;
- versie/preview;
- complexe performancekarakteristieken.

Schrijf niet alleen de methodenaam in een zin opnieuw. Publiceer Javadoc in CI
en behandel warnings serieus.

## Git

Praktische discipline:

- kleine samenhangende commits;
- geen secrets/buildoutput;
- branch protection en review;
- duidelijke commit/PR-context;
- tests bij de wijziging;
- release tags en changelog;
- gegenereerde lockfiles/wrappers bewust beheren.

Een `.gitignore` verwijdert reeds getrackte bestanden niet.

## CI/CD

Pipelinevragen:

1. Is de build vanaf lege checkout reproduceerbaar?
2. Zijn JDK en buildtool gepind?
3. Zijn unittests, integratietests en analyse gescheiden zichtbaar?
4. Is artifact eenmaal gebouwd en daarna bevorderd?
5. Zijn secrets minimaal en per omgeving?
6. Is dependency-/artifactprovenance vastgelegd?
7. Is deploy atomair/rollbackbaar?
8. Zijn migrations compatibel met rolling deploy?

Cache dependencies, niet blind buildoutputs waarvan inputs niet correct zijn
gedeclareerd.

## Veelgemaakte fouten

- Alleen in IDE kunnen bouwen.
- Wrapper/toolchain/pluginversies niet vastleggen.
- `latest` of dynamische dependencyversies.
- Een fat JAR maken zonder resource/service merging te testen.
- Iedere warning onderdrukken.
- Logs als vrije tekst zonder context of met secrets.
- In deploy opnieuw bouwen in plaats van hetzelfde artifact bevorderen.
- Librarycompatibiliteit reduceren tot alleen semantic versioning.

## Checklist

- [ ] Eén command bouwt vanaf schone checkout.
- [ ] Wrapper, JDK-toolchain, release en plugins zijn reproduceerbaar.
- [ ] Ik kan dependencygraph/scopes/conflicten analyseren.
- [ ] Packaging en runtimevorm zijn bewust gekozen en getest.
- [ ] Logging is gestructureerd, begrensd en privacyveilig.
- [ ] CI bouwt, test, analyseert en bevordert één artifact.
- [ ] Publieke API-evolutie houdt bron/binary/behavior/module in rekening.

## Verder

- [Ontwerp en architectuur](../15-architectuur/README.md)
- [Reflectie en modules](../10-reflectie-modules/README.md)
- [Expertpraktijk](../17-expert/README.md)
