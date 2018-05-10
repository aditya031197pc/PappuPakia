package in.codeKamp.main;

import in.codeKamp.resources.Resources;
import in.codeKamp.screens.Screen;
import in.codeKamp.screens.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements KeyListener, Runnable, MouseListener {
    public Screen currentScreen;
    public int bestScore = 0;

    GamePanel() {
        this.setPreferredSize(new Dimension(Game.GAME_WIDTH, Game.GAME_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        Resources.load();
        Resources.pappuPakiaAudio.loop();
        this.currentScreen = new WelcomeScreen(this);
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.currentScreen.onKeyPress(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.currentScreen.onMousePress(e.getX(), e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        Image bigImage = new BufferedImage(Game.GAME_WIDTH, Game.GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }

            this.currentScreen.update();

            Graphics panelGraphic = this.getGraphics();
            Graphics imageGraphic = bigImage.getGraphics();

            imageGraphic.clearRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
            this.currentScreen.draw(imageGraphic);
            imageGraphic.dispose();

            panelGraphic.drawImage(bigImage, 0, 0, null);
            panelGraphic.dispose();
        }
    }
}