package udg;
class Enemy extends GameObject {
    private String type;
    private int damage;
    private int health;

    public Enemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(x, y, width, height);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() {
    	return type; 
    	}
    public int getDamage() {
    	return damage; 
    	}
    public int getHealth() { 
    	return health; 
    	}

    public void setType(String type) {
        if (type == null || type.trim().isEmpty())
            throw new IllegalArgumentException("Tip neprijatelja ne smije biti praznooo");
        this.type = type.trim().replaceAll("\\s+", " ");
    }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 100)
          throw new IllegalArgumentException("Damage mora biti između 0 i 100");
      this.damage = damage;
    }

    public void setHealth(int health) {
        if (health < 0 || health > getMaxHealth())
          throw new IllegalArgumentException("Health mora biti između 0 i " + getMaxHealth());
       this.health = health;
    }

    // Gornja granica za HP; BossEnemy je povećava (primjer sa slajda ima HP=120)
    protected int getMaxHealth() {
        return 100;
    }

    
    public int getEfikasniDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Enemy[" + type + "] " + positionInfo() + " DMG=" + damage + " HP=" + health;
    }
}
