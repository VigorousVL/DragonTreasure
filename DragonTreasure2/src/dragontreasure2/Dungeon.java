
package dragontreasure2; //Kopplar ihop klasser i paketet DragonTreasure2 - utan koppling hittas ej Dungeon av main eller andra klasser

import java.util.Scanner; // Importerar Scanner-klassen så spelet kan läsa in text från tangentbordet.

public class Dungeon { //Klassdeklaration. 'public' = kan nås från andra klasser. Klassnamn börjar alltid med stor bokstav. Hanterar spellogik och spel-loop
   private Room[] rooms; //array av Room-objekt. Håller alla rum i spelet
   private Room currentRoom; //Visar vilket rum spelaren befginner sig i just nu
   private String welcomeMessage; //Sträng som skrivs ut som välkomstmeddelande
   private DragonTreasure2 game; //referens till huvudklassen, anvönds för att anropa endGame
   
   //konstruktor, specialmetod som skapar ett objekt av klassen, en ny Dungeon
   public Dungeon(Room[] rooms, DragonTreasure2 game) { //Tar emot alla Room-objekt och en referens till huvudklassen
    this.rooms=rooms;  //this.rooms = objektets attribut, rooms = värdet som skickades in till konstruktorn
    this.currentRoom = rooms[0]; //startar sepelet i rooms index [0] (outside)
    this.game=game; //this.game = objektets attribut, game = värdet som skickades in till konstruktorn
    }
   
   public void setWelcomeMessage (String welcomeMessage) { //Metoddeklaration av Set-metod, String = typ av objekt. welcomeMessage = variabelnamnet
       this.welcomeMessage = welcomeMessage; //this.welcomeMessage = objektets attribut, welcomeMessage = värdet som skickas in till metoden 
   }
    
   public void playGame() { //Startar spelet och håller igång spel-loop
      System.out.printf("%n" + welcomeMessage + "%n%n");  //skriver ut welcomeMessage
      Scanner input = new Scanner(System.in);      //Skapar Scanner för att spelaren ska kunna skriva kommandon
      
      while (true) { //oändlig loop - fortsätter tills spelaren skriver "quit"
         currentRoom.doNarrative(); //beskriver nuvarande rum + skriver ut vilka dörrar som finns
         System.out.printf("%n" + "> ");  //prompt för spelaren att navigera
         String command = input.nextLine(); //läser in kommandot som spelaren skriver
         
         if (command.equals("quit")){
             game.endGame(); //anropar sepelet endGame-metod i huvudklassen
             break; //avslutar while-loppen
             
         } else if (command.equals("i") && currentRoom.getRoomDesc().equals("outside")) {
          currentRoom = rooms[1]; // Särfall för att kunna gå från "outside" till första riktiga rummet.
      
         } else if (command.equals("n") && currentRoom.getNorthDoor() !=null){ // Om spelaren valt 'n' OCH rummet har en NorthDoor...
          Door northDoor = currentRoom.getNorthDoor();  // Hämtar dörren i north som ett Door-objekt.
          if (!northDoor.isLocked()) {  // Om dörren inte är låst:
             currentRoom = currentRoom.getNorthDoor().getLeadsTo();  // Flyttar spelaren till rummet som dörren leder till.
          } else {
              System.out.println("The door is locked."); // Informerar om låst dörr + kör om doNarrative för currentRoom
          }
              
          } else if (command.equals("s") && currentRoom.getSouthDoor() !=null){ // Om spelaren valt 's' OCH rummet har en SouthDoor...
          Door southDoor = currentRoom.getSouthDoor(); // Hämtar dörren i south som ett Door-objekt.
          if (!southDoor.isLocked()) { // Om dörren inte är låst:
             currentRoom = currentRoom.getSouthDoor().getLeadsTo(); // Flyttar spelaren till rummet som dörren leder till.
          } else { 
              System.out.println("The door is locked."); // Informerar om låst dörr + kör om doNarrative för currentRoom
          }
      
          } else if (command.equals("e") && currentRoom.getEastDoor() !=null){ // Om spelaren valt 'e' OCH rummet har en EastDoor...
          Door eastDoor = currentRoom.getEastDoor(); // Hämtar dörren i east som ett Door-objekt.
          if (!eastDoor.isLocked()) { // Om dörren inte är låst:
             currentRoom = currentRoom.getEastDoor().getLeadsTo(); // Flyttar spelaren till rummet som dörren leder till.
          } else {
              System.out.println("The door is locked."); // Informerar om låst dörr + kör om doNarrative för currentRoom
          }

          } else if (command.equals("w") && currentRoom.getWestDoor() !=null){ // Om spelaren valt 'w' OCH rummet har en WestDoor...
          Door westDoor = currentRoom.getWestDoor(); // Hämtar dörren i west som ett Door-objekt.
          if (!westDoor.isLocked()) { // Om dörren inte är låst:
             currentRoom = currentRoom.getWestDoor().getLeadsTo(); // Flyttar spelaren till rummet som dörren leder till.
          } else {
              System.out.println("The door is locked."); // Informerar om låst dörr + kör om doNarrative för currentRoom
          }
}
}
}
}
