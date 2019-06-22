package gameObjects;

import org.newdawn.slick.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class GameMenu implements Drawable {

    private Clip chooseSound;
    private boolean soundCheck;

    private float exitB_x;
    private float exitB_y;

    private float continueB_x;
    private float continueB_y;

    private Animation exitB0;
    private Animation exitB1;
    private Animation exitB;

    private Animation continueB0;
    private Animation continueB1;
    private Animation continueB;
    private float indent = 100;

    public GameMenu() {
        createExitAnimations();
        createContinueAnimations();
        exitB = exitB0;
        continueB = continueB0;
        initSounds();
    }

    private void initSounds() {
        chooseSound = null;
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(System.getProperty("user.dir") + "/src/sounds/ESC.wav").getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            chooseSound = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            chooseSound.open(audioInputStream);
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void createExitAnimations() {

        exitB0 = new Animation();
        exitB1 = new Animation();
        //0

        exitB0 = Animator.animate("res/menu/exit0.png", 3, 1, 100, true);
        //1
        exitB1 = Animator.animate("res/menu/exit1.png", 3, 1, 100, true);
    }

    private void createContinueAnimations() {

        continueB0 = new Animation();
        continueB1 = new Animation();
        //0

        continueB0 = Animator.animate("res/menu/continue0.png", 3, 1, 100, true);
        //1
        continueB1 = Animator.animate("res/menu/continue1.png", 3, 1, 100, true);
    }

    @Override
    public void update(float shift, int delta) {

    }

    @Override
    public void update(int delta) {

    }

    public void update(int delta, float mouse_x, float mouse_y) {
        if (isMouseOnExit(mouse_x, mouse_y)) {
            if (!soundCheck) {
                initSounds();
                chooseSound.start();
                soundCheck = true;
            }
            exitB = exitB1;
        } else if (isMouseOnContinue(mouse_x, mouse_y)) {
            if (!soundCheck) {
                initSounds();
                chooseSound.start();
                soundCheck = true;
            }
            continueB = continueB1;
        } else {
            soundCheck = false;
            continueB = continueB0;
            exitB = exitB0;
        }
        updateExitLocation();
    }

    @Override
    public void draw() {
        exitB.draw(exitB_x, exitB_y);
        continueB.draw(continueB_x, continueB_y);
    }

    public void updateExitLocation() {
        exitB_x = Road.CENTR - exitB.getWidth() / 2;
        exitB_y = Road.HEIGHT / 2 - exitB.getHeight() / 2 + indent;
        continueB_x = Road.CENTR - continueB.getWidth() / 2;
        continueB_y = Road.HEIGHT / 2 - continueB.getHeight() / 2 - indent;
    }

    public boolean isMouseOnExit(float x, float y) {
        if (x >= exitB_x && x <= exitB_x + exitB.getImage(0).getWidth() && y >= exitB_y && y <= exitB_y + exitB.getImage(0).getHeight()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMouseOnContinue(float x, float y) {
        if (x >= continueB_x && x <= continueB_x + continueB.getImage(0).getWidth() && y >= continueB_y && y <= continueB_y + continueB.getImage(0).getHeight()) {
            return true;
        } else {
            return false;
        }
    }

}
