package dragontreasure;

import java.util.Scanner;

public class DragonTreasure {

    public static void main(String[] args) {
        // Skapa spelet och starta setup
        DragonTreasure game = new DragonTreasure();
        game.setupGame();
    }

    /**
     setupGame() ska enligt uppgiften skapa ALLT som behövs innan spelet körs:
       - Player
       - Rooms
       - Doors (inkl. låsta dörrar)
       - Items
       - Monsters
       - Dungeon och sedan starta playGame()
    **/
    public void setupGame() {

        // Skapa Scanner för input
        Scanner input = new Scanner(System.in);

        // Skapa spelare
        System.out.println("Hello, what is your name?");
        System.out.print("> ");
        String name = input.nextLine();

        // Player-konstruktorn sätter startvärden (HP=10, baseDamage=1, tom inventory)
        Player player = new Player(name);

        // Skapa rum
        Room outside = new Room("Outside", "You stand outside of a dungeon. You can open the door and go inside.");
        Room entranceHall = new Room("Entrance Hall", "You step into a vast entrance hall. Cold stone walls rise around you, and flickering candles cast long, shifting shadows that make the room feel alive.");
        Room echoingPassage = new Room("Echoing Passage", "Your footsteps echo through the narrow passage as cold stone walls close in around you. Darkness presses in, yet a faint glimmer of light still beckons ahead.");
        Room crystalGrotto = new Room("Crystal Grotto", "A soft glow fills the grotto as crystals rise from floor to ceiling. Cool, fresh air surrounds you, and a small pond gently ripples in the shimmering light.");
        Room alchemistLab = new Room("Alchemist Lab", "Shelves packed with dusty tomes and bubbling potions line the room. Warm candlelight flickers over strange tools and cauldrons as the scent of herbs fills the air.");
        Room chamberOfWhispers = new Room("Chamber Of Whispers", "The room is pitch dark and unnervingly tight. Soft whispers curl through the air, urging you onward. Something unseen watches from the shadows.");
        Room swordForge = new Room("Sword Forge", "Heat radiates from the glowing forge. A focused swordsmith hammers metal, barely acknowledging you.");
        Room skeletonKeep = new Room("Skeleton Keep", "Cold air sweeps across piles of bones scattered across the floor, as if tossed aside by something powerful - or recently fed.");
        Room dragonsLair = new Room("Dragon's Lair", "Golden light fills the chamber. Coins and jewels spill across the floor. On top of the glittering treasure pile, a dragon is sleeping.");
        Room monsterDungeon = new Room("Monster Dungeon", "A heavy stillness fills the dungeon. From deep in the dark, two yellow eyes glint - unblinking and far too aware of your presence.");

        // Datastruktur med alla rum
        Room[] rooms = {
                outside, entranceHall, echoingPassage, crystalGrotto, alchemistLab,
                chamberOfWhispers, swordForge, skeletonKeep, dragonsLair, monsterDungeon
        };

        // Skapa dörrar och koppla leadsTo
        // Varje dörr vet:
        // - position (n/s/e/w)
        // - om den är låst
        // - vilket rum den leder till

        // Outside <-> Entrance
        Door outsideToEntrance = new Door('n', false);
        outsideToEntrance.setLeadsTo(entranceHall);

        Door entranceToOutside = new Door('s', false);
        entranceToOutside.setLeadsTo(outside);

        // EntranceHall dörrar
        Door entranceToEchoing = new Door('n', false);
        entranceToEchoing.setLeadsTo(echoingPassage);

        Door entranceToCrystal = new Door('s', false);
        entranceToCrystal.setLeadsTo(crystalGrotto);

        Door entranceToAlchemist = new Door('e', false);
        entranceToAlchemist.setLeadsTo(alchemistLab);

        // EchoingPassage dörrar
        Door echoingToEntrance = new Door('s', false);
        echoingToEntrance.setLeadsTo(entranceHall);

        Door echoingToChamber = new Door('e', false);
        echoingToChamber.setLeadsTo(chamberOfWhispers);

        // CrystalGrotto dörrar
        Door crystalToEntrance = new Door('n', false);
        crystalToEntrance.setLeadsTo(entranceHall);

        Door crystalToSword = new Door('e', false);
        crystalToSword.setLeadsTo(swordForge);

        // AlchemistLab dörrar
        Door alchemistToEntrance = new Door('w', false);
        alchemistToEntrance.setLeadsTo(entranceHall);

        Door alchemistToChamber = new Door('n', false);
        alchemistToChamber.setLeadsTo(chamberOfWhispers);

        Door alchemistToSword = new Door('s', false);
        alchemistToSword.setLeadsTo(swordForge);

        Door alchemistToSkeleton = new Door('e', false);
        alchemistToSkeleton.setLeadsTo(skeletonKeep);

        // ChamberOfWhispers dörrar
        Door chamberToEchoing = new Door('w', false);
        chamberToEchoing.setLeadsTo(echoingPassage);

        Door chamberToAlchemist = new Door('s', false);
        chamberToAlchemist.setLeadsTo(alchemistLab);

        // Låst dörr (kräver Key)
        Door chamberToDragons = new Door('e', true);
        chamberToDragons.setLeadsTo(dragonsLair);

        // SwordForge dörrar 
        Door swordToAlchemist = new Door('n', false);
        swordToAlchemist.setLeadsTo(alchemistLab);

        Door swordToCrystal = new Door('w', false);
        swordToCrystal.setLeadsTo(crystalGrotto);

        Door swordToMonster = new Door('e', false);
        swordToMonster.setLeadsTo(monsterDungeon);

        // SkeletonKeep dörrar 
        Door skeletonToAlchemist = new Door('w', false);
        skeletonToAlchemist.setLeadsTo(alchemistLab);

        // LÅST dörr (kräver Key)
        Door skeletonToDragons = new Door('n', true);
        skeletonToDragons.setLeadsTo(dragonsLair);

        Door skeletonToMonster = new Door('s', false);
        skeletonToMonster.setLeadsTo(monsterDungeon);

        // DragonsLair dörrar
        Door dragonsToChamber = new Door('w', false);
        dragonsToChamber.setLeadsTo(chamberOfWhispers);

        Door dragonsToSkeleton = new Door('s', false);
        dragonsToSkeleton.setLeadsTo(skeletonKeep);

        // MonsterDungeon dörrar 
        Door monsterToSword = new Door('w', false);
        monsterToSword.setLeadsTo(swordForge);

        Door monsterToSkeleton = new Door('n', false);
        monsterToSkeleton.setLeadsTo(skeletonKeep);

        // Koppla dörrar till rum
        // Outside
        outside.setNorthDoor(outsideToEntrance);

        // EntranceHall
        entranceHall.setSouthDoor(entranceToOutside); // tillbaka ut
        entranceHall.setNorthDoor(entranceToEchoing);
        entranceHall.setSouthDoor(entranceToCrystal);
        entranceHall.setEastDoor(entranceToAlchemist);
        entranceHall.setWestDoor(entranceToCrystal);

        // EchoingPassage
        echoingPassage.setSouthDoor(echoingToEntrance);
        echoingPassage.setEastDoor(echoingToChamber);

        // CrystalGrotto
        crystalGrotto.setNorthDoor(crystalToEntrance);
        crystalGrotto.setEastDoor(crystalToSword);

        // AlchemistLab
        alchemistLab.setWestDoor(alchemistToEntrance);
        alchemistLab.setNorthDoor(alchemistToChamber);
        alchemistLab.setSouthDoor(alchemistToSword);
        alchemistLab.setEastDoor(alchemistToSkeleton);

        // ChamberOfWhispers
        chamberOfWhispers.setWestDoor(chamberToEchoing);
        chamberOfWhispers.setSouthDoor(chamberToAlchemist);
        chamberOfWhispers.setEastDoor(chamberToDragons);

        // SwordForge
        swordForge.setNorthDoor(swordToAlchemist);
        swordForge.setWestDoor(swordToCrystal);
        swordForge.setEastDoor(swordToMonster);

        // SkeletonKeep
        skeletonKeep.setWestDoor(skeletonToAlchemist);
        skeletonKeep.setNorthDoor(skeletonToDragons);
        skeletonKeep.setSouthDoor(skeletonToMonster);

        // DragonsLair
        dragonsLair.setWestDoor(dragonsToChamber);
        dragonsLair.setSouthDoor(dragonsToSkeleton);

        // MonsterDungeon
        monsterDungeon.setWestDoor(monsterToSword);
        monsterDungeon.setNorthDoor(monsterToSkeleton);

        // Placera ut Items i rum
        // Key behövs för att låsa upp låsta dörrar.
        crystalGrotto.setItem(new Key("Rusty Key", "A key that can unlock a door."));

        // Weapon ökar spelarens skada (ex: svärd ger +2)
        swordForge.setItem(new Weapon("Sword", "A sharp blade. +2 damage.", 2));

        // Potion helar spelaren (ex: 5 HP)
        alchemistLab.setItem(new Potion("Potion", "Heals you for 5 HP.", 5));

        // Treasure kan användas som vinst/poäng (används inte nu då spelet är vunnet om man tar skatten)
        dragonsLair.setItem(new Treasure("Treasure", "A pile of gold and gems!", 100));

        // Placera ut Monster i rum
        // Vanligt monster: 8 HP, 1 damage
        monsterDungeon.setMonster(new Monster("Goblin", 8, 1, "A nasty little creature."));

        // Drake: 18 HP, 1 damage
        dragonsLair.setMonster(new Dragon("Dragon", "Huge, ancient and dangerous."));

        // Skapa Dungeon och starta spelet
        Dungeon dungeon = new Dungeon(rooms, player, this);

        dungeon.setWelcomeMessage(
                "Welcome to Dragon Treasure, " + player.getName() +
                        "! Type [help] for commands or [quit] to end the game."
        );

        dungeon.playGame();
    }

    /**
      Anropas när spelet avslutas.
     **/
    public void endGame() {
        System.out.printf("%nThank you for playing, goodbye!%n");
    }
}
