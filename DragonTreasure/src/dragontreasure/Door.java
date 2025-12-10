
package dragontreasure;

public class Door { 
    private char position; //Dörrens riktning (n, s, e, w)
    private boolean locked; //Om dörren är låst eller ej
    private Room leadsTo; // Rummet dörren leder till

    //Konstruktor
    public Door (char position, boolean locked) { 
        this.position=position; 
        this.locked=locked;    
    }

    
    public boolean isLocked() { 
        return locked; 
    }
    
    public void setLeadsTo(Room room) { 
        this.leadsTo= room;  
    }

    public Room getLeadsTo(){ 
        return leadsTo; 
    }
}
