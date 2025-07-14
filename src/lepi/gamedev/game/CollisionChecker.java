package lepi.gamedev.game;

import lepi.gamedev.entity.Entity;
import lepi.gamedev.entity.Player;
import lepi.gamedev.entity.Player2;
import lepi.gamedev.objects.Ball;
import lepi.gamedev.objects.GameObject;
import lepi.gamedev.objects.WallDown;
import lepi.gamedev.objects.WallUp;

import java.awt.*;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkObject(Entity entity, String direction, GameObject object) {

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

    public Entity checkBallPaddleCollision(GameObject ball) {

        Player2 player2 = gamePanel.player2;
        Player player = gamePanel.player;

        Rectangle player2Bounds = new Rectangle(player2.x, player2.y, player2.playerSizeWidth, player2.playerSizeHeight);
        Rectangle player1Bounds = new Rectangle(player.x, player.y, player.playerSizeWidth, player.playerSizeHeight);
        Rectangle ballBounds = new Rectangle(ball.x, ball.y, ball.objectSizeWidth, ball.objectSizeHeight);

        if (ballBounds.intersects(player1Bounds)) {
            return gamePanel.player;
        } else if (ballBounds.intersects(player2Bounds)) {
            return gamePanel.player2;
        }

        return null;
    }

}
