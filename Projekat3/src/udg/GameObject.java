package udg;


public class GameObject {
private int x;
private int y;
private int width;
private int height;

public GameObject(int x, int y, int width, int height) {
	super();
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
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
public void setX(int x) {
    if (x < 0) throw new IllegalArgumentException("x ne smije biti negativan");
    this.x = x;
}
public void setY(int y) {
    if (y < 0) throw new IllegalArgumentException("y ne smije biti negativan");
    this.y = y;
}

public void setWidth(int width) {
    if (width <= 0) throw new IllegalArgumentException("width mora biti veće od nule");
    this.width = width;
}

public void setHeight(int height) {
    if (height <= 0) throw new IllegalArgumentException("height mora biti veće od nule");
    this.height = height;
}

public boolean intersects(GameObject other) {
    if (other == null) return false;

    
    int lijevo1 = this.x;
    int desno1  = this.x + this.width;
    int gore1   = this.y;
    int dolje1  = this.y + this.height;

    int lijevo2 = other.getX();
    int desno2  = other.getX() + other.getWidth();
    int gore2   = other.getY();
    int dolje2  = other.getY() + other.getHeight();

    if (desno1 <= lijevo2) return false; // ovaj je skroz lijevo od drugog
    if (desno2 <= lijevo1) return false; // drugi je skroz lijevo od ovog
    if (dolje1 <= gore2)   return false; // ovaj je skroz iznad drugog
    if (dolje2 <= gore1)   return false; // drugi je skroz iznad ovog

    return true; // nijedan nije sa strane znaci da imamo neko  preklapanje
}


protected String positionInfo() {
    return "@ (" + x + "," + y + ") " + width + "x" + height;
}

@Override
public String toString() {
    return "GameObject " + positionInfo();
}



}
















