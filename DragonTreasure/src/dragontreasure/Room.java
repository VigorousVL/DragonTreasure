package dragontreasure;

import java.util.Scanner;

/**
 Room representerar ett rum i dungeon.
 Ett rum kan innehålla:
   - en beskrivning
   - upp till 4 dörrar (n, s, e, w)
   - 0 eller 1 item
   - 0 eller 1 monster
**/
public class Room {

    // Instansvariabler i klassen Room 

	// Rummets namn
	private String roomName;
	
    // Text som beskriver rummet
    private String roomDesc;

    // Array med dörrar:
    // index 0 = north, 1 = south, 2 = east, 3 = west
    private Door[] doors;

    // Ett rum kan ha max ett item
    private Item item;

    // Ett rum kan ha max ett monster
    private Monster monster;


    // Konstruktor 
    public Room(String roomName, String roomDesc) {
    	this.roomName = roomName;
        this.roomDesc = roomDesc;
        this.doors = new Door[4]; // plats för max 4 dörrar
    }

    // Getters
    public String getRoomDesc() {
        return roomDesc;
    }

    public Item getItem() {
        return item;
    }

    public Monster getMonster() {
        return monster;
    }

    // Setters
    public void setItem(Item item) {
        this.item = item;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    // Tar bort item från rummet (när spelaren plockar upp det)
    public Item takeItem() {
        Item temp = item;
        item = null;
        return temp;
    }

    // Tar bort monster när det dör
    public void clearMonster() {
        monster = null;
    }

    // Dörrar   
    // För tydlighet skapar vi en metod per riktning
    public void setNorthDoor(Door door) { doors[0] = door; }
    public void setSouthDoor(Door door) { doors[1] = door; }
    public void setEastDoor(Door door)  { doors[2] = door; }
    public void setWestDoor(Door door)  { doors[3] = door; }

    public Door getNorthDoor() { return doors[0]; }
    public Door getSouthDoor() { return doors[1]; }
    public Door getEastDoor()  { return doors[2]; }
    public Door getWestDoor()  { return doors[3]; }


    // Berättar vad som finns i rummet
    public void doNarrative() {
        System.out.println();
        System.out.println("== " + roomName + " ==");
        System.out.println(roomDesc);
        
        // Item
        if (item != null) {
            System.out.println("You see an item here: " + item.describe());
            System.out.println("Type 'take' to pick it up.");
        }

        // Monster
        if (monster != null) {
            System.out.println("A monster is here!");
            System.out.println(monster.getName() + " (" +
                    monster.getHealthPoints() + " HP) - " +
                    monster.getMonsterDesc());
            System.out.println("Type 'fight' to engage in battle.");
        }

        // Doors
        System.out.print("Paths: ");
        boolean hasDoor = false;

        for (int i = 0; i < doors.length; i++) {
            if (doors[i] != null) {
                hasDoor = true;
                String dir = switch (i) {
                    case 0 -> "n";
                    case 1 -> "s";
                    case 2 -> "e";
                    case 3 -> "w";
                    default -> "";
                };

                if (doors[i].isLocked()) {
                    System.out.print(dir + "(locked) ");
                } else {
                    System.out.print(dir + " ");
                }
            }
        }

        if (!hasDoor) {
            System.out.print("none");
        }

        System.out.println();
        System.out.println("Commands: n s e w | take | fight | inventory | potion | quit");
    }

    // Strid mellan spelare och monster 
    public void doBattle(Player player) {

        if (monster == null) return;

        Scanner in = new Scanner(System.in);

        while (monster != null && !monster.isDead() && player.getHealthPoints() > 0) {

            System.out.println();
            System.out.println("Battle!");
            System.out.println("Your HP: " + player.getHealthPoints()
                    + " | Your damage: " + player.getTotalDamage());
            System.out.println(monster.getName() + " HP: " + monster.getHealthPoints());

            System.out.print("Choose: [a]ttack, [p]otion, [r]un > ");
            String cmd = in.nextLine().toLowerCase();

            // Spelarens tur
            if (cmd.equals("a")) {
                monster.takeDamage(player.getTotalDamage());
                System.out.println("You attack!");

            } else if (cmd.equals("p")) {
                boolean used = player.usePotionIfAny();
                System.out.println(used ? "Potion used." : "No potion available.");

            } else if (cmd.equals("r")) {
                System.out.println("You run away!");
                return;
            } else {
                System.out.println("Invalid choice.");
                continue;
            }

            // Kolla om monstret dog
            if (monster.isDead()) {
                System.out.println("You defeated " + monster.getName() + "!");
                monster = null;
                return;
            }

            // Monstrets tur
            player.takeDamage(monster.getDamage());
            System.out.println(monster.getName() + " hits you for " +
                    monster.getDamage() + " damage!");
        }
        
    }
}
