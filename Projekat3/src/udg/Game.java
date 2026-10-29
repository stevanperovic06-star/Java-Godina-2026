package udg;

import java.util.ArrayList;


public class Game {
  private Player player;
  private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> eventLog = new ArrayList<>();

    public Game(Player player) {
        if (player == null) throw new IllegalArgumentException("Unos ne smije biti prazan");
     this.player = player;
    }

    public Player getPlayer() {
    	return player; }
    public ArrayList<Enemy> getEnemies() {
    	return enemies; }
    public ArrayList<String> getEventLog() {
    	return eventLog; }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int dmg = e.getEfikasniDamage();           // za BossEnemy je puta 2 
        int prije = p.getHealth();
        int poslije = Math.max(0, prije - dmg);      // HP ne smije da bude ispod nule
        p.setHealth(poslije);
        eventLog.add("HIT: Player by " + e.getType() + " for " + dmg + " -> HP " + prije + " -> " + poslije);
    }

    public void addEnemy(Enemy e) {
        if (e == null) 
        	throw new IllegalArgumentException("Neprijatelj ne smije biti null");
        enemies.add(e);
        
        
        eventLog.add("dodaj: " + e);
    }

    public ArrayList<Enemy> findByType(String kveri) {
      ArrayList<Enemy> result = new ArrayList<>();
     if (kveri == null) 
    	 return result;
        String q = kveri.trim().toLowerCase();
        
        for (Enemy e : enemies) {
           if (e.getType().toLowerCase().contains(q)) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
             result.add(e);
            }
        }
        return result;
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
          decreaseHealth(player, e);
            }
        }
    }

    // Čita neprijatelja iz stringa formata "Goblin;12,5;16x16;20;boss"
  
    public static Enemy parseEnemy(String line) {
       if (line == null || line.trim().isEmpty())
         throw new IllegalArgumentException("Prazan string");

     String[] djelovi = line.trim().split(";");
     if (djelovi.length != 5)
        throw new IllegalArgumentException("Neispravan format: " + line);

        String[] poz = djelovi[1].split(",");
        String[] velicina = djelovi[2].trim().toLowerCase().split("x");
        if (poz.length != 2 || velicina.length != 2)
            throw new IllegalArgumentException("Neispravna pozicija ili dimenzije: " + line);

        String type = djelovi[0].trim();
        int x = Integer.parseInt(poz[0].trim());
        int y = Integer.parseInt(poz[1].trim());
        int w = Integer.parseInt(velicina[0].trim());
        int h = Integer.parseInt(velicina[1].trim());
        int damage = Integer.parseInt(djelovi[3].trim());
        String vrsta = djelovi[4].trim().toLowerCase();
        int health = 100;   // format ne sadrži HP, pa koristimo podrazumijevanu vrijednost

        if (vrsta.equals("boss"))  return new BossEnemy(type, x, y, w, h, damage, health);
        if (vrsta.equals("melee")) return new MeleeEnemy(type, x, y, w, h, damage, health);
        
        throw new IllegalArgumentException("Nepoznata vrsta neprijatelja: " + vrsta);
    }
}