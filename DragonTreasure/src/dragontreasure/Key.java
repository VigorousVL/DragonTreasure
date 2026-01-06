package dragontreasure;

/**
Key är ett Item som används för att låsa upp låsta dörrar.

Den behöver inga extra variabler, men är en egen klass

Finns så att vi kan kontrollera: (item instanceof Key).
**/

public class Key extends Item {

	public Key(String name, String itemDesc) {
		super(name, itemDesc);
		
	}
}
