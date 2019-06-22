package gameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animator {

    private Animator() {

    }

    public static Animation animate(String path, int columns, int lines, int duration, boolean looping) {
        Image image = createImage(path);
        Animation animation = new Animation();
        SpriteSheet sprite_sheet;
        int spriteSheetWidth = image.getWidth();
        int spriteSheetHeight = image.getHeight();
        int spriteWidth = spriteSheetWidth / columns;
        int spriteHeight = spriteSheetHeight / lines;
        sprite_sheet = new SpriteSheet(image, spriteWidth, spriteHeight);
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < columns; x++) {
                animation.addFrame(sprite_sheet.getSubImage(x,y), duration);
            }
        }
        animation.setLooping(looping);
        return animation;
    }

    public static Image toSlickImage(BufferedImage image) {
        Texture tex = null;
        try {
            tex = BufferedImageUtil.getTexture("IMAGES", image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Image(tex);
    }

    public static Image createImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return toSlickImage(image);
        } catch (IOException e) {
            System.out.println("Path: " + path + " for the image is wrong. Image is not created.");
        }
        return null;
    }

    public static Clip createClip(Clip clip,String path){
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(path).getAbsoluteFile());
        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return clip;
    }

}
