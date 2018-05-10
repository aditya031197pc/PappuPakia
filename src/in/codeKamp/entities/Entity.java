package in.codeKamp.entities;

import java.awt.*;

public abstract class Entity {
    public int x;
    public int y;
    public int xVel;
    public int yVel;
    public int xAcc;
    public int yAcc;
    public boolean isVisible = true;
    public Image image;

    public Entity(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public void update() {
        this.x += this.xVel;
        this.y += this.yVel;
        this.xVel += this.xAcc;
        this.yVel += this.yAcc;
    }

}
