package lepi.gamedev.objects;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;

import java.awt.*;

public class WallDown extends Object{

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public WallDown(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {

        x = 0; // left right
        y = 626; // up down

        objectSizeHeight = 15;
        objectSizeWidth = gamePanel.screenWidth;

        collision = true;
    }

    public void draw(Graphics g2d) {
        g2d.setColor(Color.gray);
        g2d.fillRect(x, y, objectSizeWidth, objectSizeHeight);
    }


}
