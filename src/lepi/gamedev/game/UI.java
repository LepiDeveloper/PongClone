package lepi.gamedev.game;

import java.awt.*;

public class UI {

    GamePanel gamePanel;
    Font scoreText;
    public int commandNum = 0;
    public int titleScreenState = 0; // 0: the first screem; 1: second screen

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        scoreText = new Font("Arial", Font.BOLD, 70);
    }

    public void draw(Graphics2D g2) {

        // title state
        if (gamePanel.gameState == gamePanel.titleState) {
           drawTitleScreen(g2);
        }
        else {
            g2.setFont(scoreText);
            g2.setColor(Color.WHITE);
            g2.drawString(gamePanel.playerScore + "      " + gamePanel.player2Score, 360, 80);

        }


    }

    public void drawTitleScreen( Graphics2D g2) {

        if(titleScreenState == 0) {
            // title
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
            String text = "Pong Game (clone)";
            int x = 240;
            int y = 80;

            // shadow
            g2.setColor(Color.GRAY);
            g2.drawString(text, x+3, y+3);
            // main color
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);

            // menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "New Game";
            x = 370;
            y = 150;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Options";
            x = 390;
            y = 200;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Credits";
            y = 250;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Quit";
            x = 415;
            y = 300;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }
        }
        else if (titleScreenState == 1) {
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));

            String text = "How many Players";
            int x = 240;
            int y = 80;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "One Player";
            x = 370;
            y = 150;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            text = "Two Player";
            y = 200;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            text = "Back";
            x = 415;
            y = 300;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }


        }




    }


}
