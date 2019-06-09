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
    Rectangle rect1;
    Rectangle rect2;
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
        rect1 = new Rectangle(0, 0, 300, 700);
        rect2 = new Rectangle(rect1.getWidth(), 0, 1000 - 2 * rect1.getWidth(), 700);
        player = new Player(0.5f,Game.WIDTH/2 - PlayerCars.ANISTON.getImage().getWidth()/4, Game.HEIGHT-100,rect2,PlayerCars.ANISTON);
        car1 = new Car(1f,(int)rect2.getX()+rect2.getWidth()/7,10,rect2, Cars.TRUCK);
        car2 = new Car(1f,(int)rect2.getX()+rect2.getWidth()/2,10,rect2, Cars.TAXI);
        car3 = new Car(1f,(int)rect2.getX()+rect2.getWidth()/1.3f,10,rect2, Cars.TRUCK);
        cherry = new Bonus(0.5f,400,50,player, Bonuses.CHERRY);
        road = new Road(new Image("\\res\\roadSkins\\road.bmp"), 1,0,0,player);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        road.draw();
        player.draw();
        car1.draw();
        car2.draw();
        car3.draw();
        cherry.draw();

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        car1.update();
        car2.update();
        car3.update();
        road.update();
        Input input = gameContainer.getInput();
        if(input.isKeyDown(Input.KEY_UP)){
            player.moveForward();
        }
        if(input.isKeyDown(Input.KEY_DOWN)){
            player.moveBackward();
        }
        if(input.isKeyDown(Input.KEY_RIGHT)){
            player.moveRight();
        }
        if(input.isKeyDown(Input.KEY_LEFT)){
            player.moveLeft();
        }


    }
}
