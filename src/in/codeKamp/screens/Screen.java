package in.codeKamp.screens;

import in.codeKamp.entities.Entity;
import in.codeKamp.entities.collidingEntities.CollidingEntity;
import in.codeKamp.main.GamePanel;
import in.codeKamp.resources.Resources;

import java.awt.*;
import java.util.ArrayList;

abstract public class Screen {
    protected GamePanel gPanel;
    protected java.util.List<Entity> entities = new ArrayList<>();
    protected java.util.List<CollidingEntity> colidingEentities = new ArrayList<>();
//        protected java.util.List<BgEntity> backgroundEntities = new ArrayList<>();


    Screen(GamePanel p) {
        this.gPanel = p;
        Resources.pappuPakiaAudio.loop();
    }

    public void update() {
        for (Entity e : this.entities) {
            e.update();

        }
    }

    public void draw(Graphics graphics) {

        for (Entity e : entities) {
            if (e.isVisible) {
                graphics.drawImage(e.image, e.x, e.y, null);
            }
        }
    }

    public void onMousePress(int mouseXCord, int mouseYCord) {
        Resources.selectAudio.play();
    }

    public void onKeyPress(int keyCode) {
        Resources.flapAudio.play();
    }
}

