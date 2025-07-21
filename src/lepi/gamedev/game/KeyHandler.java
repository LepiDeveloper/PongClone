package lepi.gamedev.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, upPressedArrow, downPressedArrow;
    GamePanel gamePanel;

    // Add this constructor
    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // title state
        if(gamePanel.gameState == gamePanel.titleState) {
            if (gamePanel.ui.titleScreenState == 0) {
                if(code == KeyEvent.VK_W) {
                    gamePanel.ui.commandNum--;
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 3;
                    }
                }
                if(code == KeyEvent.VK_S) {
                    gamePanel.ui.commandNum++;
                    if (gamePanel.ui.commandNum > 3) {
                        gamePanel.ui.commandNum = 0;
                    }

                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gamePanel.ui.commandNum == 0) {
                        gamePanel.ui.titleScreenState = 1;

                    }
                    if (gamePanel.ui.commandNum == 1) {
                        // add options here
                    }
                    if (gamePanel.ui.commandNum == 2) {
                        // add credits here
                    }
                    if (gamePanel.ui.commandNum == 3) {
                        System.exit(0);
                    }
                }
            }
            else if (gamePanel.ui.titleScreenState == 1) {
                if(code == KeyEvent.VK_W) {
                    gamePanel.ui.commandNum--;
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 2;
                    }
                }
                if(code == KeyEvent.VK_S) {
                    gamePanel.ui.commandNum++;
                    if (gamePanel.ui.commandNum > 2) {
                        gamePanel.ui.commandNum = 0;
                    }

                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gamePanel.ui.commandNum == 0) {
                        gamePanel.gameState = gamePanel.playState; // add here the AI stuff
                        gamePanel.playMusic(0);

                    }
                    if (gamePanel.ui.commandNum == 1) {
                        gamePanel.gameState = gamePanel.playState;
                        gamePanel.playMusic(0);
                    }
                    if (gamePanel.ui.commandNum == 2) {
                        gamePanel.ui.titleScreenState = 0;
                    }
                }
            }
        }
        else {
            if(code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if(code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if(code == KeyEvent.VK_A) {
                leftPressed = true;
            }

            if(code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            if(code == KeyEvent.VK_UP) {
                upPressedArrow = true;
            }

            if(code == KeyEvent.VK_DOWN) {
                downPressedArrow = true;
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        if(code == KeyEvent.VK_UP) {
            upPressedArrow = false;
        }

        if(code == KeyEvent.VK_DOWN) {
            downPressedArrow = false;
        }


    }
}
