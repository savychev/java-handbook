# Versiebeleid

## Referentiepunt

| Onderdeel | Keuze |
|---|---|
| Hoofdversie | Java 25 LTS |
| Actuele feature release | Java 26 |
| Minimale historische context | Java 8 |
| Build van de voorbeelden | `--release 25` |
| Previewfuncties | Alleen expliciet gelabeld |

Java 25 verscheen in september 2025 en is een LTS-release. Java 26 verscheen
in maart 2026 en is een niet-LTS-release. De eerstvolgende geplande LTS is
Java 29. Zie de [officiële supportroadmap][support-roadmap].

## Labels in dit handboek

- **Stabiel sinds Java N** — onderdeel van de definitieve taal of API.
- **Preview in Java N** — volledig gespecificeerd, maar kan nog veranderen en
  vereist doorgaans `--enable-preview`.
- **Incubator** — niet-finale API in een `jdk.incubator.*`-module.
- **Experimenteel** — JVM-optie of implementatiedetail zonder stabiel contract.
- **Verwijderd/verouderd** — niet gebruiken voor nieuw ontwerp.

## Compileren met previews

```bash
javac --release 26 --enable-preview Voorbeeld.java
java --enable-preview Voorbeeld
```

Gebruik hetzelfde releasenummer voor compileren en uitvoeren. Publiceer geen
library-artifact dat ongemerkt van preview-classfiles afhankelijk is.

## Wat `--release` oplost

`javac --release 21` beperkt zowel taalniveau als zichtbare gedocumenteerde
Java SE-API tot release 21. Alleen `-source 21 -target 21` gebruiken is
onvoldoende: daarmee kun je per ongeluk een nieuwere API aanroepen en toch
oudere classfileversies produceren.

## Onderhoud

Bij iedere halfjaarlijkse Java-release:

1. controleer de officiële JDK-projectpagina en release notes;
2. werk alleen definitieve JEP-statussen bij;
3. verplaats gewijzigde previews, maar herschrijf stabiele uitleg niet zonder reden;
4. test alle voorbeelden op de hoofd-LTS;
5. noteer incompatibele verwijderingen en migratie-impact.

[support-roadmap]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
