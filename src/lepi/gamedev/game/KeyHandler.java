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

        if (code == KeyEvent.VK_ESCAPE) {
            if (gamePanel.gameState == gamePanel.playState) {
                gamePanel.gameState = gamePanel.pauseState;
            }
            else if (gamePanel.gameState == gamePanel.pauseState) {
                gamePanel.gameState = gamePanel.playState;
            }
        }

        // title state
        if(gamePanel.gameState == gamePanel.titleState || gamePanel.gameState == gamePanel.optionsState) {
            if (gamePanel.ui.titleScreenState == 0) {
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    gamePanel.ui.commandNum--;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 3;
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    gamePanel.ui.commandNum++;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum > 3) {
                        gamePanel.ui.commandNum = 0;
                    }

                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gamePanel.ui.commandNum == 0) {
                        gamePanel.playSE(3);
                        gamePanel.ui.titleScreenState = 1;

                    }
                    if (gamePanel.ui.commandNum == 1) {
                        // add options here
                        gamePanel.playSE(3);
                        gamePanel.ui.titleScreenState = 3;
                    }
                    if (gamePanel.ui.commandNum == 2) {
                        // add credits here
                        gamePanel.playSE(3);
                        gamePanel.ui.titleScreenState = 2;
                    }
                    if (gamePanel.ui.commandNum == 3) {
                        gamePanel.playSE(3);
                        System.exit(0);
                    }
                }
            }
            else if (gamePanel.ui.titleScreenState == 1) {
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    gamePanel.ui.commandNum--;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 2;
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    gamePanel.ui.commandNum++;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum > 2) {
                        gamePanel.ui.commandNum = 0;
                    }

                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gamePanel.ui.commandNum == 0) {
                        gamePanel.gameState = gamePanel.playState; // add here the AI stuff
                        gamePanel.playSE(3);
                        gamePanel.playMusic(0);

                    }
                    if (gamePanel.ui.commandNum == 1) {
                        gamePanel.gameState = gamePanel.playState;
                        gamePanel.playSE(3);
                        gamePanel.playMusic(0);
                    }
                    if (gamePanel.ui.commandNum == 2) {
                        gamePanel.playSE(3);
                        gamePanel.ui.titleScreenState = 0;
                    }
                }
            }
            else if (gamePanel.ui.titleScreenState == 2) {
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    gamePanel.ui.commandNum--;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    gamePanel.ui.commandNum++;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum > 0) {
                        gamePanel.ui.commandNum = 0;
                    }
                }

                if (code == KeyEvent.VK_ENTER) {
                    if (gamePanel.ui.commandNum == 0) {
                        gamePanel.playSE(3);
                        gamePanel.ui.titleScreenState = 0;
                    }
                }
            }
            else if (gamePanel.ui.titleScreenState == 3) {
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    gamePanel.ui.commandNum--;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 3;
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    gamePanel.ui.commandNum++;
                    gamePanel.playSE(2);
                    if (gamePanel.ui.commandNum > 3) {
                        gamePanel.ui.commandNum = 0;
                    }
                }

                if (code == KeyEvent.VK_ENTER) {
                    if (gamePanel.ui.commandNum == 3) {
                        gamePanel.playSE(3);

                        System.out.println("Current game state: " + gamePanel.gameState);
                        if (gamePanel.gameState == gamePanel.titleState) {
                            gamePanel.ui.titleScreenState = 0;
                        }
                        else if (gamePanel.gameState == gamePanel.optionsState) {
                            gamePanel.gameState = gamePanel.pauseState;
                        }
                    }
                }

                if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                    if (gamePanel.ui.commandNum == 0 && gamePanel.music.musicVolumeScale > 0) {
                        gamePanel.music.musicVolumeScale--;
                        gamePanel.music.checkVolume(gamePanel.music.musicVolumeScale);
                    }
                    if (gamePanel.ui.commandNum == 1 && gamePanel.sfx.sfxVolumeScale > 0) {
                        gamePanel.sfx.sfxVolumeScale--;
                        gamePanel.playSE(2);
                    }
                }

                if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                    if (gamePanel.ui.commandNum == 0 && gamePanel.music.musicVolumeScale < 5) {
                        gamePanel.music.musicVolumeScale++;
                        gamePanel.music.checkVolume(gamePanel.music.musicVolumeScale);
                    }
                    if (gamePanel.ui.commandNum == 1 && gamePanel.sfx.sfxVolumeScale < 5) {
                        gamePanel.sfx.sfxVolumeScale++;
                        gamePanel.playSE(2);
                    }
                }


            }
        }
        else if (gamePanel.gameState == gamePanel.pauseState) {
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                gamePanel.ui.commandNum--;
                gamePanel.playSE(2);
                if (gamePanel.ui.commandNum < 0) {
                    gamePanel.ui.commandNum = 3;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                gamePanel.ui.commandNum++;
                gamePanel.playSE(2);
                if (gamePanel.ui.commandNum > 3) {
                    gamePanel.ui.commandNum = 0;
                }

            }
            if (code == KeyEvent.VK_ENTER) {
                if (gamePanel.ui.commandNum == 0) {
                    // reset
                    gamePanel.gameState = gamePanel.playState;
                    gamePanel.resetGame();
                    gamePanel.playSE(3);

                }
                if (gamePanel.ui.commandNum == 1) {
                    // options
                    gamePanel.playSE(3);
                    gamePanel.gameState = gamePanel.optionsState;
                    gamePanel.ui.titleScreenState = 3;
                    System.out.println("Current game state: " + gamePanel.gameState);

                }
                if (gamePanel.ui.commandNum == 2) {
                    // main menu
                    gamePanel.stopMusic();
                    gamePanel.playSE(3);
                    gamePanel.gameState = gamePanel.titleState;
                    gamePanel.ui.titleScreenState = 0;
                    gamePanel.resetGame();

                }

                if (gamePanel.ui.commandNum == 3) {
                    // reset
                    gamePanel.gameState = gamePanel.playState;
                    gamePanel.playSE(3);

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
