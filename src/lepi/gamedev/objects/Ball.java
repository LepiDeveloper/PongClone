package lepi.gamedev.objects;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;

import java.awt.*;

public class Ball extends GameObject {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Ball(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 448; // left right
        y = 260; // up down

        objectSizeHeight = 15;
        objectSizeWidth = 15;
    }

    // this is update but for the ball
    public void moveBall(){

        // Bounce off top wall
        if (y <= gamePanel.wallUp.y + gamePanel.wallUp.objectSizeHeight) {
            dy = Math.abs(dy); // move down
        }

        // Bounce off bottom wall
        if (y + objectSizeHeight >= gamePanel.wallDown.y) {
            dy = -Math.abs(dy); // move up
        }

        x += dx;
        y += dy;

    }

    public void draw(Graphics g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, objectSizeWidth, objectSizeHeight);
    }


}
