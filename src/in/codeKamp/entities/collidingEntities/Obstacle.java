package in.codeKamp.entities.collidingEntities;

import in.codeKamp.main.Game;
import in.codeKamp.resources.Resources;
import in.codeKamp.screens.Stage1Screen;

public class Obstacle extends CollidingEntity {
    boolean isForkHead;

    public Obstacle(int x, int y, boolean isForkHead, boolean isForkHandle) {
        super(x, y);
//        System.out.println("Obstacle created");
        this.xVel = -7;
        this.isForkHead = isForkHead;
        if (this.isForkHead) {
            this.width = 33;
            this.height = 59;
            this.image = Resources.forkHeadImage;
        } else if (isForkHandle) {
            this.width = 22;
            this.height = 312;
            this.image = Resources.forkHandleImage;
        } else {
            this.width = 31;
            this.height = 500;
            this.image = Resources.branchImage;
        }
//        System.out.println("Image set");
    }

    @Override
    public void update() {
        super.update();
        if (this.x < 0) {

            if (this.isForkHead) {
                this.x = Game.GAME_WIDTH + 8 + 500 * (Stage1Screen.NO_OF_OBSTACLES - 2);
            } else {
                this.x = Game.GAME_WIDTH + 500 * (Stage1Screen.NO_OF_OBSTACLES - 2);
            }
        }
    }

}
