package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physic.BoxCollider;

import java.awt.*;

public class Enemy extends GameObject {

    int cooldownCount;
    boolean spellDisabled;
    final int COOLDOWN_TIME = 100;

    public BoxCollider boxCollider;

    boolean goRight = true;

    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/blue/1.png");
        boxCollider = new BoxCollider(30,30);
    }

    public void run() {
        move();
        shoot();
        boxCollider.position.set(this.position);
    }

    public void move() {
        position.y += 1;
        if (position.y >= 600) {
            position.y = -50;
        }
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

        EnemyBullets newBullet = new EnemyBullets();
        newBullet.position.set(this.position);
        GameObject.add(newBullet);

        spellDisabled = true;
    }


    public void getHit() {
        isActive = false;
    }
}
