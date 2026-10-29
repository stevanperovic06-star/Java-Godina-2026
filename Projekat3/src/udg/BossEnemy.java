package udg;

class BossEnemy extends Enemy {
   public BossEnemy(String type, int x, int y, int width, int height, int damage, int health) {
      super(type, x, y, width, height, damage, health);
    }
    @Override
    
    protected int getMaxHealth() {
      return 200;
    }

    @Override
    
    public int getEfikasniDamage() {
      return getDamage() * 2;
    }

    @Override
    public String toString() {
        return "BossEnemy[" + getType() + "] " + positionInfo() + " DMG=" + getDamage() + "x2 HP=" + getHealth();
    }
}
