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
        if (gamePanel.gameState == gamePanel.titleState || gamePanel.gameState == gamePanel.optionsState) {
           drawTitleScreen(g2);
        }
        if (gamePanel.gameState == gamePanel.pauseState) {
            drawPauseScreen(g2);
        }
        if (gamePanel.gameState == gamePanel.playState) {
            g2.setFont(scoreText);
            g2.setColor(Color.WHITE);
            g2.drawString(gamePanel.playerScore + "      " + gamePanel.player2Score, 360, 80);
        }


    }

    public void drawPauseScreen( Graphics2D g2) {

        final int frameX = 300;
        final int frameY = 80;
        final int frameWidth = gamePanel.pixelSize*5;
        final int frameHeight = gamePanel.pixelSize*7;

        String text = "PAUSED";
        g2.setFont(g2.getFont().deriveFont(50f));
        int x = 360;
        int y = 135;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight, g2);
        g2.drawString(text, x, y);

        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(35f));
        int textX = frameX + 110;
        int textY = frameY + 140;
        final int lineHeight = 50;

        g2.drawString("Reset", textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX-gamePanel.pixelSize, textY);
        }
        textY += lineHeight;

        g2.drawString("Options", textX-10, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX-gamePanel.pixelSize, textY);
        }
        textY += lineHeight;

        g2.drawString("Main Menu", textX-30, textY);
        if (commandNum == 2) {
            g2.drawString(">", textX-gamePanel.pixelSize, textY);
        }
        textY += lineHeight;

        g2.drawString("Resume", textX-10, textY);
        if (commandNum == 3) {
            g2.drawString(">", textX-gamePanel.pixelSize, textY);
        }


    }

    public void drawSubWindow(int x, int y, int width, int height, Graphics2D g2) {
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);

    }

    public int getXforCenterdText (String text, Graphics2D g2) {
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gamePanel.screenWidth/2 - lenght / 2;
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
        else if (titleScreenState == 2) {
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));

            String text = "Credits";
            int x = 370;
            int y = 80;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Game Made by Ervin Lepic";
            x = 240;
            y = 200;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Music Made by Context Sensitive";
            y = 250;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Testers: Cota";
            y = 300;
            g2.drawString(text, x, y);

            text = "Back";
            x = 415;
            y = 450;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

        }
        else if (titleScreenState == 3) {
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));

            String text = "Options";
            int x = 370;
            int y = 80;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Music:";
            x = 240;
            y = 200;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "SoundFx:";
            y = 250;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35));
            text = "Play Until: 10";
            y = 300;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            text = "Back";
            x = 415;
            y = 450;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString(">", x-gamePanel.pixelSize, y);
            }

            // music slider
            g2.drawRect(370, 175, 150, 24);
            int volumeWidth = 30 * gamePanel.music.musicVolumeScale;
            g2.fillRect(370, 175, volumeWidth, 24);

            // sound effects slider
            g2.drawRect(420, 225, 150, 24);
            volumeWidth = 30 * gamePanel.sfx.sfxVolumeScale;
            g2.fillRect(420, 225, volumeWidth, 24);
        }
    }




}
