# Dragon Treasure

Ett textbaserat äventyrsspel i **Java** där du utforskar en dungeon, plockar upp föremål, låser upp dörrar och slåss mot monster för att till slut komma åt skatten.

## Mål
Du vinner spelet när du **plockar upp Treasure** (skatten).  
Skatten är **vaktad av en drake** – du kan inte ta den förrän monstret i rummet är besegrat.

Du förlorar om din **HP når 0** i strid.

## Så spelar du

När spelet startar:
1. Du skriver in ditt namn
2. Du börjar i rummet **Outside**
3. Varje tur skrivs rumsbeskrivning, eventuella items/monster och vilka vägar som finns
4. Du skriver ett kommando och spelet fortsätter tills du vinner, dör eller skriver `quit`

### Kommandon (utforskning)
- `n` `s` `e` `w` – gå norr/söder/öst/väst
- `take` – plocka upp item i rummet (om det finns)
- `inventory` – visa inventory + din HP och skada
- `potion` – använd en potion (om du har en) även utanför strid
- `fight` – starta strid om det finns ett monster i rummet
- `quit` – avsluta spelet

> Obs: Om du försöker gå genom en **låst dörr** behöver du en **Key** i din inventory. Har du en nyckel låses dörren upp automatiskt när du försöker gå igenom den.

## Stridssystem

När du skriver `fight` i ett rum med monster startar en battle-loop.

I strid väljer du:
- `[a]` attack – du gör skada baserat på din totala skada
- `[p]` potion – använder en potion från inventory (förbrukas)
- `[r]` run – fly från striden (du stannar kvar i rummet)

Monstret attackerar efter din tur (om det fortfarande lever).  
Striden slutar när du flyr, monstret dör eller du dör.

## Items

Alla föremål ärver från `Item`:

- **Key**  
  Används för att låsa upp låsta dörrar (kontrolleras automatiskt vid rörelse).

- **Weapon**  
  Ökar din skada. Exempel: ett svärd kan ge `+2` damage.

- **Potion**  
  Helar dig med ett visst antal HP (men HP kan aldrig bli högre än 10). Förbrukas vid användning.

- **Treasure**  
  Skatten du behöver ta för att vinna.

## Monster

- **Monster** – grundklass för fiender (namn, HP, damage, beskrivning)
- **Dragon** – ärver från `Monster` och har fasta stats: **18 HP** och **1 damage**
- Exempel på vanligt monster i spelet: **Goblin** med **8 HP** och **1 damage**

## Projektstruktur

Klasserna ligger i paketet `dragontreasure`:

dragontreasure/
  ├── DragonTreasure.java      (main + setup)
  ├── Dungeon.java             (spel-loop + kommandon)
  ├── Room.java                (rum, narrative + battle)
  ├── Door.java                (dörrar, låsta/olåsta)
  ├── Player.java              (HP, inventory, damage)
  ├── Monster.java             (fiender)
  ├── Dragon.java              (specifikt monster)
  ├── Item.java                (abstract basklass)
  ├── Key.java
  ├── Weapon.java
  ├── Potion.java
  └── Treasure.java

## Klassöversikt (kort)

- **DragonTreasure**  
  Skapar spelare, rum, dörrar, items och monster och startar spelet.

- **Dungeon**  
  Håller spelets huvudloop: visar rummet (`doNarrative`), tar kommandon, hanterar rörelse, inventory, att ta items och att starta strid.

- **Room**  
  Innehåller beskrivning, upp till 4 dörrar, max 1 item och max 1 monster. Har även stridslogik via `doBattle(Player)`.

- **Door**  
  Har riktning (`n/s/e/w`), kan vara låst och pekar på vilket rum den leder till.

- **Player**  
  Har namn, HP (start 10), base damage (start 1) och en `ArrayList<Item>` som inventory. Skadan påverkas av vapenbonusar.

- **Item** (+ underklasser)  
  Basklass för alla items. Underklasserna implementerar nyckel, vapen, potion och treasure.

- **Monster** (+ Dragon)  
  Fiender med HP och damage. `Dragon` är en specialiserad fiende.

## Antaganden

- **Allmänna antaganden**  
  - Spelaren befinner sig alltid i exakt ett rum åt gången.
  - Ett rum kan ha maximalt fyra dörrar (norr, söder, väst eller öst), vilket styr hur
    rummen kopplas samman. 
  - Alla rum skapas vid programmets start och kopplas sedan ihop med dörrar.
  - Vi utgår från att spelet fortsätter tills spelaren skriver “quit” eller tills man tagit skatten.

- **Antaganden kring dörrar**  
  - En dörr är definierad av:
      - En riktning (n, s, e, w)
      - Om den är låst eller olåst.
      - Vilket rum den leder till.
  - Varje dörr är enkelriktad. Det innebär att om ett rum kan gå österut till ett annat rum måste en separat väst-dörr skapas i det andra rummet om navigering ska vara möjlig tillbaka.

- **Antaganden kring Room-klassen**  
  - Ansvarar för beskrivning av rummet, upp till fyra dörrar, upp till ett item och upp till ett monster.
  - Ansvarar för stridslogiken som sker i rummet.
  - Tar bort item och monster från rummet när de plockas upp eller besegras.

- **Antaganden kring Dungeon och spel-loopen**  
  - Dungeon styr spel-loop och navigationslogik
  - Spelaren kan bara röra sig i de riktingar som rummet har dörrar till.
  - Om spelaren försöker gå genom en dörr som inte finns, visas ett meddelande och spelaren stannar kvar i samma rum.
  - Spelet avslutas när spelaren skriver quit, när spelaren dör, eller när Dungeon anropar metoden endGame() i huvudklassen.
  - Spelet startar alltid i rooms[0], vilket i vår design är rummet “outside”.

- **Antaganden kring huvudklassen DragonTeasure**  
  - Huvudklassen ansvarar för att skapa:
    - Alla rum
    - Alla dörrar
    - Alla kopplingar mellan rummen
    - Spelaren
    - Dungeon-instansen
    - Items
    - Monster
  - Huvudklassen innehåller ingen spel-logik utan används enbart för setup.
  - Därefter startar huvudklassen spelet med dungeon.playGame().

