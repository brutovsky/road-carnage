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
    private int counter;

    public LevelDecorations() {
        decorationsLeft = new ArrayList<>();
        decorationsRight = new ArrayList<>();
        typoOfMap();
        addDecorations();
    }

    private void typoOfMap() {
        if (Road.PATH.equals(Levels.JUNGLE.getPath())) {
            map = "Forest";
        } else if (Road.PATH.equals(Levels.DESERT.getPath())) {
            map = "Desert";
        } else if (Road.PATH.equals(Levels.ARCTIC.getPath())) {
            map = "Arctic";
        } else if (Road.PATH.equals(Levels.CITY.getPath())) {
            map = "City";
        } else
            map = "Tour";
    }

    public void update() {
        switch (map) {
            case "Tour":
                if (getDownPictureL().getY() > 700) {
                    if (counter < 8) {
                        map = "Desert";
                        if (counter % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -92 * 23));
                            decorationsRight.add(randomDecoration(820, -92 * 23));
                        } else {

                            decorationsLeft.add(randomDecoration(130, -92 * 23));
                            decorationsRight.add(randomDecoration(910, -92 * 23));
                        }
                    } else if (counter >= 8 && counter < 16) {
                        map = "Arctic";
                        if (counter % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -88 * 23));
                            decorationsRight.add(randomDecoration(820, -88 * 23));
                        } else {

                            decorationsLeft.add(randomDecoration(130, -88 * 23));
                            decorationsRight.add(randomDecoration(910, -88 * 23));
                        }
                    } else if (counter >= 16 && counter < 24) {
                        map = "Forest";
                        if (counter % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -91 * 23));
                            decorationsRight.add(randomDecoration(820, -91 * 23));
                        } else {

                            decorationsLeft.add(randomDecoration(130, -91 * 23));
                            decorationsRight.add(randomDecoration(910, -91 * 23));
                        }
                    } else  {
                        map = "City";
                        if (counter % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -89 * 23));
                            decorationsRight.add(new Decoration(1f, 810, -89 * 23, Decorations.RIDER1));
                        } else {
                            decorationsLeft.add(new Decoration(1f, 190, -89 * 23, Decorations.RIDER));
                            decorationsRight.add(randomDecoration(910, -89 * 23));
                        }
                    }
                    decorationsLeft.remove(getDownPictureL());
                    decorationsRight.remove(getDownPictureR());
                    counter++;
                    if (counter == 32) counter = 0;
                }
                map = "Tour";
                break;
            case "City":
                if (getDownPictureL().getY() > 700) {
                    if (location % 2 == 0) {
                        decorationsLeft.add(randomDecoration(20, -80));
                        decorationsRight.add(new Decoration(1f, 810, -80, Decorations.RIDER1));
                    } else {
                        decorationsLeft.add(new Decoration(1f, 190, -80, Decorations.RIDER));
                        decorationsRight.add(randomDecoration(910, -80));
                    }
                    decorationsLeft.remove(getDownPictureL());
                    decorationsRight.remove(getDownPictureR());
                    location++;
                }
                break;
            default:
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


    }

    public void addDecorations() {
        switch (map) {
            case "Tour":
                for (int i = 0; i < 32; i++) {
                    if (i < 8) {
                        map = "Desert";
                        if (decorationsLeft.size() % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -90 * i));
                            decorationsRight.add(randomDecoration(820, -90 * i));
                        } else {

                            decorationsLeft.add(randomDecoration(130, -90 * i));
                            decorationsRight.add(randomDecoration(910, -90 * i));
                        }
                    } else if (i >= 8 && i < 16) {
                        map = "Arctic";
                        if (decorationsLeft.size() % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -90 * i));
                            decorationsRight.add(randomDecoration(820, -90 * i));
                        } else {

                            decorationsLeft.add(randomDecoration(130, -90 * i));
                            decorationsRight.add(randomDecoration(910, -90 * i));
                        }
                    } else if (i >= 16 && i < 24) {
                        map = "Forest";
                        if (decorationsLeft.size() % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -90 * i));
                            decorationsRight.add(randomDecoration(820, -90 * i));
                        } else {

                            decorationsLeft.add(randomDecoration(130, -90 * i));
                            decorationsRight.add(randomDecoration(910, -90 * i));
                        }
                    } else if (i >= 24) {
                        map = "City";
                        if (decorationsLeft.size() % 2 == 0) {
                            decorationsLeft.add(randomDecoration(20, -90 * i));
                            decorationsRight.add(new Decoration(1f, 810, -90 * i, Decorations.RIDER1));
                        } else {
                            decorationsLeft.add(new Decoration(1f, 190, -90 * i, Decorations.RIDER));
                            decorationsRight.add(randomDecoration(910, -90 * i));
                        }
                    }

                }
                map = "Tour";
                break;
            case "City":
                for (int i = 0; i < 8; i++) {
                    if (decorationsLeft.size() % 2 == 0) {
                        decorationsLeft.add(randomDecoration(20, -80 * i));
                        decorationsRight.add(new Decoration(1f, 810, -80 * i, Decorations.RIDER1));
                    } else {
                        decorationsLeft.add(new Decoration(1f, 190, -80 * i, Decorations.RIDER));
                        decorationsRight.add(randomDecoration(910, -80 * i));
                    }
                }
                break;
            default:
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
                rand = Constants.random.nextInt(20);
                switch (rand) {
                    case 0:
                        return new Decoration(1f, x + 20, y - 50, Decorations.HUMAN1);
                    case 1:
                        return new Decoration(1f, x + 20, y - 50, Decorations.HUMAN2);
                    case 2:
                        return new Decoration(1f, x + 20, y - 50, Decorations.HUMAN3);
                    case 3:
                        return new Decoration(1f, x + 20, y - 50, Decorations.HUMAN4);
                    case 4:
                        return new Decoration(1f, x + 20, y - 50, Decorations.HUMAN5);
                    case 5:
                        return new Decoration(1f, x + 20, y - 50, Decorations.HUMAN6);
                    case 6:
                        return new Decoration(1f, x + 20, y - 50, Decorations.BANNER);
                    case 7:
                        return new Decoration(1f, x + 20, y - 50, Decorations.BANNER1);
                    case 8:
                        return new Decoration(1f, x + 20, y - 50, Decorations.BANNER2);
                    case 9:
                        return new Decoration(1f, x + 20, y - 50, Decorations.BANNER3);
                    default:
                        return new Decoration(1f, x + 20, y - 50, Decorations.CITYTREE);
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
