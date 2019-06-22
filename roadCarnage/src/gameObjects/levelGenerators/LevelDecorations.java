package gameObjects.levelGenerators;

import gameObjects.Decoration;
import gameObjects.GameObject;
import gameObjects.Road;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Decorations;
import gameObjects.stuff.Levels;

import java.util.ArrayList;
import java.util.List;

public class LevelDecorations {
    private List<GameObject> decorationsLeft;
    private List<GameObject> decorationsRight;
    private String map;
    private int location;

    public LevelDecorations() {
        decorationsLeft = new ArrayList<>();
        decorationsRight = new ArrayList<>();
        typoOfMap();
        addDecorations();
    }

    private void typoOfMap() {
        if (Road.PATH.equals(Levels.JUNGLE.getPath())) {
            map = "Forest";//CHANGED
        } else if (Road.PATH.equals(Levels.DESERT.getPath())) {
            map = "Desert";
        } else if (Road.PATH.equals(Levels.ARCTIC.getPath())) {
            map = "Arctic";
        } else if (Road.PATH.equals(Levels.CITY.getPath())) {
            map = "City";
        }
    }

    public void update() {

        if (getDownPictureL().getY() > 700) {
            if (location % 2 == 0) {
                decorationsLeft.add(randomDecoration(40, -90));
                decorationsRight.add(randomDecoration(820, -90));
            } else {
                decorationsLeft.add(randomDecoration(150, -90));
                decorationsRight.add(randomDecoration(910, -90));
            }
            decorationsLeft.remove(getDownPictureL());
            decorationsRight.remove(getDownPictureR());
            location++;
        }

    }

    public void addDecorations() {
        for (int i = 0; i < 8; i++) {
            if (decorationsLeft.size() % 2 == 0) {
                decorationsLeft.add(randomDecoration(20, -90 * i));
                decorationsRight.add(randomDecoration(820, -90 * i));
            } else {
                decorationsLeft.add(randomDecoration(130, -90 * i));
                decorationsRight.add(randomDecoration(910, -90 * i));
            }
        }

    }

    private Decoration randomDecoration(int x, int y) {
        System.out.println(map);
        switch (map) {
            case "Forest":
                int rand = Constants.random.nextInt(11);
                switch (rand) {
                    case 0:
                        return new Decoration(1f, x, y, Decorations.TREE);
                    case 1:
                        return new Decoration(1f, x, y, Decorations.TREE1);
                    case 2:
                        return new Decoration(1f, x, y, Decorations.TREE2);
                    case 3:
                        return new Decoration(1f, x, y, Decorations.TREE3);
                    case 4:
                        return new Decoration(1f, x, y, Decorations.TREE4);
                    case 5:
                        return new Decoration(1f, x, y, Decorations.TREE5);
                    case 6:
                        return new Decoration(1f, x, y, Decorations.TREE6);
                    case 7:
                        return new Decoration(1f, x, y, Decorations.TREE7);
                    case 8:
                        return new Decoration(1f, x, y, Decorations.TREE8);
                    case 9:
                        return new Decoration(1f, x, y, Decorations.COW1);
                    default:
                        return new Decoration(1f, x, y, Decorations.COW);

                }
            case "Desert":
                rand = Constants.random.nextInt(15);
                switch (rand) {
                    case 0:
                        return new Decoration(1f, x, y, Decorations.CACTUS1);
                    case 1:
                        return new Decoration(1f, x, y, Decorations.CACTUS2);
                    case 3:
                        return new Decoration(1f, x, y, Decorations.CACTUS4);
                    case 4:
                        return new Decoration(1f, x, y, Decorations.CACTUS5);
                    case 5:
                        return new Decoration(1f, x, y, Decorations.CACTUS6);
                    case 6:
                        return new Decoration(1f, x, y, Decorations.PALM);
                    case 7:
                        return new Decoration(1f, x, y, Decorations.GOLEM);
                    default:
                        return new Decoration(1f, x, y, Decorations.CACTUS3);


                }
            case "Arctic":
                rand = Constants.random.nextInt(15);
                switch (rand) {
                    case 0:
                        return new Decoration(1f, x + 20, y - 50, Decorations.POLAR_BEAR);
                    case 3:
                        return new Decoration(1f, x + 20, y - 50, Decorations.POLAR_BEAR2);
                    case 4:
                        return new Decoration(1f, x + 20, y - 50, Decorations.POCKEMON1);
                    case 6:
                        return new Decoration(1f, x + 20, y - 50, Decorations.ROCK);
                    case 7:
                        return new Decoration(1f, x + 20, y - 50, Decorations.ICEPOOL);
                    case 8:
                        return new Decoration(1f, x + 20, y - 50, Decorations.PENGUIN1);
                    case 9:
                        return new Decoration(1f, x + 20, y - 50, Decorations.POCKEMON);
                    default:
                        return new Decoration(1f, x + 20, y - 50, Decorations.PENGUIN);
                }

            case "City":
                rand = Constants.random.nextInt(11);
                switch (rand) {

                }
            default:
                return new Decoration(1f, x, y, Decorations.COW);

        }
    }

    public List<GameObject> getDecorationsL() {
        return decorationsLeft;
    }

    public List<GameObject> getDecorationsR() {
        return decorationsRight;
    }

    private GameObject getDownPictureL() {
        for (int i = 0; i < decorationsLeft.size(); i++)
            if (decorationsLeft.get(i) != null)
                return decorationsLeft.get(i);
        return null;
    }

    private GameObject getDownPictureR() {
        for (int i = 0; i < decorationsRight.size(); i++)
            if (decorationsRight.get(i) != null)
                return decorationsRight.get(i);
        return null;
    }
}
