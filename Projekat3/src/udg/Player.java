package udg;

 class Player extends GameObject {
	  private String name;
	  private int health;
 public Player(String name, int x, int y, int width, int height, int health) {
	      super(x, y, width, height);
	      setName(name);
	      setHealth(health);
	    }

	    public String getName() {
	    	return name; 
	    	}
	    public int getHealth() {
	    	return health; 
	    	}

	    public void setName(String name) {
	    if (name == null || name.trim().isEmpty())
	      throw new IllegalArgumentException("Ime igrača ne smije biti prazno");
	    this.name = formatName(name);
	    }

	    public void setHealth(int health) {
	    if (health < 0 || health > 100)
	       throw new IllegalArgumentException("Health igrača mora biti između 0 i 100");
	        this.health = health;
	    }

	    // " peTar   petrović " -> "Petar Petrović"
	 private static String formatName(String unos) {
	  String[] rijeci = unos.trim().split("\\s+");   // uklanjamo više   razmaka
	   StringBuilder sb = new StringBuilder();
	   for (String r : rijeci) {
	      if (sb.length() > 0) sb.append(' ');
	      sb.append(Character.toUpperCase(r.charAt(0))) .append(r.substring(1).toLowerCase());
	        }
	        return sb.toString();
	    }

	 @Override
	    public String toString() {
	  return "Player[" + name + "] " + positionInfo() + " HP=" + health;
	    }
	}
	    
	    
	
	
	
	
	
	
	
	
	

