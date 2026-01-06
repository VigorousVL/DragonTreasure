package dragontreasure;

/**
Item är en basklass (abstract) för alla föremål i spelet.

Exempel på items: Key, Potion, Treasure, Weapon.

Vi gör den abstract för att vi aldrig vill skapa ett "Item" direkt.

Man skapar alltid en specifik typ, t.ex. new Key(...)
**/

public abstract class Item {
	
	// Gemensamma egenskaper (instansvariabler) som alla items har
	private String name;
	private String itemDesc;

	// Konstruktor: alla items måste ha namn + beskrivning
	 public Item(String name, String itemDesc) {
	     this.name = name;
	     this.itemDesc = itemDesc;
	 }

	// Getter för att returnera name
	public String getName() {
		return name;
	}

	// Getter för att returnera itemDesc
	public String getItemDesc() {
		return itemDesc;
	}

	// Hjälpfunktion för att skriva ut item snyggt
	public String describe() {
		return name + " - " + itemDesc;
	}
}
