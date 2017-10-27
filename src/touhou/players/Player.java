package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physic.BoxCollider;
import bases.physic.PhysicsBody;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_Z;

public class Player extends GameObject implements PhysicsBody{

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean zPressed;


    final int SPEED = 4;

    public BoxCollider boxCollider;

    boolean spellDisabled;
    int cooldownCount;
    final int COOLDOWN_TIME = 10;


    public Player() {
        position.x = 184;
        position.y = 500;
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxCollider = new BoxCollider(5,5);
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
        velocity.set(0, 0);

        if (rightPressed) {
            velocity.x += SPEED;
        }

        if (leftPressed) {
            velocity.x -= SPEED;
        }

        if (downPressed) {
            velocity.y += SPEED;
        }

        if (upPressed) {
            velocity.y -= SPEED;
        }

        position.addUp(velocity);

        position.x = (int) clamp(position.x, LEFT, RIGHT);
        position.y = (int) clamp(position.y, TOP, BOTTOM);

        boxCollider.position.set(this.position);
    }

    public void shoot() {

        if (spellDisabled) {
            cooldownCount++;
            if (cooldownCount >= COOLDOWN_TIME) {
                spellDisabled = false;
                cooldownCount = 0;
            }
            return;
        }

        if (zPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.position.set(this.position);
            GameObject.add(newSpell);

            spellDisabled = true;
        }
    }

    public void getHit() {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    //    @Override
//    public void render(Graphics graphics) {
//        graphics.drawImage(image,(int) position.x - image.getWidth()/2, (int) position.y,null);
//    }
}
