# Woordenlijst

Java-documentatie en API-namen zijn meestal Engels. Deze woordenlijst geeft
een korte Nederlandse uitleg; de links gaan naar de verdieping.

| Term | Korte betekenis |
|---|---|
| abstractie | Bewuste weergave van relevante eigenschappen terwijl details achter een contract blijven. |
| allocation | Reserveren van geheugen voor een object, array of native segment. |
| annotation | Gestructureerde metadata op een programma-element of typegebruik. |
| API | Publiek contract waarmee softwarecomponenten samenwerken. |
| argument | Concrete waarde die bij een call aan een parameter wordt doorgegeven. |
| array | Object met vaste lengte en elementen van één componenttype. |
| atomic | Observeerbaar als één ondeelbare stateovergang. |
| backpressure | Mechanisme waarmee een tragere consumer de productiesnelheid begrenst. |
| bytecode | JVM-instructies en metadata in een classfile. |
| cache | Gedupliceerde, sneller toegankelijke state met expiry/eviction/coherentiebeleid. |
| callback | Gedrag dat aan andere code wordt gegeven om later aan te roepen. |
| cancellation | Samenwerkingsprotocol om niet langer gewenst werk te stoppen. |
| cast | Expliciete typeconversie of runtimecontrole; verandert een object niet. |
| charset | Mapping tussen bytes en Unicode-tekens. |
| class | Nominaal reference type met state, gedrag, constructors en contract. |
| classloader | Runtimecomponent die classbytes vindt en een type-identiteit definieert. |
| classpath | Zoekpad van directories/JAR's voor classes in de unnamed module. |
| closure | Functieobject dat waarden uit zijn omliggende lexicale scope vastlegt. |
| collector | Beschrijving van mutable reductie van streamelementen naar resultaat. |
| compilation | Vertaling en validatie van broncode naar classfiles. |
| concurrency | Meerdere taken maken voortgang in overlappende tijd. |
| contention | Meerdere uitvoerders concurreren om dezelfde resource/lock. |
| contract | Observeerbare beloften, voorwaarden en failure semantics van een API. |
| covariance | Subtyperelatie volgt dezelfde richting, zoals historisch bij Java-arrays. |
| data race | Conflicterende toegang tot gedeelde state zonder vereiste happens-beforerelatie. |
| deadlock | Cyclische afhankelijkheid waardoor deelnemers blijvend wachten. |
| dependency | Component/type/service die andere code nodig heeft. |
| deoptimization | JIT trekt speculatief geoptimaliseerde code terug als aannames niet meer gelden. |
| deserialisatie | Externe representatie omzetten naar object-/domeinstate. |
| domain event | Waarde die een betekenisvolle voltooide domeingebeurtenis vastlegt. |
| effect | Observeerbare interactie buiten alleen de returnwaarde, zoals I/O of mutatie. |
| encapsulatie | State en beslissingen beschermen achter een ontworpen toegangspunt. |
| encoding | Concrete omzetting van informatie naar een andere representatie. |
| entity | Domeinobject waarvan identiteit de continuïteit bepaalt. |
| erasure | Compileertransformatie waardoor de meeste generieke argumentinformatie runtime niet volledig bestaat. |
| exception | Object dat abrupte voltooiing en foutcontext representeert. |
| executor | Beleid en infrastructuur die ingediende taken uitvoert. |
| expression | Programmadeel dat een waarde oplevert of abrupt voltooit. |
| field | Variabele die bij een class of instance hoort. |
| garbage collector | JVM-component die geheugen van onbereikbare objecten terugwint. |
| generics | Types/leden parametriseren met types om relaties compile-time te bewaken. |
| happens-before | JMM-relatie die ordering en visibility tussen actions garandeert. |
| hash | Getalwaarde die een collection helpt kandidaten te partitioneren; equality blijft doorslaggevend. |
| heap | Gedeeld JVM-runtimegebied waarin gewone objecten/arrays worden beheerd. |
| idempotent | Herhaald uitvoeren heeft volgens het gedefinieerde contract hetzelfde effect als één keer. |
| immutable | Observeerbare waarde verandert niet na constructie. |
| invariant | Voorwaarde die in alle geldige observeerbare toestanden waar blijft. |
| isolation | Mate waarin gelijktijdige transacties elkaars tussentoestand waarnemen. |
| iterator | Stateful cursor die een reeks elementen één voor één levert. |
| JDK | Java Development Kit: runtime, Java SE-libraries en ontwikkeltools. |
| JIT | Just-in-timecompiler die hot bytecode tijdens runtime naar machinecode optimaliseert. |
| JVM | Abstracte/runtime-machine die classfiles laadt, verifieert en uitvoert. |
| lambda | Compacte implementatie van een functionele interface. |
| latency | Tijd tussen begin en resultaat van een operatie, vaak als distributie gemeten. |
| lazy | Berekening wordt uitgesteld tot het resultaat nodig is. |
| lock | Synchronisatieobject dat toegang/coördinatie rond state bewaakt. |
| liveness | Eigenschap dat een systeem uiteindelijk voortgang maakt. |
| memory leak | Logisch onnodige state blijft technisch bereikbaar en wordt niet vrijgegeven. |
| method | Benoemd gedrag met parameters, returntype en eventueel exceptions. |
| module | Benoemde set packages met expliciete dependencies en exports. |
| mutation | Wijziging van bestaande objectstate. |
| native memory | Procesgeheugen buiten de beheerde Java-heap. |
| nullability | Contract of een referentiewaarde `null` mag zijn. |
| object | Runtime-instance van een class/array met identiteit of waardesemantiek. |
| ordering | Gegarandeerde of waargenomen volgorde van actions/elements. |
| ownership | Verantwoordelijkheid voor mutatie, lifetime en vrijgave van een resource. |
| package | Naamruimte en package-private toegangsgrens voor types. |
| parameter | Gedeclareerde invoervariabele van methode, constructor of lambda. |
| polymorfisme | Eén supertypecontract met runtimegedrag van verschillende implementaties. |
| primitive | Ingebouwd niet-reference waardetype zoals `int` of `boolean`. |
| process | OS-isolatie-eenheid met adresruimte en resources. |
| profiling | Gedrag tijdens uitvoering meten door sampling/events/instrumentation. |
| purity | Functie geeft voor dezelfde input hetzelfde resultaat zonder observeerbare side effects. |
| race condition | Correctheid hangt van onbeheerste timing/interleaving af. |
| record | Compacte nominale class voor transparante waardedragers. |
| reference | Waarde die naar een object/array verwijst of `null` is. |
| reflection | Runtime inspecteren en dynamisch gebruiken van types/leden/metadata. |
| resource | Extern of beperkt bezit met lifecycle, zoals file, socket, connection of thread. |
| runtime | Fase/omgeving waarin geladen code wordt uitgevoerd. |
| safe publication | Delen van een volledig geconstrueerd object met JMM-zichtbaarheidsgarantie. |
| scope | Tekstueel/dynamisch bereik waarin een naam, waarde of resource geldig is. |
| serialization | State naar een opslag-/transportrepresentatie omzetten. |
| side effect | Observeerbare wijziging buiten returnwaarde, bijvoorbeeld log, write of mutatie. |
| stack frame | Per-call opslag voor locals, operandstack en returncontext. |
| starvation | Taak krijgt structureel geen benodigde uitvoertijd/resource. |
| stream | Eenmalig te consumeren luie data-processingpipeline, geen opslagstructuur. |
| subtype | Type dat het contract van een supertype moet kunnen vervullen. |
| task | Eenheid van uit te voeren werk, los van de threadkeuze. |
| thread | Sequentiële uitvoeringseenheid binnen een proces/JVM. |
| thread-safe | Contract blijft geldig bij toegestane gelijktijdige toegang. |
| throughput | Hoeveel werk per tijdseenheid wordt voltooid. |
| transaction | Afgebakende groep operaties met afgesproken atomiciteit/isolatie/commitgedrag. |
| type | Verzameling toegestane waarden, operaties en relaties die compiler/runtime kennen. |
| value object | Domeinwaarde waarvan equality door inhoud wordt bepaald. |
| visibility | Garantie dat een read een relevante write kan waarnemen. |
| virtual thread | Door de JVM geplande lichte Java-thread, vooral voor schaalbaar blocking I/O. |
| volatile | Fieldmodifier met specifieke JMM visibility/orderinggaranties. |
| wildcard | Onbekend typeargument (`?`) met eventueel upper/lower bound. |

## Vertaalkeuzes

Sommige termen blijven bewust Engels omdat dit zoekbare Java-termen zijn:

| In dit handboek | Alternatieve Nederlandse omschrijving |
|---|---|
| thread | uitvoeringsdraad |
| stream | gegevensstroom/pipeline |
| heap | dynamisch objectgeheugen |
| stack | aanroepstapel |
| lock | vergrendeling |
| build | bouwproces |
| runtime | uitvoeringsomgeving |
| framework | raamwerk |

Zo kun je dezelfde woorden herkennen in Javadoc, foutmeldingen en
technische gesprekken.
