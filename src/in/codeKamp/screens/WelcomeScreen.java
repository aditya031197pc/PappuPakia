package in.codeKamp.screens;

import in.codeKamp.entities.backgroundEntities.Clouds;
import in.codeKamp.entities.collidingEntities.Pappu;
import in.codeKamp.main.Game;
import in.codeKamp.main.GamePanel;
import in.codeKamp.resources.Resources;
import sun.security.krb5.internal.PAData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WelcomeScreen extends Screen {
    protected String startRestart = "START";
    private static final int PLANK_WIDTH = 213;
    private static final int PLANK_HEIGHT = 70;
    private static final int PLANK_X_CORD = Game.GAME_WIDTH / 2 - WelcomeScreen.PLANK_WIDTH / 2;
    private static final int PLANK_Y_CORD = Game.GAME_HEIGHT / 2 - WelcomeScreen.PLANK_HEIGHT / 2;

    private static final int CONTROL_WIDTHT = 47;
    private static final int CONTROL_HEIGHT = 45;
    private static final int CONTROL_X_CORD = Game.GAME_WIDTH / 2 - WelcomeScreen.CONTROL_WIDTHT / 2;
    private static final int CONTROL_Y_CORD = Game.GAME_HEIGHT / 2 - WelcomeScreen.CONTROL_HEIGHT / 2 + 50;

    private static final int LOG_X_CORD = 20;
    private static final int LOG_Y_CORD = Game.GAME_HEIGHT - 119 - 50;

    public static final int PAPPU_X_CORD = LOG_X_CORD;
    public static final int PAPPU_Y_CORD = LOG_Y_CORD - 45;

    // to make pappu flap its wings even during welcome and gameOverScreen
    protected Pappu pappu;

    public WelcomeScreen(GamePanel p) {
        super(p);
        pappu = new Pappu(PAPPU_X_CORD,PAPPU_Y_CORD);
    }

    @Override
    public void update() {
    pappu.update();
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(Resources.bgColor);
        graphics.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
        graphics.drawImage(Resources.bgImage, 0, 0, null);
        graphics.drawImage(Resources.logImage, LOG_X_CORD, LOG_Y_CORD, null);


        graphics.drawImage(pappu.image, PAPPU_X_CORD, PAPPU_Y_CORD, null);


        graphics.drawImage(Resources.groundImage, 0, 0, null);
        graphics.drawImage(Resources.plankImage, PLANK_X_CORD, PLANK_Y_CORD, null);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Happy Sans", Font.ITALIC, 40));
        graphics.drawString(this.startRestart, PLANK_X_CORD + 40, PLANK_Y_CORD + 50);
        graphics.drawImage(Resources.controlImage, CONTROL_X_CORD, CONTROL_Y_CORD, null);

    }

    @Override
    public void onMousePress(int mouseXCord, int mouseYCord) {
        if ((mouseXCord > PLANK_X_CORD && mouseXCord < PLANK_X_CORD + PLANK_WIDTH) && (mouseYCord > PLANK_Y_CORD && mouseYCord < PLANK_Y_CORD + PLANK_HEIGHT)) {
            Resources.selectAudio.play();
            this.gPanel.currentScreen = new Stage1Screen(this.gPanel);
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
        if(keyCode == KeyEvent.VK_UP) {
            Resources.selectAudio.play();
            this.gPanel.currentScreen = new Stage1Screen(this.gPanel);
        }
    }
}
