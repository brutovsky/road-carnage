package states;

import gameObjects.*;
import org.newdawn.slick.*;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.PlayerCars;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
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
        player = new Player(0.5f,350, 500,Road.FULL_ROAD,PlayerCars.ANISTON);
        road = new Road(new Image("\\res\\roadSkins\\road.bmp"), 1,0,0,player);
        car1 = new Car(1f,road.getStripX(Road.STRIP1),10,Road.ROAD,Cars.TRUCK);
        car2 = new Car(1f,road.getStripX(Road.STRIP2),10,Road.ROAD,Cars.TAXI);
        car3 = new Car(1f,road.getStripX(Road.STRIP3),10,Road.ROAD,Cars.TRUCK);
        obstacles.add(car1);
        obstacles.add(car2);
        obstacles.add(car3);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        road.draw();
        car1.draw();
        car2.draw();
        car3.draw();
        player.draw();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        if(input.isKeyDown(Input.KEY_UP)){
            player.moveForward(i);
        }
        if(input.isKeyDown(Input.KEY_DOWN)){
            player.moveBackward(i);
        }
        if(input.isKeyDown(Input.KEY_RIGHT)){
            player.moveRight(i);
        }
        if(input.isKeyDown(Input.KEY_LEFT)){
            player.moveLeft(i);
        }
        road.update(i);
        car1.update();
        car2.update();
        car3.update();
        for(GameObject object:obstacles){
            if(player.checkForCollision(object)){
                player.setSpeed(0);
                System.out.println("COLLISION");
            }
        }
    }
}
