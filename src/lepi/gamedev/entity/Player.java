package lepi.gamedev.entity;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;
import lepi.gamedev.objects.Ball;

import java.awt.*;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;
    AIController aiController;
    Ball ball;

    public Player(GamePanel gamePanel, KeyHandler keyHandler, Ball ball) {
        aiController = new AIController(this, ball,  gamePanel);
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

        // This is solo
        if (gamePanel.isSolo == true) {
            aiController.update();
        }

        // This is multiplayer
        if (gamePanel.isSolo == false) {

            if (keyHandler.upPressed) {
                gamePanel.collisionChecker.checkObject(this, "up", null);
                if (!collisionOn) {
                    y -= speed;
                }

            } else if (keyHandler.downPressed) {
                gamePanel.collisionChecker.checkObject(this, "down", null);
                if (!collisionOn) {
                    y += speed;
                }
            }

        }


    }

    public void draw(Graphics g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, playerSizeWidth, playerSizeHeight);
    }

}
