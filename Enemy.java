package udg;
 class Enemy { private String type = "Enemy";
private int x, y;
private int width, height;
private int damage;

public Enemy(String type, int x, int y, int width, int height, int damage) {
    setType(type);
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    setDamage(damage);
}

     public String getType() {
	return type;
}

   public int getX() {
	return x;
}

public int getY() {
	return y;
}

public int getWidth() {
	return width;
}

public int getHeight() {
	return height;
}

public int getDamage() {
	return damage;
}


		   public void setType(String type) {
    if (type == null || type.trim().isEmpty()) {
        System.out.println("Tip neprijatelja ne smije biti prazan");
        return;
    }
    this.type = type.trim();
}
public void setX(int x) {
	this.x = x; 
	}
  public void setY(int y) {
	this.y = y; 
	  }
  public void setWidth(int width) { 
	this.width = width; 
	}
    public void setHeight(int height) {
	this.height = height; 
	}
public void setDamage(int damage) {
    if (damage >= 0 && damage <= 100) {
        this.damage = damage;
    } else {
        System.out.println("Damage mora biti izmedju 0-100 ");
    }
}

@Override
public String toString() {
    return "Enemy[" + type + "] @ (" + x + "," + y + ") "+ width + "x" + height + " DMG=" + damage;

}
}
