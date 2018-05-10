package in.codeKamp.entities.collidingEntities;

import in.codeKamp.entities.Entity;

import java.awt.*;

public abstract class CollidingEntity extends Entity {

    protected int width;
    protected int height;
    public boolean isObstacle = true;
    public boolean isPowerUp = false;
    private Rectangle rect = new Rectangle();

    public CollidingEntity(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        super.update();

    }

    private void updateRect() {
        this.rect.setBounds(this.x, this.y, this.width, this.height);
    }

    public boolean isColliding(CollidingEntity other) {
        this.updateRect();
        other.updateRect();
        return this.isVisible && other.isVisible && this.rect.intersects(other.rect);
    }
}
