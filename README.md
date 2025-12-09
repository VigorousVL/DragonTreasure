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
- doNarrative() som:
  - skriver ut rumsbeskrivning
  - skriver ut vilka dörrar som finns att välja

Syfte: Att vara navet i spelets värld där varje rum fungerar som ett objekt med sin egen beskrivning och sina egna utgångar.

I rummet outside använder spelaren kommandot "i" för att gå in i dungeonen.

------------------------------------------------------------------------

### `Player.java`

En enkel klass som representerar spelaren genom att:
- lagra spelarens namn
Just nu används Player enbart för välkomstmeddelandet, men klassen är öppen för framtida utveckling (inventarier, hälsa, nivåsystem m.m.).

Syfte: Gör det möjligt att hantera spelarinformation.

------------------------------------------------------------------------

### `Dungeon.java`

Hanterar spelets huvudlogik genom att:
- hålla reda på alla rum i spelet
- hålla reda på spelarens aktuella position (currentRoom)
- hantera alla kommandon
- navigera mellan rum
- kontrollera om dörrar är låsta
- visa berättelserna för rummen via doNarrative() i Room-klassen.
- avsluta spelet när spelaren skriver "quit".

------------------------------------------------------------------------

### `DragonTreasure.java` (Huvudklass)

Ansvarar för att:
- läsa in spelarens namn
- skapa alla rum
- skapa alla dörrar
- koppla samman dörrar och rum
- skapa Dungeon-objektet
- sätta ett välkomstmeddelande
- starta spelet via dungeon.playgame()
- avsluta spelet genom endGame()

Syfte: Vara uppstartspunkten för hela spelet.

------------------------------------------------------------------------

## Kommandon

Nedanstående tabell representerar spelets alla kommandon:

| Kommando | Funktion                                  |
| -------- | ----------------------------------------- |
| **n**    | Gå norrut                                 |
| **s**    | Gå söderut                                |
| **e**    | Gå österut                                |
| **w**    | Gå västerut                               |
| **i**    | Gå in i dungeonen (endast från `outside`) |
| **quit** | Avsluta spelet                            |

------------------------------------------------------------------------

## Spelvärldens struktur
* outside
* entranceHall
* echoingPassage
* alchemistLab
* swordForge
* skeletonKeep
* dragonLair
* monsterDungeon
Varje rum har sin egen textbeskrivning i doNarrative().

Dörrar kopplar samman rummen enligt ett fordefinierat nätverk, där vissa dörrar är låsta och inte kan passeras.

## Antaganden och Designval

## Körning
Vid spelstart ombeds spelaren att skriva sitt namn.

Därefter visas välkomstmeddelandet och spelet börjar.
