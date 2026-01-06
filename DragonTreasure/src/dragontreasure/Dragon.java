package dragontreasure;

/**
 * Dragon är ett specifikt monster (arv från Monster).
 * Den har fasta värden enligt uppgiften:
 * - 18 healthPoints
 * - 1 damage
 *
 * Vi låter namn och beskrivning skickas in då healthPoints och damage är givet.
 */
public class Dragon extends Monster {

    public Dragon(String name, String monsterDesc) {
        super(name, 18, 1, monsterDesc);
    }
}
