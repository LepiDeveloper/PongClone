package lepi.gamedev.entity;

import java.awt.*;

public class Entity {

    // Player position and movement
    public int x, y;
    public int speed;
    public int midSpeed;
    public int hardSpeed;

    // Player size
    public int playerSizeWidth;
    public int playerSizeHeight;

    // Collision
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
