package in.codeKamp.entities.backgroundEntities;

import in.codeKamp.resources.Resources;

public class Ground extends BgEntity {
    public Ground(int x, int y,int xVel) {
        super(x, y, xVel);
        this.xVel = -7;
        this.image = Resources.groundImage;
    }
}
