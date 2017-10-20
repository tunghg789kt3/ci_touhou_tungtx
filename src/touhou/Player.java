package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_Z;

public class Player extends GameObject {

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean zPressed;


    final int SPEED = 3;



    boolean spellDisabled;
    int cooldownCount;
    final int COOLDOWN_TIME = 10;

    public Player() {
        x = 384;
        y = 500;
        image = Utils.loadImage("assets/images/players/straight/0.png");
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
        }
        if (e.getKeyCode() == VK_Z) {
            zPressed = false;
        }

    }

    public void run() {
        move();
        shoot();
    }

    private void move() {
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

    public void shoot() {

        if (spellDisabled){
            cooldownCount++;
            if (cooldownCount >= COOLDOWN_TIME){
                spellDisabled = false;
                cooldownCount = 0;
            }
            return;
        }

        if (zPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.x = x;
            newSpell.y = y;
            GameObject.add(newSpell);

            spellDisabled = true;
        }
    }


}
