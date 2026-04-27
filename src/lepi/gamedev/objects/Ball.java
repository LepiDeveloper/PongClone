package lepi.gamedev.objects;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;

import java.awt.*;
import java.util.Random;

public class Ball extends GameObject {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Ball(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        if(gamePanel.gameDifficulty == 1) {
            setEasyValues();
        }
        if(gamePanel.gameDifficulty == 2) {
            setDefaultValues();
        }
        if(gamePanel.gameDifficulty == 3) {
            setHardValues();
        }

    }

    public void setDefaultValues() {

        int xDirection = (dx == 0) ? 1 : (dx > 0 ? 1 : -1); // default to right if dx is 0
        int yDirection = (dy == 0) ? 1 : (dy > 0 ? 1 : -1); // default to down if dy is 0


        x = 448; // left right
        y = 260; // up down

        objectSizeHeight = 15;
        objectSizeWidth = 15;

        MAX_SPEED = 10;
        speed = 5;
        gamePanel.bounceCount = 0;
        dx = speed * xDirection;
        dy = speed * yDirection;
        System.out.println("Starting ball speed is: " + speed);

    }

    public void setEasyValues() {

        int xDirection = (dx == 0) ? 1 : (dx > 0 ? 1 : -1); // default to right if dx is 0
        int yDirection = (dy == 0) ? 1 : (dy > 0 ? 1 : -1); // default to down if dy is 0


        x = 448; // left right
        y = 260; // up down

        objectSizeHeight = 15;
        objectSizeWidth = 15;

        MAX_SPEED = 8;
        speed = 3;
        gamePanel.bounceCount = 0;
        dx = speed * xDirection;
        dy = speed * yDirection;
        System.out.println("Starting ball speed is: " + speed);
    }

    public void setHardValues() {

        int xDirection = (dx == 0) ? 1 : (dx > 0 ? 1 : -1); // default to right if dx is 0
        int yDirection = (dy == 0) ? 1 : (dy > 0 ? 1 : -1); // default to down if dy is 0


        x = 448; // left right
        y = 260; // up down

        objectSizeHeight = 15;
        objectSizeWidth = 15;

        MAX_SPEED = 12;
        speed = 7;
        gamePanel.bounceCount = 0;
        dx = speed * xDirection;
        dy = speed * yDirection;
        System.out.println("Starting ball speed is: " + speed);
    }

    // this is update but for the ball
    public void moveBall() {

        // Bounce off top wall
        if (y <= gamePanel.wallUp.y + gamePanel.wallUp.objectSizeHeight) {
            dy = Math.abs(dy); // move down
            gamePanel.playSE(1);
        }
        // Bounce off bottom wall
        else if (y + objectSizeHeight >= gamePanel.wallDown.y) {
            dy = -Math.abs(dy); // move up
            gamePanel.playSE(1);
        }

        x += dx;
        y += dy;

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

    public void increaseSpeed(){

        if(gamePanel.gameDifficulty == 1) {

            if(speed < MAX_SPEED){
                speed ++;

                dx = (dx / Math.abs(dx)*speed);
                dy = (dy / Math.abs(dy)*speed);

            }
        }
        if(gamePanel.gameDifficulty == 2) {
            if(speed < MAX_SPEED){
                speed ++;

                dx = (dx / Math.abs(dx)*speed);
                dy = (dy / Math.abs(dy)*speed);

            }
        }
        if(gamePanel.gameDifficulty == 3) {

            if(speed < MAX_SPEED){
                speed ++;

                dx = (dx / Math.abs(dx)*speed);
                dy = (dy / Math.abs(dy)*speed);

            }
        }

    }


}
