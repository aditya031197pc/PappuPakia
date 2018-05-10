package in.codeKamp.screens;

import in.codeKamp.main.GamePanel;

import java.awt.*;

public class GameOverScreen extends WelcomeScreen {
    private int lastScore;
    GameOverScreen(GamePanel p, int lastScore) {
        super(p);
        this.startRestart = "Restart";
        this.lastScore = lastScore;

        if(this.lastScore > this.gPanel.bestScore) {
            this.gPanel.bestScore = this.lastScore;
        }
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Happy Sans", Font.ITALIC, 40));
        graphics.drawString("Last Score : " + this.lastScore, 400, 200 );
        graphics.drawString("Best Score : " + this.gPanel.bestScore, 400, 350 );

    }

    @Override
    public void onKeyPress(int keyCode) {
        super.onKeyPress(keyCode);
    }

    @Override
    public void onMousePress(int mouseXCord, int mouseYCord) {
        super.onMousePress(mouseXCord, mouseYCord);
    }

}
