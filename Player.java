
package udg;

 class Player {
private String name = "Player";

private int x, y;
private int width, height;
private int health;

public Player(String name, int x, int y, int width, int height, int health) {
    setName(name);
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    setHealth(health);
}



public String getName() {
	return name;
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



public int getHealth() {
	return health;
}




public void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
        System.out.println("Ime Igraca  ne smije biti prazno!");
        return;
    }
    
    String[] rijeci = name.trim().split("\\s+");
    String novoIme = "";
    for (int i = 0; i < rijeci.length; i++) {
        String r = rijeci[i];
        novoIme += r.substring(0, 1).toUpperCase() + r.substring(1);
        if (i < rijeci.length - 1) {
            novoIme += " ";
        }
    }
    this.name = novoIme;
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
public void setHealth(int health) {
    if (health >= 0 && health <= 100) {
        this.health = health;
    } else {
        System.out.println("Health mora biti od 0 do 100");
    }
}

@Override
public String toString() {
    return "Player[" + name + "] @ (" + x + "," + y + ") " + width + "x" + height + " HP=" + health;

}
}