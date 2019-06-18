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

    private float km = 0;

    private float generateTimer = -Road.HEIGHT;
    float konusTimer = generateTimer / 2;
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
        graphics.drawString("Speed - " + new Integer((int) player.getCurrentSpeed()).toString(), 10, 30);
        graphics.drawString("Mobility - " + new Integer((int) player.getCurrentMobility()).toString(), 10, 60);
        graphics.drawString("Durability - " + new Integer((int) player.getCurrentDurability()).toString(), 10, 90);
        graphics.drawString("KM - " + km, 10, 150);
    }


    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (generateTimer <= 0) {
            level.generate();
            level.createObstacles(road);
            generateTimer = Road.HEIGHT;
            road.collectGarbage();
        } else {
            generateTimer -= player.getCurrentSpeed() * speed_koef * i / Constants.DIVIDE_DELTA;
        }

        if (konusTimer <= 0) {
            level.createKonus(road);
            konusTimer = Road.HEIGHT / 2;
        } else {
            konusTimer -= player.getCurrentSpeed() * speed_koef * i / Constants.DIVIDE_DELTA;
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

        road.update(player.getCurrentSpeed() * speed_koef, i);
        km += player.getCurrentSpeed() * speed_koef*i/ Constants.DIVIDE_DELTA/10000;


        for (GameObject go : road.getObstacles()) {
            go.update(player.getCurrentSpeed() * speed_koef, i);
        }


        if (!player.isBroken()) {
            speed_koef = 0;
        }


        if (!(player.isImmortal() || player.isJumping() || player.isFalling())) {
            if (player.checkForCollision(Road.DANGER_ZONE_LEFT)) {
                player.dangerZone();
            } else if (player.checkForCollision(Road.DANGER_ZONE_RIGHT)) {
                player.dangerZone();
            }
        }

        if (!(player.isImmortal() || player.isJumping() || player.isFalling())) {
            for (GameObject object : road.getObstacles()) {
                if (player.checkForCollision(object)) {
                    if (object instanceof Car) {
                        ((Car) object).setSpeed(0);
                        player.collision(((Car) object).collisionOccured());
                        System.out.println("COLLISION");
                        break;
                    } else if (object instanceof Bonus) {
                        player.collision(((Bonus) object).collisionOccured());
                        road.getObstacles().remove(object);
                        System.out.println("BONUS");
                        break;
                    } else if (object instanceof Obstacle) {
                        player.collision(((Obstacle) object).collisionOccured());
                        System.out.println(((Obstacle) object).collisionOccured());
                        System.out.println("OBSTACLE");
                        break;
                    }
                }
            }
        }
        player.update(i);

        for (GameObject car : road.getObstacles()) {
            if (car instanceof Car) {
                for (GameObject object : road.getObstacles()) {
                    if(car == object){
                        continue;
                    }
                    if(((Car) car).checkForCollision(object)){
                        ((Car) car).setSpeed(0);
                        break;
                    }
                }
            }
        }


    }

}

