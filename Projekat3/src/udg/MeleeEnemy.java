package udg;

class MeleeEnemy extends Enemy {
    public MeleeEnemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(type, x, y, width, height, damage, health);
    }

    @Override
    public String toString() {
        return "MeleeEnemy[" + getType() + "] " + positionInfo()  + " DMG=" + getDamage() + " HP=" + getHealth();
    }
}