package dragontreasure;

import java.util.ArrayList;

public class Player {

	// instansvariabler för klassen Player
    private String name;
    private int healthPoints;
    private int baseDamage;
    private ArrayList<Item> inventory;

    // konstruktor för att sätta startvärden på våra instansvariabler
    // healthPoints och baseDamage har startvärden 10 resp 1 enligt uppg
    public Player(String name) {
        this.name = name;
        this.healthPoints = 10;
        this.baseDamage = 1;
        this.inventory = new ArrayList<>();
    }

    // getters för att läsa av name och healthPoints
    public String getName() { 
    	return name; 
    }

    public int getHealthPoints() { 
    	return healthPoints; 
    }

    // om monstret gör 1 i skada minskar vi healthPoints med 1
    // vi ser också till att healthPoints inte blir negativt 
    public void takeDamage(int dmg) {
        healthPoints -= dmg;
        if (healthPoints < 0) healthPoints = 0;
    }


    //potions helar spelaren
    //vi sätter en maxgräns på 10 så healthPoints inte blir oändligt
    public void heal(int amount) {
        healthPoints += amount;
        if (healthPoints > 10) healthPoints = 10; // max healthPoints tak
    }

    //när spelaren tar ett föremål i ett rum lägger vi in det här
    public void addItem(Item item) {
        inventory.add(item);
    }

    //används när vi vill skriva ut inventory i spelet
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    
    //har spelaren en nyckel?
    //behövs eftersom låsta dörrar kräver Key enligt uppg
    //vi loopar igenom inventory och kollar om något är en Key
    public boolean hasKey() {
    	for (Item i : inventory) {
    		if (i instanceof Key) {
    			return true;
    		}
    	}
    	return false;
    }
    
    

    //total skada (bas + vapenbonus)
    //spelaren gör 1 i skada utan vapen
    //ett svärd kan t.ex. göra att spelaren gör +2 extra skada.
    //därmed är total skada = baseDamage + sum(vapenbonusar)
    public int getTotalDamage() {
    	
    	int bonus = 0;
    	
    	for (Item i : inventory) {
    		if (i instanceof Weapon w) {
    			bonus += w.getIncreaseDamage();
    		}
    	}
    	return baseDamage + bonus;
    	
    }


    //använd en potion om den finns
    //när spelaren skriver kommandot ”potion” eller väljer potion i strid:
    // - leta efter första potion i inventory
    // - heala med potionens healing-värde
    // - ta bort potionen (förbrukas)
    // - returnera true om vi hittade en potion    
	public boolean usePotionIfAny() {
	        for (int index = 0; index < inventory.size(); index++) {
	            Item i = inventory.get(index);
	
	            if (i instanceof Potion p) {
	                heal(p.getHealing());
	                inventory.remove(index);
	                return true;
	            }
	        }
	        return false;
	    }
	}
