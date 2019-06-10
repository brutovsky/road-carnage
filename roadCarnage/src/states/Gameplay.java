package states;


import gameObjects.*;

import gameObjects.Road;

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
        road = new Road(new Image("\\res\\roadSkins\\desert.jpg"), 1, 0, -50, player);
        car1 = new Car(1f, road.getStripX(Road.STRIP1), 10, Road.ROAD, Cars.TRUCK);
        car2 = new Car(1f, road.getStripX(Road.STRIP2), 10, Road.ROAD, Cars.TAXI);
        car3 = new Car(1f, road.getStripX(Road.STRIP3), 10, Road.ROAD, Cars.TRUCK);
        cherry = new Bonus(1f, 500, 100, player, Bonuses.CHERRY);
        obstacles.add(car1);
        obstacles.add(car2);
        obstacles.add(car3);
        obstacles.add(cherry);
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


       // road.update();


        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            player.moveForward(i);
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            player.moveBackward(i);
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            player.moveRight(i);
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            player.moveLeft(i);
        }
       // sides.update(i);
        road.update(i);
        for(GameObject go:obstacles){
            go.update();
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
