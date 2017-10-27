package touhou.players;

import bases.GameObject;
import bases.physic.BoxCollider;
import touhou.enemies.Enemy;

public class PlayerShoot {
    public void run(PlayerSpell owner){
        BoxCollider boxCollider = owner.getBoxCollider();
        Enemy enemy = GameObject.collideWith(boxCollider, Enemy.class);
        PlayerSpell playerSpell = GameObject.collideWith(boxCollider, PlayerSpell.class);
        if (enemy != null){
            enemy.getHit();
            playerSpell.isActive = false;

        }
    }
}
