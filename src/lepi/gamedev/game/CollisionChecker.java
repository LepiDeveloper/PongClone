package lepi.gamedev.game;

import lepi.gamedev.entity.Entity;
import lepi.gamedev.objects.WallDown;
import lepi.gamedev.objects.WallUp;

import java.awt.*;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkObject(Entity entity, String direction) {

        entity.collisionOn = false; // Reset before checks

        WallUp wallUp = gamePanel.wallUp;
        WallDown wallDown = gamePanel.wallDown;

        int nextX = entity.x;
        int nextY = entity.y;

        if ("up".equals(direction)) {
            nextY -= entity.speed;
        } else if ("down".equals(direction)) {
            nextY += entity.speed;
        }

        Rectangle nextPlayerRect = new Rectangle(nextX, nextY, entity.playerSizeWidth, entity.playerSizeHeight);
        Rectangle wallUpRect = new Rectangle(wallUp.x, wallUp.y, wallUp.objectSizeWidth, wallUp.objectSizeHeight);
        Rectangle wallDownRect = new Rectangle(wallDown.x, wallDown.y, wallDown.objectSizeWidth, wallDown.objectSizeHeight);

        if (nextPlayerRect.intersects(wallUpRect) || nextPlayerRect.intersects(wallDownRect)) {
            entity.collisionOn = true;
        }

    }

}
