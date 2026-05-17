package lepi.gamedev.entity;

import java.awt.*;

public class Entity {

    // Player position and movement
    public int x, y;
    public int speed;

    // Player size
    public int playerSizeWidth;
    public int playerSizeHeight;

    // Collision
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
