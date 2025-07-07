package lepi.gamedev.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, upPressedArrow, downPressedArrow;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

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
