
package dragontreasure; 


import java.util.Scanner; 

public class Dungeon { 
   private Room[] rooms; //Array av alla rum i spelet
   private Room currentRoom; //Nuvarande rum spelaren befinner sig i
   private String welcomeMessage; //Välkomstmeddelande som skrivs ut när spelet startar
   private DragonTreasure game; //referens till huvudklassen, används för att anropa endGame
   
   //Konstruktor
   public Dungeon(Room[] rooms, DragonTreasure game) { 
    this.rooms=rooms;  
    this.currentRoom = rooms[0]; //Startar i första rummet
    this.game=game; 
    }
   
   public void setWelcomeMessage (String welcomeMessage) { 
       this.welcomeMessage = welcomeMessage; 
   }
    
   public void playGame() { //Startar spelet och håller igång spel-loop
      System.out.printf("%n" + welcomeMessage + "%n%n");  
      Scanner input = new Scanner(System.in);    
      
      while (true) { //oändlig loop - fortsätter tills spelaren skriver "quit"
         currentRoom.doNarrative(); 
         System.out.printf("%n" + "> ");  
         String command = input.nextLine(); 
         
         if (command.equals("quit")){
             game.endGame(); 
             break; //avslutar while-loppen
             
         } else if (command.equals("i") && currentRoom.getRoomDesc().equals("outside")) {
          currentRoom = rooms[1]; // Särfall för att kunna gå från "outside" till första riktiga rummet.
         
          
         } else if (command.equals("n") && currentRoom.getNorthDoor() !=null){ 
          Door northDoor = currentRoom.getNorthDoor();  
          if (!northDoor.isLocked()) {  
             currentRoom = currentRoom.getNorthDoor().getLeadsTo();  
          } else {
              System.out.println("The door is locked."); 
          }
              
          } else if (command.equals("s") && currentRoom.getSouthDoor() !=null){ 
          Door southDoor = currentRoom.getSouthDoor(); 
          if (!southDoor.isLocked()) { 
             currentRoom = currentRoom.getSouthDoor().getLeadsTo(); 
          } else { 
              System.out.println("The door is locked."); 
          }
      
          } else if (command.equals("e") && currentRoom.getEastDoor() !=null){ 
          Door eastDoor = currentRoom.getEastDoor(); 
          if (!eastDoor.isLocked()) { 
             currentRoom = currentRoom.getEastDoor().getLeadsTo(); 
          } else {
              System.out.println("The door is locked."); 
          }

          } else if (command.equals("w") && currentRoom.getWestDoor() !=null){ 
          Door westDoor = currentRoom.getWestDoor(); 
          if (!westDoor.isLocked()) { 
             currentRoom = currentRoom.getWestDoor().getLeadsTo(); 
          } else {
              System.out.println("The door is locked."); 
          }
}
}
}
}
