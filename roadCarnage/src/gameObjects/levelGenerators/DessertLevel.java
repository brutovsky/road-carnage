package gameObjects.levelGenerators;

import gameObjects.Bonus;
import gameObjects.Car;
import gameObjects.Obstacle;
import gameObjects.Road;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.Obstacles;

import java.util.HashMap;

public class DessertLevel extends LevelGenerator {

    DessertLevel() {
        super(3, 4);

    }

    public void initObstacles(){
        obstacles = new HashMap<>();
        obstacles.put(0,null);
        obstacles.put(1,new Obstacle(1f,X,Y, Obstacles.CACTUS));
        obstacles.put(2,new Obstacle(1f,X,Y, Obstacles.HOLE));
        obstacles.put(3,new Obstacle(1f,X,Y, Obstacles.KONUS));
        obstacles.put(4,new Obstacle(1f,X,Y, Obstacles.DUNA));
        obstacles.put(5,new Car(1f,X,Y, Road.ROAD, Cars.TRUCK));
        obstacles.put(6,new Car(1f,X,Y, Road.ROAD, Cars.TAXI));
        obstacles.put(7,new Car(1f,X,Y, Road.ROAD, Cars.CASUAL_BLUE));
        obstacles.put(8,new Car(1f,X,Y, Road.ROAD, Cars.CASUAL_GREEN));
        obstacles.put(9,new Car(1f,X,Y, Road.ROAD, Cars.CASUAL_BLACK));
        obstacles.put(10,new Bonus(1f,X,Y, Bonuses.CHERRY));
        obstacles.put(10,new Car(1f,X,Y, Road.ROAD, Cars.HOTDOG));
        obstacles.put(10,new Car(1f,X,Y, Road.ROAD, Cars.HOTDOG));
        obstacles.put(10,new Car(1f,X,Y, Road.ROAD, Cars.HOTDOG));
        obstacles.put(10,new Car(1f,X,Y, Road.ROAD, Cars.HOTDOG));
    }

}
