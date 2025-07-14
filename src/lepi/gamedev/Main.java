package lepi.gamedev;

import lepi.gamedev.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setTitle("Pong");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setLocation(550,155);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        // Icon does not work
        Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/atari.png"));
        window.setIconImage(img);

        gamePanel.requestFocusInWindow();
        gamePanel.startGameThread();

    }

}
