package lepi.gamedev.entity;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;

import java.awt.*;

public class Player2  extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player2(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 863; // left right
        y = 280;   // up down
        speed = 4;
        playerSizeHeight = 80;
        playerSizeWidth = 15;
    }

    public void update() {

        collisionOn = false;

        if (keyHandler.upPressedArrow) {
            gamePanel.collisionChecker.checkObject(this, "up");
            if (!collisionOn) {
                y -= speed;
            }

        } else if (keyHandler.downPressedArrow) {
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
