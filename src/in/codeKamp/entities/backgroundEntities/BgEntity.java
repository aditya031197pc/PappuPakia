package in.codeKamp.entities.backgroundEntities;

import in.codeKamp.entities.Entity;
import in.codeKamp.main.Game;

abstract public class BgEntity extends Entity {
    public BgEntity(int x, int y, int xVel) {
        super(x, y);
        this.xVel = xVel;

    }

    @Override
    public void update() {
        super.update();

        if (this.x < -Game.GAME_WIDTH + 20) {
            // did plus 20 because there was a gap coming when first image was going out of screen
            this.x = Game.GAME_WIDTH;
        }

    }
}
