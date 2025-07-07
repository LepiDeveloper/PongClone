package lepi.gamedev.objects;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.game.KeyHandler;

import java.awt.*;

public class MiddleLine extends GameObject {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public MiddleLine(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {

        objectSizeHeight = 15;
        objectSizeWidth = 15;
    }

    public void draw(Graphics g2d) {

        int col = 0;
        x = 448; // left right
        y = 0;

        // 43 is the amount of 15x15 line blocks that can fit on the screen height.
        while(col < 43) {

            g2d.setColor(Color.gray);

            if(col % 2 == 0) {
                g2d.fillRect(x, y, objectSizeWidth, objectSizeHeight);

            }

            col++;
            y += objectSizeHeight;

        }

    }

}
