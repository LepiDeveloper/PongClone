package lepi.gamedev.objects;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;

import java.awt.*;
import java.util.Random;

public class Ball extends GameObject {

    GamePanel gamePanel;
    KeyHandler keyHandler;
    Random random = new Random();

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
    public void moveBall() {

        // Bounce off top wall
        if (y <= gamePanel.wallUp.y + gamePanel.wallUp.objectSizeHeight) {
            dy = Math.abs(dy); // move down
        }

        // Bounce off bottom wall
        else if (y + objectSizeHeight >= gamePanel.wallDown.y) {
            dy = -Math.abs(dy); // move up
        }

        x += dx;
        y += dy;
//        x = x + (random.nextBoolean() ? dx : -dx);
//        y = y + (random.nextBoolean() ? dy : -dy);

    }

    public void draw(Graphics g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, objectSizeWidth, objectSizeHeight);
    }

    //Reverse's the ball's change in x value
    public void reverseX() {
        dx *= -1;
    }


   //Reverse's the ball's change in y value
    public void reverseY() {
        dy *= -1;

    }

}
