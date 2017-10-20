import bases.GameObject;
import touhou.Enemies;
import touhou.EnemiesBullets;
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

    int backGroundY = -2509;

    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();
    Enemies enemy = new Enemies();


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
        GameObject.add(enemy);
    }

    public void render() {
        backGraphics.drawImage(background, 204, backGroundY, null);
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
