import bases.GameObject;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpawner;
import touhou.players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;

    int backGroundY = -2509;

    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();
    Enemy enemy = new Enemy();


    public GameCanvas() {

        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        // 1. Load
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameObject.add(player);
        GameObject.add(new EnemySpawner());
    }

    public void render() {
        backGraphics.drawImage(background, 0, backGroundY, null);
        GameObject.renderAll(backGraphics);
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
        GameObject.runAll();
    }
}
