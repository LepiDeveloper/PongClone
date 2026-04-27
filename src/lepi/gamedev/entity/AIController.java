package lepi.gamedev.entity;

import lepi.gamedev.game.GamePanel;
import lepi.gamedev.objects.Ball;

public class AIController {

    private Player player;
    private Ball ball;
    private GamePanel gamePanel;

    public AIController(Player player, Ball ball, GamePanel gamePanel) {
        this.player = player;
        this.ball = ball;
        this.gamePanel = gamePanel;
    }


    public void update() {
        player.collisionOn = false;
        int aiY = player.y + (player.playerSizeHeight / 2);
        int ballY = ball.y + (ball.objectSizeHeight / 2);

        if (aiY > ballY) {
            gamePanel.collisionChecker.checkObject(player, "up", null);
            if (!player.collisionOn) {
                    player.y -= player.speed;
            }
        }
        else if (aiY < ballY) {
            gamePanel.collisionChecker.checkObject(player, "down", null);
            if (!player.collisionOn) {
                player.y += player.speed;
            }
        }

    }

}
