package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physic.BoxCollider;
import bases.physic.PhysicsBody;

import java.awt.*;

public class Enemy extends GameObject implements PhysicsBody{

    int cooldownCount;
    boolean spellDisabled;
    final int COOLDOWN_TIME = 100;
    int SPEED = 1;

    public BoxCollider boxCollider;
    PlayerDamage playerDamage;

    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/blue/1.png");
        boxCollider = new BoxCollider(30,30);
        this.playerDamage = new PlayerDamage();
    }

    public void run() {
        move();
        shoot();
        boxCollider.position.set(this.position);
        this.playerDamage.PlayerDamage(this);
    }

    public void move() {
        position.addUp(0, SPEED);
        if (position.y >= 600) {
            isActive = false;
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

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
