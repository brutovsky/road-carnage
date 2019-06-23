package gameObjects.stuff;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public enum Decorations {

    TREE("\\res\\decorations\\tree0.png", 1f),
    TREE1("\\res\\decorations\\tree1.png", 1f),
    TREE2("\\res\\decorations\\tree2.png", 1f),
    TREE3("\\res\\decorations\\tree3.png", 1f),
    TREE4("\\res\\decorations\\tree4.png", 1f),
    TREE5("\\res\\decorations\\tree5.png", 1f),
    TREE6("\\res\\decorations\\tree6.png", 1f),
    TREE7("\\res\\decorations\\tree7.png", 1f),
    TREE8("\\res\\decorations\\tree8.png", 1f),
    COW("\\res\\decorations\\Cow.png", 0.1f),
    COW1("\\res\\decorations\\cow1.png", 0.1f),

    POLAR_BEAR("\\res\\decorations\\Polar_Bear.png", 0.1f),
    POLAR_BEAR2("\\res\\decorations\\polarbearWithTeddy1.png", 0.1f),
    ICEPOOL("\\res\\decorations\\ice_pool.png", 0.1f),
    PENGUIN("\\res\\decorations\\Penguin.png", 0.1f),
    PENGUIN1("\\res\\decorations\\Penguin1.png", 0.1f),
    POCKEMON("\\res\\decorations\\pockemon.png", 0.1f),
    POCKEMON1("\\res\\decorations\\pockemon1.png", 0.1f),
    ROCK("\\res\\decorations\\rock.png", 0.1f),

    CACTUS1("\\res\\decorations\\cactus1.png", 1f),
    CACTUS2("\\res\\decorations\\cactus2.png", 1f),
    CACTUS3("\\res\\decorations\\cactus3.png", 1f),
    CACTUS4("\\res\\decorations\\cactus4.png", 1f),
    CACTUS5("\\res\\decorations\\cactus5.png", 1f),
    CACTUS6("\\res\\decorations\\cactus6.png", 1f),
    GOLEM("\\res\\decorations\\golem.png", 1f),
    PALM("\\res\\decorations\\palm.png", 1f),

    HUMAN1("\\res\\decorations\\human1.png", 1f),
    HUMAN2("\\res\\decorations\\human2.png", 1f),
    HUMAN3("\\res\\decorations\\human3.png", 1f),
    HUMAN4("\\res\\decorations\\human4.png", 1f),
    HUMAN5("\\res\\decorations\\human5.png", 1f),
    HUMAN6("\\res\\decorations\\human6.png", 1f),
    BANNER("\\res\\decorations\\EntryBaner.png", 1f),
    BANNER1("\\res\\decorations\\EntryBaner1.png", 1f),
    BANNER2("\\res\\decorations\\EntryBaner2.png", 1f),
    BANNER3("\\res\\decorations\\EntryBaner3.png", 1f),
    RIDER("\\res\\decorations\\Rider.png", 1f),
    RIDER1("\\res\\decorations\\Rider1.png", 1f),
    CITYTREE("\\res\\decorations\\cityTree.png", 1f),;


    private Image image;
    private float scale;

    Decorations(String path, float scale) {
        try {
            image = new Image(path);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        this.scale = scale;

    }

    public Image getImage() {
        return image;
    }

    public float getScale() {
        return scale;
    }


}
