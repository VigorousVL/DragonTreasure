# DragonTreasure
D0019N assignment project - DragonTreasure 

Projektbeskrivning:
Dragon Treasure är ett textbaserat äventyrsspel i Java där spelaren navigerar mellan olika rum med hjälp av kommandon. Syftet med uppgiften är att förstå och tillämpa grundläggande objektorienterad programmering i Java. 

Klassöversikt:
DragonTreasure
	• Startar och avslutar spelet
	• Skapar rum
	• Skapar dörrar
	• Sätter dörrens riktning + kopplar till rum
	• Skapar Dungeon
	• Skapar välkomstmeddelande
	• Skapar spelare

Dungeon
	• Hanterar själva spel-loopen
	• Hanterar navigering mellan rum
	• Spelar upp välkomstmeddelande

Room
	• Lagrar rumsbeskrivningar
	• Håller vilka dörrar som finns i varje riktning
	• Metoder för att sätta och hämta dörrar

Door
	• Representerar individuella dörrar
	• Har en position (north, south, east, west)
	• Har information om dörren är låst eller olåst
	• Har referens till vart dörren leder till

Player
	• Lagrar spelarens namn

Kommandon:
quit = avslutar spelet
n, s, e, w = representerar väderstrecken, används för att välja vilken riktning man vill gå
i = kommando för att  gå in i fängelsehålan.
