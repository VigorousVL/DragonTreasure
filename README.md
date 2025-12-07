# Dragon Treasure

## Projektbeskrivning

**Dragon Treasure** är ett textbaserat äventyrsspel i Java där spelaren navigerar mellan olika rum med hjälp av kommandon. Syftet med uppgiften är att förstå och tillämpa grundläggande objektorienterad programmering i Java. 

Programmet använder klasser
såsom
`Room`, `Door`, `Player` och `Dungeon`.

------------------------------------------------------------------------

## Klassöversikt

### `Door.java`

Representerar individuella dörrar.
- Har en position (north, south, east, west)
- Har information om dörren är låst eller olåst
- Har en referens till vart dörren leder till

------------------------------------------------------------------------

### `Room.java`

Representerar ett individuellt rum i grottan.
- Lagrar rumsbeskrivningar
- Håller vilka dörrar som finns i varje riktning
- Metoder för att sätta och hämta dörrar

------------------------------------------------------------------------

### `Player.java`

En enkel klass som representerar spelaren.
- Lagrar spelarens namn

------------------------------------------------------------------------

### `Dungeon.java`

Hanterar själva spel-loopen.
- Hanterar navigering mellan rum
- Spelar upp välkomstmeddelande

------------------------------------------------------------------------

### `DragonTreasure.java` (Huvudklass)

Ansvarar för att:
- Starta och avsluta spelet
- Skapa rum
- Skapa dörrar
- Sätta dörrarnas riktning + koppla till rum
- Skapa Dungeon
- Skapa välkomstmeddelande
- Skapa spelare

------------------------------------------------------------------------

## Kommandon

- quit = avslutar spelet
- n, s, e, w = representerar väderstrecken, används för att välja vilken riktning man vill gå
- i = kommando för att  gå in i fängelsehålan.
