
package dragontreasure2; //Kopplar ihop klasser i paketet DragonTreasure2 - utan koppling hittas ej Player av main eller andra klasser

public class Player { //Klassdeklaration. 'public' = kan nås från andra klasser. Klassnamn börjar alltid med stor bokstav.
    private String name; //Attribut. 'private' = andra klasser kan inte komma åt direkt. Variabler börjar alltid med liten bokstav.
    
    //Konstruktor, specialmetod som skapar ett objekt av klassen, en ny Player
      public Player(String name)  { //Konstruktor heter exakt samma som klassen. Parametern 'name' skickas in vid objektets skapande
          this.name=name; //this.name = objektets attribut, name = värdet som skickades in till konstruktorn
      }     
    
    public String getName() { //Metoddeklaration av Get-metod, gör det möjligt för andra klasser att läsa klassens attribut name
    return name; //returnerar klassens attribut name
  }   
    
}
