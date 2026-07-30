# Bijdragen

Correcties en verduidelijkingen zijn welkom. Dit repository kiest
zorgvuldigheid boven omvang om de omvang.

## Een inhoudelijke wijziging voorstellen

1. Open een issue met het concrete probleem en de gebruikte Java-versie.
2. Koppel taal- en JVM-claims aan een primaire bron.
3. Houd uitleg in helder Nederlands; behoud officiële API-namen in het Engels.
4. Markeer preview-, incubator- en implementatiespecifiek gedrag.
5. Voeg bij code minstens het verwachte resultaat of een testbare eigenschap toe.

## Schrijfstijl

- Spreek de lezer aan met **je**.
- Introduceer een term vóór je de afkorting gebruikt.
- Scheid taalregels, API-contracten en HotSpot-implementatiedetails.
- Gebruik kleine codevoorbeelden met betekenisvolle namen.
- Vermijd “altijd” en “nooit” als het contract uitzonderingen kent.
- Gebruik Mermaid alleen als relaties of volgorde visueel duidelijker worden.

## Lokale controles

```bash
mvn -f examples/pom.xml verify
npx markdownlint-cli2 "**/*.md"
```

De GitHub Actions-workflow controleert daarnaast interne en externe links.

## Scope

Spring blijft bewust buiten scope. Een voorstel mag wel een onderliggend
Java-concept behandelen dat vaak door Spring wordt gebruikt, zoals reflectie,
proxies, JDBC, HTTP, annotatieverwerking of dependency inversion.
