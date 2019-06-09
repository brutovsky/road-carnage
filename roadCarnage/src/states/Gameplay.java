package states;

import gameObjects.Road;
import org.newdawn.slick.*;
import gameObjects.Bonus;
import gameObjects.Car;
import gameObjects.Player;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.PlayerCars;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

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


    public Gameplay(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        player = new Player(0.5f,350, 500,new Rectangle(Road.X,Road.Y,Road.WIDTH,Road.HEIGHT),PlayerCars.ANISTON);
        road = new Road(new Image("\\res\\roadSkins\\road.bmp"), 1,0,0,player);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        road.draw();
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
    }
}
