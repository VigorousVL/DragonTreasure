package dragontreasure;

import java.util.Scanner;

/**
 Dungeon sköter själva spel-loopen:
   - visar rumsinfo (doNarrative)
   - tar in spelarens kommandon
   - flyttar mellan rum
   - låser upp dörrar med Key
   - låter spelaren ta items
   - startar strid när spelaren väljer fight
**/
public class Dungeon {

    // Instansvariabler 

    // Alla rum i spelet
    private Room[] rooms;

    // Var spelaren befinner sig just nu
    private Room currentRoom;

    // Spelaren (HP, inventory, damage osv)
    private Player player;

    // Text som skrivs när spelet startar
    private String welcomeMessage;

    // Referens till huvudklassen (för att kunna kalla endGame())
    private DragonTreasure game;


    // Konstruktor 
    public Dungeon(Room[] rooms, Player player, DragonTreasure game) {
        this.rooms = rooms;
        this.currentRoom = rooms[0]; // start i första rummet
        this.player = player;
        this.game = game;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }


    // Spel-loop 
    public void playGame() {
        System.out.println();
        System.out.println(welcomeMessage);

        Scanner input = new Scanner(System.in);

        while (true) {

            // 1) Visa vad som finns i rummet
            currentRoom.doNarrative();

            // 2) Läs spelarens kommando
            System.out.print("> ");
            String command = input.nextLine().trim().toLowerCase();

            // 3) Avsluta spel
            if (command.equals("quit")) {
                game.endGame();
                break;
                
            }

            // 4) Visa inventory
            if (command.equals("inventory")) {
                showInventory();
                continue;
            }

            // 5) Ta item i rummet
            if (command.equals("take")) {
                takeItemFromRoom();
                
                // Om skatten har plockats upp är spelet vunnet
                boolean hasTreasure = false;
                for (Item i : player.getInventory()) {
            		// om inventory innehåller treasure
            		if (i instanceof Treasure) {
            			hasTreasure = true;
            		}
            	}
                
                if(hasTreasure) {
                	System.out.println("\u001B[32mCongratulations! You have won the game.\u001B[0m"); // grön text
                	game.endGame();
                	break;
                }
                
                continue;
            }

            // 6) Använd potion direkt (utanför strid)
            if (command.equals("potion")) {
                boolean used = player.usePotionIfAny();
                System.out.println(used ? "You used a potion." : "You have no potion.");
                continue;
            }

            // 7) Starta strid om monster finns
            if (command.equals("fight")) {
                currentRoom.doBattle(player);

                // Om spelaren dog i striden -> game over
                if (player.getHealthPoints() <= 0) {
                    System.out.println("You died. Game over.");
                    game.endGame();
                    break;
                }
                continue;
            }

            // 8) Rörelse med n/s/e/w
            if (command.equals("n")) {
                tryMove(currentRoom.getNorthDoor());
            } else if (command.equals("s")) {
                tryMove(currentRoom.getSouthDoor());
            } else if (command.equals("e")) {
                tryMove(currentRoom.getEastDoor());
            } else if (command.equals("w")) {
                tryMove(currentRoom.getWestDoor());
            } else {
                System.out.println("Unknown command.");
            }
        }
    }


    // Försök gå genom en dörr 
    private void tryMove(Door door) {

        // Ingen dörr i den riktningen
        if (door == null) {
            System.out.println("No door that way.");
            return;
        }

        // Om dörren är låst -> kräver nyckel
        if (door.isLocked()) {

            // Kolla om spelaren har Key i inventory
            if (player.hasKey()) {
                door.unlock();
                System.out.println("You unlocked the door using a key!");
            } else {
                System.out.println("The door is locked. You need a key.");
                return;
            }
        }

        // Om dörren är öppen -> flytta till nästa rum
        currentRoom = door.getLeadsTo();
    }


    // Ta item från rummet 
    private void takeItemFromRoom() {
    	
    	
    	Item roomItem = currentRoom.getItem();
    	
    	if (roomItem == null) {
            System.out.println("No item to take.");
            return;
        }
    	
    	// Om skatten är i rummet och monstret lever får vi inte ta skatten
        Monster m = currentRoom.getMonster();
        if (roomItem instanceof Treasure && m != null && !m.isDead()) {
            System.out.println("The treasure is guarded! Defeat the monster first.");
            return;
        }
    	
        
        // Nu är det okej att ta itemet
        Item item = currentRoom.takeItem();
        
        // Lägger till item i spelarens inventory
        player.addItem(item);
        System.out.println("You picked up: " + item.getName());
    }


    // Visa inventory 
    private void showInventory() {
    	
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
        	System.out.println("Inventory:");
            for (Item i : player.getInventory()) {
                System.out.println("* " + i.describe());
            }
        }

        // Visa HP och damage
        System.out.println("HP: " + player.getHealthPoints()
                + " | Damage: " + player.getTotalDamage());
    }
}
