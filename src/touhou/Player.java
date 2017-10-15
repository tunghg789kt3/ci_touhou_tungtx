package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_Z;

public class Player {
    BufferedImage image;


    public int x = 384;
    public int y = 500;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean zPressed;


    final int SPEED = 3;

    final int LEFT = 188;
    final int RIGHT = 572;
    final int TOP = -24;
    final int BOTTOM = 550;

    public Player() {
        image = Utils.loadImage("assets/images/players/straight/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
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
        if (e.getKeyCode() == VK_Z) {
            zPressed = true;
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
        }if (e.getKeyCode() == VK_Z) {
            zPressed = false;
        }

    }

    public void run() {
        int vx = 0;
        int vy = 0;

        if (rightPressed) {
            vx += SPEED;
        }

        if (leftPressed) {
            vx -= SPEED;
        }

        if (downPressed) {
            vy += SPEED;
        }

        if (upPressed) {
            vy -= SPEED;
        }
        x = x + vx;
        y = y + vy;

        x = (int) clamp(x, LEFT, RIGHT);
        y = (int) clamp(y, TOP, BOTTOM);
    }

    public void shoot(ArrayList<PlayerSpell> spells){
        if (zPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.x = x;
            newSpell.y = y;
            spells.add(newSpell);
        }

    }

    private float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }

        return value;
    }
}
