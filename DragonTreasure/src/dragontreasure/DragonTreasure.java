
package dragontreasure;

import java.util.Scanner; 

public class DragonTreasure { 

    public static void main(String[] args) { 
     DragonTreasure game = new DragonTreasure(); //Skapar nytt objekt av DragonTreasure
     game.setupGame(); //objektet game anropar metod setUpGame }
    }
      
    public void setupGame() { 
      
        Scanner input = new Scanner(System.in); 
        
        //Skapa spelare
            System.out.println("Hello, what is your name?"); //text som ber spelaren att ange sitt namn
            System.out.print("> ");  //prompt till spelaren för att fylla i namn
            String name = input.nextLine(); //Läser in namnet som spelaren skriver och sparar det i variabeln name.
            Player player = new Player(name); // Skapar ett nytt Player-objekt och lagrar det i variabeln player. Anropar Player-konstruktorn och skickar in variabeln name som argument.
        
        //Skapa rum
            Room outside = new Room ("outside"); //new Room("outside") skapar ett nytt Room-objekt och sätter rummets beskrivning (roomDesc) till "outside". Det skapade rummet sparas i variabeln outside, så att spelet kan använda rummet senare.
            Room entranceHall = new Room("entranceHall");
            Room echoingPassage = new Room("echoingPassage");
            Room crystalGrotto = new Room("crystalGrotto");
            Room alchemistLab = new Room ("alchemistLab");
            Room chamberOfWhispers = new Room("chamberOfWhispers");
            Room swordForge = new Room("swordForge");
            Room skeletonKeep = new Room("skeletonKeep");
            Room dragonsLair = new Room("dragonsLair");
            Room monsterDungeon = new Room("monsterDungeon");
               
        // Deklaration av array 'rooms', innehåller alla rum i spelet. Skickas till Dungeon för att hålla reda på och navigera mellan rum.
           Room[] rooms = {outside, entranceHall, echoingPassage, crystalGrotto, alchemistLab, chamberOfWhispers, swordForge, skeletonKeep, dragonsLair, monsterDungeon};       
         
            
         // Skapa dörrar + sätt riktning
         Door entranceToEchoing = new Door ('n',false); // Skapar en ny Door. Parametrarna är dörrens riktning ('n') och om den är låst (false = olåst).
         entranceToEchoing.setLeadsTo(echoingPassage); // Anger vilket rum dörren leder till. Dörr-objektet får echoingPassage (roomDesc) som destination.
         Door entranceToCrystal = new Door ('s', false);
         entranceToCrystal.setLeadsTo(crystalGrotto);
         Door entranceToAlchemist = new Door ('e', false);
         entranceToAlchemist.setLeadsTo(alchemistLab);
         Door echoingToEntrance = new Door ('s', false);
         echoingToEntrance.setLeadsTo(entranceHall);
         Door echoingToChamber = new Door ('e', false);
         echoingToChamber.setLeadsTo(chamberOfWhispers);
         Door crystalToEntrance = new Door ('n', false);
         crystalToEntrance.setLeadsTo(entranceHall);
         Door crystalToSword = new Door ('e', false);
         crystalToSword.setLeadsTo(swordForge);
         Door alchemistToEntrance = new Door ('w', false);
         alchemistToEntrance.setLeadsTo(entranceHall);
         Door alchemistToChamber = new Door ('n', false);
         alchemistToChamber.setLeadsTo(chamberOfWhispers);
         Door alchemistToSword = new Door ('s',  false);
         alchemistToSword.setLeadsTo(swordForge);
         Door alchemistToSkeleton = new Door ('e', false);
         alchemistToSkeleton.setLeadsTo(skeletonKeep);
         Door chamberToEchoing = new Door ('w', false);
         chamberToEchoing.setLeadsTo(echoingPassage);
         Door chamberToAlchemist = new Door ('s', false);
         chamberToAlchemist.setLeadsTo(alchemistLab);
         Door chamberToDragons = new Door ('e', true);
         chamberToDragons.setLeadsTo(dragonsLair);
         Door swordToAlchemist = new Door ('n', false);
         swordToAlchemist.setLeadsTo(alchemistLab);
         Door swordToCrystal = new Door ('w', false);
         swordToCrystal.setLeadsTo(crystalGrotto);
         Door swordToMonster = new Door ('e', false);
         swordToMonster.setLeadsTo(monsterDungeon);
         Door skeletonToAlchemist = new Door ('w', false);
         skeletonToAlchemist.setLeadsTo(alchemistLab);
         Door skeletonToDragons = new Door ('n', true);
         skeletonToDragons.setLeadsTo(dragonsLair);
         Door skeletonToMonster = new Door ('s', false);
         skeletonToMonster.setLeadsTo(monsterDungeon);
         Door dragonsToChamber = new Door ('w', false);
         dragonsToChamber.setLeadsTo(chamberOfWhispers);
         Door dragonsToSkeleton = new Door ('s', false);
         dragonsToSkeleton.setLeadsTo(skeletonKeep);
         Door monsterToSword = new Door ('w', false);
         monsterToSword.setLeadsTo(swordForge);
         Door monsterToSkeleton = new Door ('n', false);
         monsterToSkeleton.setLeadsTo(skeletonKeep);
         
         //Koppla dörrar till rum och position
         entranceHall.setNorthDoor(entranceToEchoing); // Kopplar en dörr till ett rum i en viss riktning. setNorthDoor anger att denna dörr är rummets norra utgång.
         entranceHall.setSouthDoor(entranceToCrystal);
         entranceHall.setEastDoor(entranceToAlchemist);
         echoingPassage.setSouthDoor(echoingToEntrance);
         echoingPassage.setEastDoor(echoingToChamber);
         crystalGrotto.setNorthDoor(crystalToEntrance);
         crystalGrotto.setEastDoor(crystalToSword);
         alchemistLab.setWestDoor(alchemistToEntrance);
         alchemistLab.setNorthDoor(alchemistToChamber);
         alchemistLab.setSouthDoor(alchemistToSword);
         alchemistLab.setEastDoor(alchemistToSkeleton);
         chamberOfWhispers.setWestDoor(chamberToEchoing);
         chamberOfWhispers.setSouthDoor(chamberToAlchemist);
         chamberOfWhispers.setEastDoor(chamberToDragons);
         swordForge.setNorthDoor(swordToAlchemist);
         swordForge.setWestDoor(swordToCrystal);
         swordForge.setEastDoor(swordToMonster);
         skeletonKeep.setNorthDoor(skeletonToDragons);
         skeletonKeep.setWestDoor(skeletonToAlchemist);
         skeletonKeep.setSouthDoor(skeletonToMonster);
         dragonsLair.setWestDoor(dragonsToChamber);
         dragonsLair.setSouthDoor(dragonsToSkeleton);
         monsterDungeon.setWestDoor(monsterToSword);
         monsterDungeon.setNorthDoor(monsterToSkeleton);
                
        //Skapar ett nytt Dungeon-objekt
        Dungeon dungeon = new Dungeon(rooms, this); 
        
        //anropar metod setWelcomeMessage från Dungeon.Skickar in en sträng som består av välkomsttext + spelarens namn (hämtat via player.getName())samt instruktion för hur man avslutar spelet.
        dungeon.setWelcomeMessage ("Welcome to Dragon Treasure " + player.getName() + "! You can end game whenever by  writing [quit].");
            
        //Startar spelet genom att anropa metoden playGame() i Dungeon.
        dungeon.playGame();         
    }
    
    public void endGame() { 
        System.out.printf("%n" + "Thank you for playing, goodbye!" + "%n");
    }
}
