Stevan Perovic 24&124 FIST
package udg;

public static void main(String[] args) {
    Player player = new Player("  peTar   petrović ", 10, 5, 32, 32, 85);
    Game game = new Game(player);

    // 1) ručno kreiran neprijatelj
  game.addEnemy(new MeleeEnemy("Goblin Warrior", 30, 20, 16, 16, 10, 40));
    // 2) neprijatelj pročitan iz stringa
   game.addEnemy(parseEnemy("Goblin;12,5;16x16;20;boss"));
 
   game.addEnemy(new MeleeEnemy("Skeleton", 100, 100, 16, 16, 15, 50));

    System.out.println("Svi neprijatelji ");
    for (Enemy e : game.getEnemies()) System.out.println(e);

    
    System.out.println("\n Pretraga: \"gob\" ");
    for (Enemy e : game.findByType("gob")) System.out.println(e);
    
    
    System.out.println("\n Neprijatelji u koliziji sa igračem ");
    for (Enemy e : game.collidingWithPlayer()) System.out.println(e);

    System.out.println("\nIgrač PRIJE:   " + player);
    game.resolveCollisions();
    System.out.println("Igrač POSLIJE: " + player);

    System.out.println("\n Event log ");
    for (String event : game.getEventLog()) System.out.println(event);

    System.out.println("Test provjera ");
    try {
        new Player("   ", 0, 0, 10, 10, 50);
    } catch (IllegalArgumentException ex) {
        System.out.println("Greška: " + ex.getMessage());
    }
}
}
