# Bronnen

Dit handboek parafraseert primaire documentatie. Bij twijfel hebben de
specificaties en de documentatie van de gebruikte release voorrang.

## Taal, VM en platform

- [Java Language Specification, Java SE 25][jls]
- [Java Virtual Machine Specification, Java SE 25][jvms]
- [Java SE 25 API-documentatie][api]
- [Java SE 25-moduleoverzicht][java-se]
- [JDK 25-documentatie][jdk-docs]
- [JDK 25-project en JEP-lijst][jdk-25]
- [JDK 26-project en JEP-lijst][jdk-26]
- [JEP Index][jeps]
- [Java SE Support Roadmap][roadmap]

## Verdieping per domein

- [HotSpot VM en garbage-collectiongidsen][vm-guides]
- [Java Flight Recorder API Guide][jfr]
- [Java Security Guide][security]
- [Secure Coding Guidelines for Java SE][secure-coding]
- [JDK Tool Specifications][tools]
- [Java Platform Module System][jpms]
- [dev.java — officiële leerartikelen][dev-java]
- [OpenJFX-documentatie][openjfx]

## Ecosysteem

Voor tools buiten Java SE verwijst een hoofdstuk naar het eigen project:

- [Apache Maven-documentatie][maven]
- [Gradle User Manual][gradle]
- [JUnit 6 User Guide][junit]
- [JMH-project][jmh]

Versies van externe libraries staan bewust niet centraal in conceptuele
voorbeelden. Controleer voor een echt project altijd de actuele release notes,
compatibiliteit en security-informatie.

## Hoe bronnen te lezen

| Vraag | Beste bron |
|---|---|
| Is deze syntax geldig? | JLS |
| Hoe is een classfile of instructie gedefinieerd? | JVMS |
| Wat belooft een methodecontract? | API-documentatie |
| Waarom is een functie ontworpen? | JEP |
| Wat veranderde in één JDK-release? | release notes |
| Hoe gedraagt HotSpot zich praktisch? | VM-/toolgids en meting |

[jls]: https://docs.oracle.com/javase/specs/jls/se25/html/
[jvms]: https://docs.oracle.com/javase/specs/jvms/se25/html/
[api]: https://docs.oracle.com/en/java/javase/25/docs/api/
[java-se]: https://docs.oracle.com/en/java/javase/25/docs/api/java.se/module-summary.html
[jdk-docs]: https://docs.oracle.com/en/java/javase/25/
[jdk-25]: https://openjdk.org/projects/jdk/25/
[jdk-26]: https://openjdk.org/projects/jdk/26/
[jeps]: https://openjdk.org/jeps/0
[roadmap]: https://www.oracle.com/java/technologies/java-se-support-roadmap.html
[vm-guides]: https://docs.oracle.com/en/java/javase/25/vm/
[jfr]: https://docs.oracle.com/en/java/javase/25/jfapi/
[security]: https://docs.oracle.com/en/java/javase/25/security/
[secure-coding]: https://www.oracle.com/java/technologies/javase/seccodeguide.html
[tools]: https://docs.oracle.com/en/java/javase/25/docs/specs/man/
[jpms]: https://openjdk.org/projects/jigsaw/spec/
[dev-java]: https://dev.java/
[openjfx]: https://openjfx.io/openjfx-docs/
[maven]: https://maven.apache.org/guides/
[gradle]: https://docs.gradle.org/current/userguide/userguide.html
[junit]: https://docs.junit.org/6.1.2/
[jmh]: https://github.com/openjdk/jmh
