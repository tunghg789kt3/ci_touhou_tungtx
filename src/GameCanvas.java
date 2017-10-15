import touhou.Player;
import touhou.PlayerSpell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage enemy;

    int enemyY = -20;

    int enemy1X = 254;

    int enemy2X = 382;

    int enemy3X = 510;


    int backGroundY = -2509;

    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();
    ArrayList<PlayerSpell> spells = new ArrayList<>();


    public GameCanvas() {

        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        // 1. Load
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            enemy = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
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
        player.render(backGraphics);

        for (PlayerSpell spell : spells) {
            spell.render(backGraphics);
        }

        repaint();
    }

    public void backGround() {
        if (backGroundY <= 0) {
            backGroundY += 2;
        } else {
            backGroundY += -2509;
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);

    }

    public void run() {
        player.run();
        player.shoot(spells);
        for (PlayerSpell spell : spells) {
            spell.run();
        }
    }

    public void enemiesRun() {
        enemyY += 1;
        if (enemyY >= 600) {
            enemyY = -50;
        }
    }
}
