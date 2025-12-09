# Dragon Treasure

## Projektbeskrivning

**Dragon Treasure** är ett textbaserat äventyrsspel i Java där spelaren navigerar mellan olika rum med hjälp av kommandon. Syftet med uppgiften är att förstå och tillämpa grundläggande objektorienterad programmering i Java. 

Programmet använder klasser
såsom
`Room`, `Door`, `Player` och `Dungeon`.

------------------------------------------------------------------------

## Klassöversikt

### `Door.java`

Representerar en individuell dörr som förbinder två rum.
- Har en position (char: n (north), s (south), e (east), w (west))
- Har ett booleanvärde "locked", lagrar information om dörren är låst eller olåst
- Har en referens till vart dörren leder till (leadsTo)

Syfte: Möjliggöra navigering mellan rum och skapa strukturen av dungeonens "väggar".

Vi valde att inte ha leadsTo i konstruktorn för att separera:
1. skapandet av dörren
2. kopplingen av dörren till ett specifikt rum
Detta ger mer flexibilitet i uppbyggnaden av spellayouten.

------------------------------------------------------------------------

### `Room.java`

Representerar ett individuellt rum i spelet där spelaren kan befinna sig i.
- Lagrar en rumsbeskrivning (roomDesc)
- En array av dörrar (Door[4]) där index representerar väderstreck:
  - 0 = north
  - 1 = south
  - 2 = east
  - 3 = west
- set-metoder för att sätta dörrar i varje riktning
- get-metoder för att hämta befintliga dörrar

Syfte: Att vara navet i spelets värld där varje rum fungerar som ett objekt med sin egen beskrivning och sina egna utgångar.

------------------------------------------------------------------------

### `Player.java`

En klass som representerar spelaren.
- Lagrar spelarens namn
- Har konstruktor + getter/setter

Syfte: Gör det möjligt att hantera spelarinformation.

------------------------------------------------------------------------

### `Dungeon.java`

Hanterar själva spel-logiken och loop.
- Hanterar navigering mellan rum
- Spelar upp välkomstmeddelande

Syfte: 

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

Syfte: 

------------------------------------------------------------------------

## Kommandon

- quit = avslutar spelet
- n, s, e, w = representerar väderstrecken, används för att välja vilken riktning man vill gå
- i = kommando för att  gå in i fängelsehålan.

## Spelflödets struktur

1. asd
2. asd
3. asd
4. Spelet avslutas när spelaren:
   * Skriver kommandot "quit"
   * eller når slutmålet

## Antaganden och Designval

## Körning
För att starta spelet, kör:
    Dungeon.main()
