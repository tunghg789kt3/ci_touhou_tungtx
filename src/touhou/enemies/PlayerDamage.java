package touhou.enemies;

import bases.GameObject;
import bases.physic.BoxCollider;
import touhou.players.Player;

public class PlayerDamage {
    public void PlayerDamage(Enemy owner){
        BoxCollider boxCollider = owner.getBoxCollider();
        Player player = GameObject.collideWith(boxCollider, Player.class);
        Enemy enemy = GameObject.collideWith(boxCollider, Enemy.class);
        if (player != null){
            player.getHit();
            enemy.getHit();

        }
    }
    public void BulletDamage(EnemyBullets owner){
        BoxCollider boxCollider = owner.getBoxCollider();
        Player player = GameObject.collideWith(boxCollider, Player.class);
        EnemyBullets enemyBullets = GameObject.collideWith(boxCollider, EnemyBullets.class);
        if (player != null){
            player.getHit();
            enemyBullets.isActive = false;
        }
    }
}
