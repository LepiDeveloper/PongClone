package lepi.gamedev.objects;

public class GameObject {

    public boolean collision = false;

    // Object position
    public int x, y;

    // Object size
    public int objectSizeWidth;
    public int objectSizeHeight;

    // ball speed
    public int MAX_SPEED = 10;
    public int speed = 5;

    // ball vertical and horizontal speed/
    public int dx = speed;
    public int dy = speed;

}
