package dragontreasure;

/**
 Monster representerar en fiende i spelet.
 Den har:
   - name (namn)
   - healthPoints (HP)
   - damage (hur mycket den gör per attack)
   - monsterDesc (beskrivning som kan skrivas ut i rummet)
  
 I uppgiften står t.ex:
   - vanligt monster: 8 HP, 1 damage
   - drake: 18 HP, 1 damage
**/

public class Monster {

    // Instansvariabler för klassen Monster
    private String name;
    private int healthPoints;
    private int damage;
    private String monsterDesc;

    // Konstruktor 
    // Tar allt som behövs för att skapa ett monster.
    public Monster(String name, int healthPoints, int damage, String monsterDesc) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.monsterDesc = monsterDesc;
    }

    // Getters för att läsa av värdena 
    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    // Logik: ta skada
    // När spelaren attackerar minskar monstret healthPoints.
    // Vi ser också till att healthPoints inte blir negativt.
    public void takeDamage(int dmg) {
        healthPoints -= dmg;
        if (healthPoints < 0) healthPoints = 0;
    }

    // Logik: är monstret dött? 
    public boolean isDead() {
        return healthPoints <= 0;
    }
}

