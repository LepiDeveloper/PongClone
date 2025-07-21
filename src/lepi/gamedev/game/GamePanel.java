package lepi.gamedev.game;

import lepi.gamedev.entity.Entity;
import lepi.gamedev.entity.Player;
import lepi.gamedev.entity.Player2;
import lepi.gamedev.objects.Ball;
import lepi.gamedev.objects.MiddleLine;
import lepi.gamedev.objects.WallDown;
import lepi.gamedev.objects.WallUp;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalPixelSize = 32; // this is 32x32
    final int scale = 2;

    public final int pixelSize = originalPixelSize * scale; // after adding 2 the size is 64x64
    public final int maxScreenCol = 14;
    public final int maxScreenRow = 10;
    public final int screenWidth = maxScreenCol * pixelSize; // 896 pixels
    public final int screenHeight = maxScreenRow * pixelSize; // 640 pixels

    int FPS = 60;
    public int playerScore, player2Score;
    public int bounceCount;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public Player player = new Player(this, keyHandler);
    public Player2 player2 = new Player2(this, keyHandler);
    MiddleLine middleLine = new MiddleLine(this, keyHandler);
    public WallDown wallDown = new WallDown(this, keyHandler);
    public WallUp wallUp = new WallUp(this, keyHandler);
    Ball ball = new Ball(this, keyHandler);
    public UI ui = new UI(this);

     public GamePanel() {
         this.setPreferredSize(new Dimension(screenWidth, screenHeight));
         this.setBackground(Color.BLACK);
         this.setDoubleBuffered(true); // this helps your game look smoother and cleaner by preventing flickering during animations. All the drawing happens first on an off-screen buffer. Once everything is fully drawn, that completed image is copied (flipped) to the screen in one go.
         this.addKeyListener(keyHandler);
         this.setFocusable(true);
         this.playerScore = 0;
         this.player2Score = 0;
         this.bounceCount = 0;
     }

     public void startGameThread() {
         gameThread = new Thread(this);
         gameThread.start();
     }

    @Override
    public void run() {

        double drawInterval = 1000000000.0 / FPS; // 0.1666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

         while(gameThread != null) {

             // 1 Update: update the info such as the player positions
             update();

             // 2 Draw: draw the screen with the updated info
             repaint();
             try {

                 double remainingTime = nextDrawTime - System.nanoTime();

                 if(remainingTime > 0) {
                     long sleepTimeMs = (long)(remainingTime / 1000000);
                     int sleepTimeNanos = (int)(remainingTime % 1000000);

                     if(sleepTimeMs > 0 || sleepTimeNanos > 0) {
                         Thread.sleep(sleepTimeMs, sleepTimeNanos);
                     }
                 }

                 nextDrawTime += drawInterval;

             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }

         }

    }

    public void update() {
        player2.update();
        player.update();

        ball.moveBall();

        // check paddle collision
        Entity collidedPaddle = collisionChecker.checkBallPaddleCollision(ball);
        if (collidedPaddle != null) {
            ball.reverseX();
            bounceCount++;

        }


        //check if someone lost
        if(ball.x < 0){
            //player has lost
            player2Score++;
            ball.setDefaultValues();
        }
        else if(ball.x > screenWidth){
            //pc has lost
            playerScore++;
            ball.setDefaultValues();
        }

        //increase speed after 5 bounces
        if (bounceCount == 5){
            bounceCount = 0;
            ball.increaseSpeed();
            System.out.println("Ball speed: " + ball.speed);
        }

    }

    public void paintComponent(Graphics g) {
         super.paintComponent(g);

         Graphics2D g2d = (Graphics2D) g;
         // Objects
         wallUp.draw(g2d);
         middleLine.draw(g2d);
         wallDown.draw(g2d);

         // Ball
        ball.draw(g2d);

        // Players
         player2.draw(g2d);
         player.draw(g2d);

         // UI
          ui.draw(g2d);

         g2d.dispose();
    }


}
