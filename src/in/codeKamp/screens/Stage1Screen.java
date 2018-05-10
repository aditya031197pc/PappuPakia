package in.codeKamp.screens;

import in.codeKamp.entities.backgroundEntities.BackTrees;
import in.codeKamp.entities.backgroundEntities.Clouds;
import in.codeKamp.entities.backgroundEntities.FrontTrees;
import in.codeKamp.entities.backgroundEntities.Ground;
import in.codeKamp.entities.collidingEntities.*;
import in.codeKamp.main.Game;
import in.codeKamp.main.GamePanel;
import in.codeKamp.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Stage1Screen extends Screen {
    public static final int NO_OF_OBSTACLES = 20;
    private static final int POWER_UP_TIME = 200;

    private int score = 0;
    private int powerUpTimeCounter = POWER_UP_TIME;

    private Pappu pappu;
    private java.util.List<Clouds> clouds = new ArrayList<>();
    private java.util.List<Ground> grounds = new ArrayList<>();
    private java.util.List<FrontTrees> frontTrees = new ArrayList<>();
    private java.util.List<BackTrees> backTrees = new ArrayList<>();
    private java.util.List<Obstacle> obstacles = new ArrayList<>();
    private java.util.List<EscapeArea> escapeAreas = new ArrayList<>();
    private java.util.List<PowerUp> powerUps = new ArrayList<>(); // in this I have taken only 1 powerUp But there can be more than one powerUps


    Stage1Screen(GamePanel p) {
        super(p);
        // doubled all background entities so that they can come one after the other infinitely
        this.clouds.add(new Clouds(0, 0, -10));
        this.clouds.add(new Clouds(Game.GAME_WIDTH, 0, -10));
        this.entities.addAll(this.clouds);
        this.backTrees.add(new BackTrees(0, 0, -4));
        this.backTrees.add(new BackTrees(Game.GAME_WIDTH, 0, -4));
        this.entities.addAll(this.backTrees);
        this.frontTrees.add(new FrontTrees(0, 0, Game.MAIN_VELOCITY));
        this.frontTrees.add(new FrontTrees(Game.GAME_WIDTH, 0, Game.MAIN_VELOCITY));
        this.entities.addAll(this.frontTrees);

        for (int i = 0; i < NO_OF_OBSTACLES; i++) {
            this.addObstacleAndEscapeArea(i);
        }

        this.entities.addAll(this.obstacles);
        this.colidingEentities.addAll(this.obstacles);
        this.entities.addAll(this.escapeAreas);
        this.colidingEentities.addAll(this.escapeAreas);


        this.addPowerUps(1);
        // in this way we can add more powerUps of different Types...


        this.entities.addAll(this.powerUps);
        this.colidingEentities.addAll(this.powerUps);


        // ground is also a background entity but it needs to be added at last
        this.grounds.add(new Ground(0, 0, Game.MAIN_VELOCITY));
        this.grounds.add(new Ground(Game.GAME_WIDTH, 0, Game.MAIN_VELOCITY));
        this.entities.addAll(this.grounds);

        this.pappu = new Pappu(WelcomeScreen.PAPPU_X_CORD, WelcomeScreen.PAPPU_Y_CORD);
        this.entities.add(this.pappu);


    }


    @Override
    public void update() {
        super.update();

        if (this.pappu.y < -20 || this.pappu.y > Game.GAME_HEIGHT - 50) {
            this.gPanel.currentScreen = new GameOverScreen(this.gPanel, this.score);
        }


//        int noOfCollidingEntites = colidingEentities.size();


        for (CollidingEntity collidingEntity : colidingEentities) {
            if (this.pappu.isColliding(collidingEntity)) {

                if (collidingEntity.isObstacle) {
                    this.gPanel.currentScreen = new GameOverScreen(this.gPanel, this.score);
                    Resources.selectAudio.play();
                }

                if (collidingEntity.isPowerUp) {
                    collidingEntity.isVisible = false;
                    this.powerUp();
                    Resources.selectAudio.play();
                }
            }
        }
        this.score++;


    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Resources.bgColor);
        graphics.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
        super.draw(graphics);


        if (this.pappu.isPoweredUp && this.powerUpTimeCounter > 0) {
            this.drawPoweredUpPappu(graphics);

            this.powerUpTimeCounter--;

        } else if (this.powerUpTimeCounter <= 0) {
            this.pappuNoMorePoweredUp();
        }


        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Happy Sans", Font.ITALIC, 35));
        graphics.drawString("Score: "+this.score, 10, 30);


    }


    @Override
    public void onKeyPress(int keyCode) {
        if (keyCode == KeyEvent.VK_UP) {
            Resources.flapAudio.play();
            this.pappu.flap();

        }
    }


    private void addObstacleAndEscapeArea(int number) {
        EscapeArea tempArea;
        Obstacle tempObstacle1;
        Obstacle tempObstacle2;

        Random r = new Random();
        int sameXCord = Game.GAME_WIDTH + 50 + (number - 1) * 500;


        if (number == 1 || number == 4) {
            // this random y cord tells us how much sapce we need to leave added to
            // the escape area when drawing the fork objects
            int randomYCord = r.nextInt(50);

            tempArea = new EscapeArea(sameXCord, randomYCord);
            tempObstacle1 = new Obstacle(sameXCord - 8, randomYCord + EscapeArea.ESCAPE_HEIGHT -50, true, false);
            tempObstacle2 = new Obstacle(sameXCord, randomYCord + EscapeArea.ESCAPE_HEIGHT -50 + 57, false, true);

        } else {
            int randomYCord = r.nextInt(300);

            tempArea = new EscapeArea(sameXCord, randomYCord);
            tempObstacle1 = new Obstacle(sameXCord, randomYCord + EscapeArea.ESCAPE_HEIGHT, false, false);
            tempObstacle2 = new Obstacle(sameXCord, 0 - Game.GAME_HEIGHT + randomYCord, false, false);

        }
        this.escapeAreas.add(tempArea);
        this.obstacles.add(tempObstacle2);
        this.obstacles.add(tempObstacle1);

    }


    private void addPowerUps(int number) {
        Random r = new Random();
        int randomYCord = r.nextInt(300);
        int sameXCord = Game.GAME_WIDTH + (number - 1) * 1000;
        PowerUp powerUp = new PowerUp(sameXCord, randomYCord);
        this.powerUps.add(powerUp);
    }


    private void powerUp() {
        pappu.isVisible = false;
        pappu.isPoweredUp = true;
//        System.out.println("pappuPoweredUp");
    }


    private void drawPoweredUpPappu(Graphics graphics) {
        graphics.drawImage(pappu.image, pappu.x, pappu.y, null);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Happy Sans", Font.ITALIC, 35));
        graphics.drawString("Powered Up", 400, 30);

    }


    private void pappuNoMorePoweredUp() {
//        System.out.println("pappuNoMorePoweredUp");
        this.pappu.isVisible = true;
        this.pappu.isPoweredUp = false;
        this.powerUpTimeCounter = POWER_UP_TIME;
    }
}

