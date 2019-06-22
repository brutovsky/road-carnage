package gameObjects.levelGenerators;

import gameObjects.Road;

import java.util.ArrayList;
import java.util.Arrays;

public class WorldLevel extends LevelGenerator {

    private DessertLevel desert;
    private AntarcticLevel antarctic;
    private JungleLevel jungle;
    private CityLevel city;
    private int counter;

    public WorldLevel() {
        super(4, 4);
        initAllLevels();
        counter = 1;
    }

    private void initAllLevels() {
        desert = new DessertLevel();
        antarctic = new AntarcticLevel();
        jungle = new JungleLevel();
        city = new CityLevel();
    }

    @Override
    public void generate() {
        switch (counter) {
            case 1: {
                desert.generate();
                grid = Arrays.copyOf(desert.grid, desert.grid.length);
                for (int[] i : grid) {
                    System.out.println(Arrays.toString(i));
                }
                counter++;
                break;
            }
            case 2: {
                antarctic.generate();
                grid = Arrays.copyOf(antarctic.grid, antarctic.grid.length);
                counter++;
                break;
            }
            case 3: {
                jungle.generate();
                grid = Arrays.copyOf(jungle.grid, jungle.grid.length);
                counter++;
                break;
            }
            case 4: {
                city.generate();
                grid = Arrays.copyOf(city.grid, city.grid.length);
                counter = 1;
                break;
            }
        }
    }

    @Override
    public void createObstacles(Road road) {
        switch (counter) {
            case 1: {
                city.createObstacles(road);
                break;
            }
            case 2: {
                desert.createObstacles(road);
                break;
            }
            case 3: {
                antarctic.createObstacles(road);
                break;
            }
            case 4: {
                jungle.createObstacles(road);
                break;
            }
        }
    }
}
