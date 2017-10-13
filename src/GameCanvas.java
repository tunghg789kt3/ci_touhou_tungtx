import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    BufferedImage enemy;

    int playerX = 384;
    int playerY = 500;

    int enemyY = -20;

    int enemy1X = 254;

    int enemy2X = 382;

    int enemy3X = 510;


    int backGroundY = -2509;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    BufferedImage backBuffer;

    Graphics backGraphics;

    public GameCanvas() {

        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        // 1. Load
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            enemy = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    long lastTimeUpdate;

    public void render() {
        backGraphics.drawImage(background, 204, backGroundY, null);
        backGraphics.drawImage(enemy, enemy1X, enemyY, null);
        backGraphics.drawImage(enemy, enemy2X, enemyY, null);
        backGraphics.drawImage(enemy, enemy3X, enemyY, null);
        backGraphics.drawImage(player, playerX, playerY, null);

        repaint();
    }

    public void backGround() {
        if (backGroundY <= 0) {
            backGroundY += 2;
        } else {
            backGroundY += -2509;
        }
    }
    // 2. Draw


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }

    }

    public void enemiesRun() {
        enemyY += 1;
        if (enemyY >= 600){
            enemyY = -50;
        }
    }

    public void run() {
        int vx = 0;
        int vy = 0;

        if (rightPressed) {
            vx += 3;
        }

        if (leftPressed) {
            vx -= 3;
        }

        if (downPressed) {
            vy += 3;
        }

        if (upPressed) {
            vy -= 3;
        }
        playerX = playerX + vx;
        playerY = playerY + vy;

        if (playerX <= 188) {
            playerX = 188;
        } else if (playerX >= 572) {
            playerX = 572;
        }

        if (playerY <= -24) {
            playerY = -24;
        } else if (playerY >= 550) {
            playerY = 550;
        }

        if (playerX <= 188 && playerY <= -24) {
            playerX = 188;
            playerY = -24;
        } else if (playerX >= 572 && playerY >= 550) {
            playerX = 572;
            playerY = 550;
        }
    }
}
