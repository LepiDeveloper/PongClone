package lepi.gamedev.game;

import java.awt.*;

public class UI {

    GamePanel gamePanel;
    Font scoreText;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        scoreText = new Font("Arial", Font.BOLD, 70);
    }

    public void draw(Graphics2D g2) {
        g2.setFont(scoreText);
        g2.setColor(Color.WHITE);
        g2.drawString(gamePanel.playerScore + "      " + gamePanel.player2Score, 360, 80);

    }


}
