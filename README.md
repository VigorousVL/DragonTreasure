# 🐉 Dragon Treasure

Ett textbaserat äventyrsspel i **Java** där du utforskar en dungeon, plockar upp föremål, låser upp dörrar och slåss mot monster för att till slut komma åt skatten.

## 🎯 Mål
Du vinner spelet när du **plockar upp Treasure** (skatten).  
Skatten är **vaktad av en drake** – du kan inte ta den förrän monstret i rummet är besegrat.

Du förlorar om din **HP når 0** i strid.

---

## 🎮 Så spelar du

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

---

## ⚔️ Stridssystem

När du skriver `fight` i ett rum med monster startar en battle-loop.

I strid väljer du:
- `[a]` attack – du gör skada baserat på din totala skada
- `[p]` potion – använder en potion från inventory (förbrukas)
- `[r]` run – fly från striden (du stannar kvar i rummet)

Monstret attackerar efter din tur (om det fortfarande lever).  
Striden slutar när du flyr, monstret dör eller du dör.

---

## 🎒 Items

Alla föremål ärver från `Item`:

- **Key**  
  Används för att låsa upp låsta dörrar (kontrolleras automatiskt vid rörelse).

- **Weapon**  
  Ökar din skada. Exempel: ett svärd kan ge `+2` damage.

- **Potion**  
  Helar dig med ett visst antal HP (men HP kan aldrig bli högre än 10). Förbrukas vid användning.

- **Treasure**  
  Skatten du behöver ta för att vinna.

---

## 👾 Monster

- **Monster** – grundklass för fiender (namn, HP, damage, beskrivning)
- **Dragon** – ärver från `Monster` och har fasta stats: **18 HP** och **1 damage**
- Exempel på vanligt monster i spelet: **Goblin** med **8 HP** och **1 damage**

---

## 🧱 Projektstruktur

Klasserna ligger i paketet `dragontreasure`:

```
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
```

---

## 📝 Klassöversikt (kort)

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

---
