package states;


import gameObjects.*;

import gameObjects.Road;

import gameObjects.stuff.*;
import org.newdawn.slick.*;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Random;

public class Gameplay extends BasicGameState {

    private int id;
    private Player player;


    // Test
    Road road;
    Car car1;
    Car car2;
    Car car3;

    Bonus cherry;
    Decoration tree;

    Decoration tree1; Decoration tree2;
    Obstacle cactus;
    Obstacle conus;
    Obstacle hole;
    Obstacle tramp;
    Obstacle duna;
    int durability;
    int speed_koef;
    //

    ArrayList<GameObject> obstacles = new ArrayList();
    ArrayList<GameObject> decorations = new ArrayList();


    public Gameplay(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        speed_koef = 1;
        player = new Player(0.5f, 350, 500, Road.FULL_ROAD, PlayerCars.ANISTON);
        road = new Road();

        car1 = new Car(1f, Road.STRIP1, 10, Road.ROAD, Cars.TRUCK);
        car2 = new Car(1f, Road.STRIP2, 10, Road.ROAD, Cars.TAXI);
        car3 = new Car(1f, Road.STRIP3, 10, Road.ROAD, Cars.TRUCK);
        cherry = new Bonus(1f, 500, 100, Bonuses.CHERRY);
        cactus = new Obstacle(1f, 700, 10, Obstacles.CACTUS);
        conus = new Obstacle(0.08f, 490, 10, Obstacles.KONUS);
        hole = new Obstacle(1f, 500, 100, Obstacles.HOLE);
        tramp = new Obstacle(1f, Road.LINE4, 50, Obstacles.TRAMPOLINE);
        duna = new Obstacle(0.95f, 300, 0, Obstacles.DUNA);

        obstacles.add(car1);
        obstacles.add(car2);
        obstacles.add(car3);
        obstacles.add(cherry);
        obstacles.add(cactus);
        obstacles.add(conus);
        obstacles.add(duna);
        obstacles.add(hole);





        obstacles.add(tramp);
        durability = player.getCurrentDurability();
    }



    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        road.draw();
        for (GameObject go : obstacles) {
            go.draw();
        }
        for (GameObject go : decorations) {
            go.draw();
        }
        player.draw();
        graphics.drawString("" + durability, 0, 0);
        graphics.draw(new Rectangle(Road.X + Road.WIDTH / 2, Road.Y, 100, 100));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (!player.isUnbroken()) {
            speed_koef = 0;
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

        for (GameObject go : obstacles) {
            go.update(player.getSpeed() * speed_koef, i);
        }
        for (GameObject go : decorations) {
            go.update(player.getSpeed() * speed_koef, i);
        }

        if (!player.isImmortal() || !player.isJumping() || !player.isFalling()) {
            if (player.checkForCollision(Road.DANGER_ZONE_LEFT)) {
                player.dangerZone();
            } else if (player.checkForCollision(Road.DANGER_ZONE_RIGHT)) {
                player.dangerZone();
            }
        }

        for (GameObject object : obstacles) {
            if (player.checkForCollision(object)) {
                if (player.isImmortal() || player.isJumping() || player.isFalling()) {
                    break;
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
                    } else if (object instanceof Obstacle) {
                        player.collision(((Obstacle) object).collisionOccured());
                        System.out.println("OBSTACLE");
                        break;
                    }
                }
            }
        }
        player.update(i);
        durability = player.getCurrentDurability();
    }
}
