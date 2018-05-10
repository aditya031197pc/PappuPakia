package in.codeKamp.entities.collidingEntities;

public class EscapeArea extends CollidingEntity {
    public static final int ESCAPE_WIDTH = 30;
    public static final int ESCAPE_HEIGHT = 200;

    public EscapeArea(int x, int y) {
        super(x, y);
        this.width = ESCAPE_WIDTH;
        this.height = ESCAPE_HEIGHT;
    }
}
