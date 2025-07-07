package lepi.gamedev.entity;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;

import java.awt.*;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        solidArea = new Rectangle(x, y, playerSizeWidth, playerSizeHeight);

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 18; // left right
        y = 280;   // up down
        speed = 4;
        playerSizeHeight = 80;
        playerSizeWidth = 15;
    }

    public void update() {
        collisionOn = false;

        if (keyHandler.upPressed) {
            gamePanel.collisionChecker.checkObject(this, "up");
            if (!collisionOn) {
                y -= speed;
            }

        } else if (keyHandler.downPressed) {
            gamePanel.collisionChecker.checkObject(this, "down");
            if (!collisionOn) {
                y += speed;
            }
        }

    }

    public void draw(Graphics g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, playerSizeWidth, playerSizeHeight);
    }

}
