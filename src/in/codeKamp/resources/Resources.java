package in.codeKamp.resources;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

public class Resources {
    public static Image groundImage;
    public static Image frontTreesImage;
    public static Image backTreesImage;
    public static Image cloudsImage;
    public static Image logImage;
    public static Image bgImage;
    public static Color bgColor;

    public static Image pappuImage1;
    public static Image pappuImage2;
    public static Image pappuImage3;
    public static Image pappuImage4;
    public static Image pappuImage5;
    public static Image pappuImage6;
    public static Image pappuImage7;
    public static Image pappuImage8;

    public static Image appleImage;
    public static Image berriesImage;
    public static Image starImage;
    public static Image plankImage;

    public static Image branchImage;
    public static Image forkHandleImage;
    public static Image forkHeadImage;

    public static Image controlImage;

    public static AudioClip flapAudio;
    public static AudioClip selectAudio;
    public static AudioClip pappuPakiaAudio;


    public static void load() {
        Resources.bgColor = new Color(71, 193, 255);
        try {
            Resources.controlImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/control.png"));
            Resources.groundImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/ground.png"));
            Resources.frontTreesImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/front_trees.png"));
            Resources.backTreesImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/back_trees.png"));
            Resources.cloudsImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/clouds.png"));
            Resources.logImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/log.png"));
            Resources.bgImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/bg_combined.png"));

            Resources.appleImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/apple.png"));
            Resources.berriesImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/berries.png"));
            Resources.starImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/star.png"));
            Resources.plankImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/plank_top.png"));
            Resources.branchImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/branch.png"));
            Resources.forkHandleImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/fork_handle.png"));
            Resources.forkHeadImage= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/fork_head.png"));

            Resources.pappuImage1= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu1.png"));
            Resources.pappuImage2= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu2.png"));
            Resources.pappuImage3= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu3.png"));
            Resources.pappuImage4= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu4.png"));
            Resources.pappuImage5= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu5.png"));
            Resources.pappuImage6= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu6.png"));
            Resources.pappuImage7= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu7.png"));
            Resources.pappuImage8= ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("in/codeKamp/resources/images/pappu8.png"));

            Resources.flapAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("in/codeKamp/resources/audios/jump.wav"));
            Resources.selectAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("in/codeKamp/resources/audios/star.wav"));
            Resources.pappuPakiaAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("in/codeKamp/resources/audios/theme.wav"));

        } catch (IOException e) {

        }
    }
}