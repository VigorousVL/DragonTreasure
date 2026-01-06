package dragontreasure;

/**
 Door representerar en dörr mellan två rum.
 En dörr:
   - sitter i ett väderstreck (n, s, e, w)
   - kan vara låst eller olåst
   - leder till ett annat Room
**/
public class Door {

    // Instansvariabler i klassen Door

    // position anger riktning: 'n', 's', 'e' eller 'w'
    private char position;

    // locked anger om dörren är låst
    private boolean locked;

    // leadsTo anger vilket rum dörren leder till
    private Room leadsTo;


    // Konstruktor
    // När vi skapar en dörr vet vi:
    // - vilket väderstreck den sitter i
    // - om den är låst eller inte
    public Door(char position, boolean locked) {
        this.position = position;
        this.locked = locked;
    }


    // Getters för att läsa av värdena 
    public char getPosition() {
        return position;
    }

    public boolean isLocked() {
        return locked;
    }

    public Room getLeadsTo() {
        return leadsTo;
    }


    // Setters för att sätta in värdena

    // Används när vi bygger dungeon och kopplar ihop rum
    public void setLeadsTo(Room room) {
        this.leadsTo = room;
    }

    // Används när spelaren har en Key och låser upp dörren
    public void unlock() {
        this.locked = false;
    }
}
