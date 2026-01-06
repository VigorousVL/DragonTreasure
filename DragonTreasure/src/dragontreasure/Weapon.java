package dragontreasure;

/**
Weapon är ett Item som ökar spelarens skada.

increaseDamage är bonusen som läggs till baseDamage.
**/

public class Weapon extends Item {
	private int increaseDamage;

    public Weapon(String name, String itemDesc, int increaseDamage) {
        super(name, itemDesc);
        this.increaseDamage = increaseDamage;
    }

    public int getIncreaseDamage() {
        return increaseDamage;
    }
}
