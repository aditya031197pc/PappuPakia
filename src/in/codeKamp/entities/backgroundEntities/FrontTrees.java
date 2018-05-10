package in.codeKamp.entities.backgroundEntities;

import in.codeKamp.resources.Resources;

public class FrontTrees extends BgEntity {
    public FrontTrees(int x, int y,int xVel) {
        super(x, y, xVel);
        this.image = Resources.frontTreesImage;
    }
}
