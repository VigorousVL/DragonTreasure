
package dragontreasure2;

import java.util.Scanner;

public class DragonTreasure2 {

    public static void main(String[] args) {
     DragonTreasure2 game = new DragonTreasure2(); //Skapar nytt spel
     game.setupGame(); //För att kunna starta
    }
      
    public void setupGame() {  //Förbereder spelstart
      
        Scanner input = new Scanner(System.in);
        
        //Skapa spelare
            System.out.println("Hello, what is your name?");
            System.out.print("> ");
            String name = input.nextLine();
            Player player = new Player(name);
        
        //Skapa rum
            Room outside = new Room ("outside");
            Room entranceHall = new Room("entranceHall");
            Room echoingPassage = new Room("echoingPassage");
            Room crystalGrotto = new Room("crystalGrotto");
            Room alchemistLab = new Room ("alchemistLab");
            Room chamberOfWhispers = new Room("chamberOfWhispers");
            Room swordForge = new Room("swordForge");
            Room skeletonKeep = new Room("skeletonKeep");
            Room dragonsLair = new Room("dragonsLair");
            Room monsterDungeon = new Room("monsterDungeon");
               
        // skapa array rooms
            Room[] rooms = {outside, entranceHall, echoingPassage, crystalGrotto, alchemistLab, chamberOfWhispers, swordForge, skeletonKeep, dragonsLair, monsterDungeon};       
            
         // Skapa dörrar + sätt riktning
         Door entranceToEchoing = new Door ('n',false); //Skapa dörr
         entranceToEchoing.setLeadsTo(echoingPassage); //sätt riktning på dörr
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
         
         //Koppla dörrar till rum
         entranceHall.setNorthDoor(entranceToEchoing);
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
                
        //Skapa Dungeon
        Dungeon dungeon = new Dungeon(rooms, this); //Skapar en Dungeon + skicka med array rooms
          
        //welcomeMessage
        dungeon.setWelcomeMessage ("Welcome to Dragon Treasure " + player.getName() + "! You can end game whenever by  writing [quit].");
            
        //Starta spelet
        dungeon.playGame();         
    }
    
    public void endGame() {
        System.out.printf("%n" + "Thank you for playing, goodbye!" + "%n");
    }
}
