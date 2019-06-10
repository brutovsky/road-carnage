package states;


import gameObjects.*;

import gameObjects.Road;

import gameObjects.stuff.Obstacles;
import org.newdawn.slick.*;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.PlayerCars;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Gameplay extends BasicGameState {

    private int id;
    private Player player;


    // Test
    Road road;
    Car car1;
    Car car2;
    Car car3;

    Bonus cherry;
    Obstacle cactus;
    Obstacle conus;
    Obstacle hole;
    //

    ArrayList<GameObject> obstacles = new ArrayList();


    public Gameplay(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        player = new Player(0.5f, 350, 500, Road.FULL_ROAD, PlayerCars.ANISTON);
        road = new Road();
        car1 = new Car(1f, road.getStripX(Road.STRIP1), 10, Road.ROAD, Cars.TRUCK);
        car2 = new Car(1f, road.getStripX(Road.STRIP2), 10, Road.ROAD, Cars.TAXI);
        car3 = new Car(1f, road.getStripX(Road.STRIP3), 10, Road.ROAD, Cars.TRUCK);
        cherry = new Bonus(1f, 500, 100,Bonuses.CHERRY);
        cactus = new Obstacle(1f,700,10, Obstacles.CACTUS);
        conus = new Obstacle(0.08f,490,10, Obstacles.KONUS);
        hole = new Obstacle(1f,road.getStripX(2)+5,10, Obstacles.HOLE);;
        obstacles.add(car1);
        obstacles.add(car2);
        obstacles.add(car3);
        obstacles.add(cherry);
        obstacles.add(cactus);
        obstacles.add(conus);
        obstacles.add(hole);

  }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        road.draw();
        for(GameObject go:obstacles){
            go.draw();
        }
        player.draw();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            player.setSpeed(player.getSpeed()*2);
            player.moveForward(i);
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            player.setSpeed(player.getSpeed()/2);
            player.moveBackward(i);
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            player.moveRight(i);
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            player.moveLeft(i);
        }

        road.update(player.getSpeed(),i);

        for(GameObject go:obstacles){
            go.update(player.getSpeed(),i);
        }
        for (GameObject object : obstacles) {
            if (player.checkForCollision(object)) {
                if (player.isImmortal()) {
                } else {
                    if (object instanceof Car) {
                        player.collision(((Car) object).collisionOccured());
                        System.out.println("COLLISION");
                        obstacles.remove(object);
                        break;
                    } else if (object instanceof Bonus) {
                        player.collision(((Bonus) object).collisionOccured());
                        System.out.println("BONUS");
                        obstacles.remove(object);
                        break;
                    }
                }
            }
        }
        player.update(i);
    }
}
