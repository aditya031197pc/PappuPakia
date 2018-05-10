package in.codeKamp.entities.backgroundEntities;

import in.codeKamp.resources.Resources;

public class BackTrees extends BgEntity {
    public BackTrees(int x, int y,int xVel) {
        super(x, y,xVel);

//        this.xVel = -5;
        this.image = Resources.backTreesImage;
    }
}
