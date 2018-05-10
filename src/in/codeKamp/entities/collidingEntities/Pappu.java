package in.codeKamp.entities.collidingEntities;

import in.codeKamp.resources.Resources;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pappu extends CollidingEntity {
    public boolean isPoweredUp = false;

    private List<Image> allImages = new ArrayList<>();
    private int imageIndex = 0;

    public Pappu(int x, int y) {
        super(x, y);
        this.allImages.add(Resources.pappuImage1);
        this.allImages.add(Resources.pappuImage2);
        this.allImages.add(Resources.pappuImage3);
        this.allImages.add(Resources.pappuImage4);
        this.allImages.add(Resources.pappuImage5);
        this.allImages.add(Resources.pappuImage6);
        this.allImages.add(Resources.pappuImage7);
        this.allImages.add(Resources.pappuImage8);
        this.width =60;
        this.height =60;
        this.isObstacle = false;

        this.yVel = -16;
        this.yAcc = 2;
    }

    @Override
    public void update() {
        super.update();

        this.imageIndex++;
        this.imageIndex %= 8;
        this.image = this.allImages.get(this.imageIndex);
    }

    public void flap() {
        Resources.flapAudio.play();
        this.yVel = -16;
        this.yAcc = 2;
    }


}
