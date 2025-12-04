
package dragontreasure2; //Kopplar ihop klasser i paketet DragonTreasure2 - utan koppling hittas ej Room av main eller andra klasser

public class Room { //Klassdeklaration. 'public' = kan nås från andra klasser. Klassnamn börjar alltid med stor bokstav.
    private String roomDesc; //Attribut. 'private' = andra klasser kan inte komma åt direkt. Variabler börjar alltid med liten bokstav.
    private Door [] doors = new Door [4]; //deklarerar array 'doors' som kan hålla max 4 Door-objekt - är här [null, null, null, null]
    
    
    //konstruktor, specialmetod som skapar ett objekt av klassen, en ny Room
    public Room (String roomDesc) {
        this.roomDesc = roomDesc; //parametern som skickas in vid skapande av Room-objekt
        this.doors = new Door[4]; //skapar arrayen där dörrarna ska lagras, detta Room-objekt kan innehålla upp till 4 dörrar
    }
    
    //Bestäm dörrriktning
    public void setNorthDoor (Door door) { //Metoddeklaration av Set-metod,Door door = parametrar. Door = typ av objekt. door = variabelnamnet, ex crystalToSword
        this.doors[0] = door; //North = index 0
    }
    
     public void setSouthDoor (Door door) {
        this.doors[1] = door; //South = index 1
    }
    
     public void setEastDoor (Door door) {
        this.doors[2] = door; // East = index 2
    }
    
      public void setWestDoor (Door door) {
        this.doors[3] = door; //West = index 3
    }
   
    //Hämta dörrar, get-metod
      public Door getNorthDoor() { //Metoddeklaration av Get-metod, gör det möjligt för andra klasser att läsa klassens attribut getNorthDoor
          return this.doors[0]; //Returnerar index 0 från array doors
      }
      
      public Door getSouthDoor() {
         return this.doors[1];
      }
      
      public Door getEastDoor() {
          return this.doors[2];
      } 
      
     
      public Door getWestDoor() {
          return this.doors[3];
      } 
      
    //Get-metod för roomDesc
      public String getRoomDesc() { //Metoddeklaration av Get-metod, gör det möjligt för andra klasser att läsa klassens attribut roomDec. Används endast i rum outside
          return roomDesc; //Returnerar roomDesc
      }
      
      //Metoddeklaration av doNarrative - Denna metod besrkiver rummen baserat på attribut roomDesc, skriver ut de dörrar som finns i resp. rum och hanterar om dörr saknas
    public void doNarrative() { 
        
    if (roomDesc.equals("outside")) { //om roomDesc = outside, så kommer nedan special att printas
        System.out.print("You stand outside of a dungeon. You can open the door and go inside [i]");
    
    } 
    
    else { //i alla övriga rum kommer olik texter + koppling till dörrar printas, baserat på roomDesc
        if (roomDesc.equals("entranceHall")) {
        System.out.printf("%n" + "You step into a vast entrance hall. Cold stone walls rise around you, and flickering candles cast long, shifting shadows that make the room feel alive. ");
       
    } else if (roomDesc.equals("echoingPassage")) {
        System.out.printf("%n" + "Your footsteps echo through the narrow passage as cold stone walls close in around you. Darkness presses in, yet a faint glimmer of light still beckons ahead. ");
    
    } else if (roomDesc.equals("crystalGrotto")) {
        System.out.printf("%n" + "A soft glow fills the grotto as crystals rise from floor to ceiling. Cool, fresh air surrounds you, and a small pond gently ripples in the shimmering light. ");
    
    } else if (roomDesc.equals("alchemistLab")) {
        System.out.printf("%n" + "Shelves packed with dusty tomes and bubbling potions line the room. Warm candlelight flickers over strange tools and cauldrons as the scent of herbs fills the air. ");
     
    } else if (roomDesc.equals("chamberOfWhispers")) {
        System.out.printf("%n" + "The room is pitch dark and unnervingly tight. Soft whispers curl through the air, urging you onward. Something unseen watches from the shadows. ");
        
    } else if (roomDesc.equals("swordForge")) {
        System.out.printf("%n" + "Heat radiates from the glowing forge. A focused swordsmith hammers metal, barely acknowledging you. ");
        
    } else if (roomDesc.equals("skeletonKeep")) {
        System.out.printf("%n" + "Cold air sweeps across piles of bones scattered across the floor, as if tossed aside by something powerful - or recently fed. ");
    
    } else if (roomDesc.equals("dragonsLair"))  {
        System.out.printf("%n" + "Golden light fills the chamber. Coins and jewels spill across the floor. On top of the glittering treasure pile, a dragon is sleeping. " );
        
    } else if (roomDesc.equals("monsterDungeon")) {
        System.out.printf("%n" + "A heavy stillness fills the dungeon. From deep in the dark, two yellow eyes glint - unblinking and far too aware of your presence. ");
        
    } else { //om roomDesc inte matchar något känt rum
        System.out.printf("You cannot go there! Try again." + "%n");
    }
        
    //Forts. på doNarrative, efter att rumsbeskrivning skrivs ut skrivs även vilka dörrar som finns att välja på ut 
    System.out.print("You can go ");
    boolean hasDoors = false; //börjar som falskt = vi antar att inga dörrar finns
    
    if (doors[0] != null){ //om dörr har en northDoor
        System.out.print("[n]"); //printas [n]
        hasDoors = true; //boolean hasDoors ändras till true
    }
    
    if (doors[1] != null){ //om dörr har en southDoor
        System.out.print("[s]"); //printas [s]
        hasDoors = true; //boolean hasDoors ändras till true
    }
    
    if (doors[2] != null){ //om dörr har en eastDoor
        System.out.print("[e]"); //printas [e]
        hasDoors = true; //boolean hasDoors ändras till true
    } 
    
    if (doors[3] != null){ //om dörr har en westDoor
        System.out.print("[w]"); // printas [w]
        hasDoors = true; //boolean hasDoors ändras till true
    }
    
    
    if (!hasDoors) { //om inga dörrar finns efter ovan kontroller, printas "nowhere"
        System.out.println("nowhere.");
    }
}
    }
}

