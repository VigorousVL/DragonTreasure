
package dragontreasure2; //Kopplar ihop klasser i paketet DragonTreasure2 - utan koppling hittas ej Door av main eller andra klasser

public class Door { //Klassdeklaration. 'public' = kan nås från andra klasser. Klassnamn börjar alltid med stor bokstav.
    private char position; //north, south, east, west. Char = enstaka tecken (n,s,w,e)
    private boolean locked; //true/false, anger om dörren är låst
    private Room leadsTo; //anger vilket rum dörren leder till. Typ Room = referens till ett Room-objekt som dörren leder till

//Konstruktor, specialmetod som skapar ett objekt av klassen, en ny Door
    public Door (char position, boolean locked) { //har ej med attribut leadsTo här då man vill skilja på skapande av dörr och koppling av dörr 
        this.position=position; //this.position = objektets attribut, position = värdet som skickades in till konstruktorn
        this.locked=locked;  //this.locked = objektets attribut, locked = värdet som skickades in till konstruktorn     
    }

    public boolean isLocked() { //Metoddeklaration av Get-metod, gör det möjligt för andra klasser att läsa klassens attribut locked
        return locked; //returnerar locked, är den true = låst, är den false = olåst
    }
    
    public void setLeadsTo(Room room) { //Metoddeklaration av Set-metod,Room room = parametrar. Room = typ av objekt. room = variabelnamnet, ex crystalGrotto
        this.leadsTo= room; //this.leadsTo = objektets attribut, room = värdet som skickades in till konstruktorn   
    }

    public Room getLeadsTo(){ //Metoddeklaration av Get-metod, gör det möjligt för andra klasser att läsa klassens attribut leadsTo
        return leadsTo; //returnerar det Room-objekt som dörren leder till
    }
}
