package in.codeKamp.entities.backgroundEntities;

import in.codeKamp.resources.Resources;

public class Clouds extends BgEntity {
    public Clouds(int x, int y,int xVel) {
        super(x, y,xVel);
        this.image = Resources.cloudsImage;

    }
}
