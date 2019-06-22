package states;


import gameObjects.*;

import gameObjects.Road;

import gameObjects.levelGenerators.*;
import gameObjects.levelGenerators.LevelDecorations;
import gameObjects.stuff.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.newdawn.slick.*;
import org.newdawn.slick.opengl.Texture;

import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Gameplay extends BasicGame {

    public static final int LEVEL_DESERT = 1;
    public static final int LEVEL_ARCTIC = 2;
    public static final int LEVEL_JUNGLE = 3;
    public static final int LEVEL_CITY = 4;
    public static final int LEVEL_WORLD = 5;

    Clip clankSound;
    Clip carHitSound;
    private boolean soundCheck;

    private GameMenu menu;

    private boolean menuActive = false;

    private int id;
    private Player player;

    private float km = 0;

    private float generateTimer = -Road.HEIGHT;
    float konusTimer = generateTimer;
    float counter = 0;


    // Test
    Road road;
    LevelDecorations decor;
    int speed_koef;
    //


    DessertLevel level;

    public Gameplay(String title) {
        super(title);
    }


    static public class Game implements Runnable {

        private Thread t;

        public Game(String threadName) {
            t = new Thread(this, threadName);
            System.out.println("Game thread crated: " + t);
            t.start();
        }

        @Override
        public void run() {
            AppGameContainer app = null;
            try {
                app = new AppGameContainer(new Gameplay(Constants.GAME_TITLE));
                app.setDisplayMode(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, Constants.FULLSCREAN_MOD);
                app.setIcon("res/icon/icon.png");
                app.start();
                app.destroy();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }

        public void join() throws InterruptedException {
            t.join();
        }
    }

    @Override
    public void init(GameContainer gc)
            throws SlickException {
        gc.setShowFPS(true);
        gc.setTargetFrameRate(60);
        road = new Road();
        decor = new LevelDecorations();
        player = new Player(1f, Road.LINE5, 600, Road.FULL_ROAD, PlayerCars.ANISTON);
        speed_koef = 1;
        level = new DessertLevel();
        menu = new GameMenu();
        try {
            if (!AL.isCreated()) {
                AL.create();
            }
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        soundCheck = false;
    }//end init

    ////

    ////


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        road.draw();
        for (GameObject go : decor.getDecorationsL()) {
            go.draw();
        }
        for (GameObject go : decor.getDecorationsR()) {
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
        if (menuActive) {
            menu.draw();
        }

    }


    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        Input input = gameContainer.getInput();
        if (menuActive) {
            menu.update(i, input.getMouseX(), input.getMouseY());
            if (menu.isMouseOnExit(input.getMouseX(), input.getMouseY())) {
                if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    clankSound = Animator.createClip(clankSound,"src/sounds/CLANK!.wav");
                    clankSound.start();
                    gameContainer.setForceExit(false);
                    gameContainer.exit();
                }
            }else if(menu.isMouseOnContinue(input.getMouseX(), input.getMouseY())) {
                if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    clankSound = Animator.createClip(clankSound,"src/sounds/CLANK!.wav");
                    clankSound.start();
                    menuActive = false;
                }
            }else if(input.isKeyPressed(Input.KEY_ESCAPE)) {
                menuActive = false;
            }
        } else {
            if (generateTimer <= 0) {
                level.generate();
                level.createObstacles(road);
                generateTimer = Road.HEIGHT;
                road.collectGarbage();
            } else {
                generateTimer -= player.getCurrentSpeed() * speed_koef * i / Constants.DIVIDE_DELTA;
            }

            if (konusTimer <= 0) {
                level.createCentreRoadObstacle(road);
                konusTimer = Road.HEIGHT;
            } else {
                konusTimer -= player.getCurrentSpeed() * speed_koef * i / Constants.DIVIDE_DELTA;
            }
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
            km += player.getCurrentSpeed() * speed_koef * i / Constants.DIVIDE_DELTA / 10000;


            for (GameObject go : road.getObstacles()) {
                go.update(player.getCurrentSpeed() * speed_koef, i);
            }
            for (GameObject go : decor.getDecorationsL()) {
                go.update(player.getCurrentSpeed() * speed_koef, i);
            }
            for (GameObject go : decor.getDecorationsR()) {
                go.update(player.getCurrentSpeed() * speed_koef, i);
            }
            decor.update();

            if (!player.isBroken()) {
                speed_koef = 0;
            }


            if (!(player.isImmortal() || player.isJumping()||!player.isBroken())) {
                if (player.checkForCollision(Road.DANGER_ZONE_LEFT)) {
                    player.dangerZone();
                } else if (player.checkForCollision(Road.DANGER_ZONE_RIGHT)) {
                    player.dangerZone();
                }
            }


            for (GameObject object : road.getObstacles()) {
                if (player.checkForCollision(object)) {
                    if (!(player.isImmortal() || player.isJumping()||!player.isBroken())) {
                        if (object instanceof Car) {
                            ((Car) object).setSpeed(0);
                            player.collision(((Car) object).collisionOccured());
                            System.out.println("COLLISION");
                            break;
                        } else if (object instanceof Obstacle) {
                            player.collision(((Obstacle) object).collisionOccured());
                            System.out.println(((Obstacle) object).collisionOccured());
                            System.out.println("OBSTACLE");
                            break;
                        }
                    }
                    if (object instanceof Bonus) {
                        player.collision(((Bonus) object).collisionOccured());
                        road.getObstacles().remove(object);
                        System.out.println("BONUS");
                        break;
                    }
                }
            }

            player.update(i);

            for (GameObject car : road.getObstacles()) {
                if (car instanceof Car) {
                    for (GameObject object : road.getObstacles()) {
                        if (car == object) {
                            continue;
                        }
                        if (((Car) car).checkForCollision(object)) {
                            if(!(((Car) car).getSpeed() == 0)){
                                if(!soundCheck){
                                    carHitSound = Animator.createClip(carHitSound,"res/sounds/carsHit.wav");
                                    carHitSound.start();
                                    soundCheck = true;
                                }
                                ((Car) car).setSpeed(0);
                                break;
                            }
                        }
                    }
                }
            }
            soundCheck = false;
            if (input.isKeyPressed(Input.KEY_ESCAPE)) {
                menuActive = true;
            }
        }

    }

}

