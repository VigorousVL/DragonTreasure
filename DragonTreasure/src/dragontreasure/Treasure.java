package dragontreasure;

/**
Treasure är ett Item som representerar en skatt.

Den har ett goldValue som kan användas för poäng eller vinstvillkor.
**/

public class Treasure extends Item {

    private int goldValue;

    public Treasure(String name, String itemDesc, int goldValue) {
        super(name, itemDesc);
        this.goldValue = goldValue;
    }

    public int getGoldValue() {
        return goldValue;
    }
}
