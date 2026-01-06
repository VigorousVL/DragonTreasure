package dragontreasure;

/**
Potion är ett Item som kan hela spelaren.

Den har en extra variabel: healing (hur mycket den healar).
**/

public class Potion extends Item {

    private int healing;

    public Potion(String name, String itemDesc, int healing) {
        super(name, itemDesc);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }
}
