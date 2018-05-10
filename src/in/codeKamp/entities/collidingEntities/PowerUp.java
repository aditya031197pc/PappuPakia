package in.codeKamp.entities.collidingEntities;

import in.codeKamp.main.Game;
import in.codeKamp.resources.Resources;

import java.util.Random;

public class PowerUp extends CollidingEntity {
    public PowerUp(int x, int y)
    {
        super(x, y);
        this.xVel = -7;
        this.width =32;
        this.height =32;
        this.image = Resources.appleImage;
        this.isPowerUp = true;
        this.isObstacle = false;
    }

    public void update() {
        super.update();

        if (this.x < 0) {
            this.x = Game.GAME_WIDTH + 1000 + (new Random()).nextInt(1000);
            this.isVisible = true;
            this.y = new Random().nextInt(300);

        }
    }
}
