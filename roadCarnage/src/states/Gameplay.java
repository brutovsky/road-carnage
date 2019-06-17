package states;


import gameObjects.*;

import gameObjects.Road;

import gameObjects.levelGenerators.DessertLevel;
import gameObjects.stuff.*;
import org.newdawn.slick.*;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Gameplay extends BasicGameState {

    private int id;
    private Player player;

    private float generateTimer = -Road.HEIGHT;

    float counter = 0;


    // Test
    Road road;
    int speed_koef;
    //

    ArrayList<GameObject> obstacles = new ArrayList();
    ArrayList<GameObject> decorations = new ArrayList();

    DessertLevel level;


    public Gameplay(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        road = new Road();
        player = new Player(1f, Road.LINE5, 600, Road.FULL_ROAD, PlayerCars.ANISTON);
        speed_koef = 1;
        level = new DessertLevel();
    }


    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        road.draw();
        for (GameObject go : decorations) {
            go.draw();
        }
        for (GameObject go : road.getObstacles()) {
            go.draw();
        }
        player.draw();
    }


    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        if (generateTimer <= 0) {
            level.generate();
            level.createObstacles(road);
            generateTimer = Road.HEIGHT;
        } else {
            generateTimer -= player.getSpeed() * speed_koef * i / Constants.DIVIDE_DELTA;
        }

        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            player.moveForward(i * speed_koef);
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            player.moveBackward(i * speed_koef);
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            player.moveRight(i * speed_koef);
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            player.moveLeft(i * speed_koef);
        }

        road.update(player.getSpeed() * speed_koef, i);


        for (GameObject go : road.getObstacles()) {
            go.update(player.getSpeed() * speed_koef, i);
        }


        if (!player.isBroken()) {
            speed_koef = 0;
        }


        if (!(player.isImmortal() || player.isJumping() || player.isFalling())) {
            if (player.checkForCollision(Road.DANGER_ZONE_LEFT)) {
                //player.dangerZone();
            } else if (player.checkForCollision(Road.DANGER_ZONE_RIGHT)) {
                //player.dangerZone();
            }
        }

        if (!(player.isImmortal() || player.isJumping() || player.isFalling())) {
            for (GameObject object : road.getObstacles()) {
                if (player.checkForCollision(object)) {
                    if (object instanceof Car) {
                        player.collision(((Car) object).collisionOccured());
                        System.out.println("COLLISION");
                        break;
                    } else if (object instanceof Bonus) {
                        //player.collision(((Bonus) object).collisionOccured());
                        System.out.println("BONUS");
                        break;
                    } else if (object instanceof Obstacle) {
                        player.collision(((Obstacle) object).collisionOccured());
                        System.out.println("OBSTACLE");
                        break;
                    }
                }
            }
        }

        player.update(i);
    }
}
