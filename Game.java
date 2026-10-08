//Stevan Perovic 24/124 Fist i Daris Kalac 23/034 Fist
package udg;
import java.util.ArrayList;
public class Game {private Player player;
private ArrayList<Enemy> enemies = new ArrayList<>();
private ArrayList<String> eventLog = new ArrayList<>();

public Game(Player player) {
    this.player = player;
}


public boolean checkCollision(Player p, Enemy e) {
    return (p.getX() < e.getX() + e.getWidth() && p.getX() + p.getWidth() > e.getX() &&
    p.getY() < e.getY() + e.getHeight() && p.getY() + p.getHeight() > e.getY());
}

// eventLog
public void decreaseHealth(Player p, Enemy e) {
    int staroHealth = p.getHealth();
    int novoHealth = staroHealth - e.getDamage();
    if (novoHealth < 0) novoHealth = 0;
    p.setHealth(novoHealth);
    eventLog.add("udar: " + p.getName() + " od " + e.getType() + " za "+ e.getDamage() + " -> Heath " + staroHealth + " -> " + novoHealth);
}

//dodavanje u event LOG
public void addEnemy(Enemy e) {
    enemies.add(e);
    eventLog.add("dodaj: " + e);
}

// query vracanje neprijatelja
public ArrayList<Enemy> findByType(String query) {
    ArrayList<Enemy> rezultat = new ArrayList<>();
    String trazeno = query.trim().toLowerCase();
    for (Enemy e : enemies) {
        if (e.getType().toLowerCase().contains(trazeno)) {
            rezultat.add(e);
        }
    }
    return rezultat;
}


public ArrayList<Enemy> collidingWithPlayer() {
    ArrayList<Enemy> rezultat = new ArrayList<>();
    for (Enemy e : enemies) {
        if (checkCollision(player, e)) {
            rezultat.add(e);
        }
    }
    return rezultat;
}

// oduzimanje helth a u slucaju udara 
public void resolveCollisions() {
    for (Enemy e : collidingWithPlayer()) {
        decreaseHealth(player, e);
    }
}

//  format "Goblin;12,5;16x16;20"
// ["Goblin", "12,5", "16x16", "20"]
public static Enemy parseEnemy(String tekst) {
    String[] dijelovi = tekst.split(";");     
    String[] pozicija = dijelovi[1].split(","); 
    String[] dimenzije = dijelovi[2].split("x"); 

    String type = dijelovi[0].trim();
    int x = Integer.parseInt(pozicija[0].trim());
    int y = Integer.parseInt(pozicija[1].trim());
    int width = Integer.parseInt(dimenzije[0].trim());
    int height = Integer.parseInt(dimenzije[1].trim());
    int damage = Integer.parseInt(dijelovi[3].trim());

    return new Enemy(type, x, y, width, height, damage);
}


public static void main(String[] args) {
    Player igrac = new Player("   daris    kalac  ", 10, 5, 32, 32, 85);
    Game igra = new Game(igrac);

    //jedan proizviljno unesen drrugi iz Str formataa
    igra.addEnemy(new Enemy("Orc", 200, 200, 16, 16, 35));
    igra.addEnemy(parseEnemy("Goblin;12,5;16x16;20"));

    System.out.println("Svi neprijatelji:");
    for (Enemy e : igra.enemies) {
        System.out.println(e);
    }

    System.out.println("\nNeprijatelji koji sadrze \"gob\":");
    for (Enemy e : igra.findByType("gob")) {
        System.out.println(e);
    }

    System.out.println("\nPrije sudara: " + igrac);
    igra.resolveCollisions();
    System.out.println("Poslije sudara: " + igrac);

    System.out.println("\nEvent log:");
    for (String dogadjaj : igra.eventLog) {
        System.out.println(dogadjaj);
    }
}

}
