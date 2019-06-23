package states;


import gameObjects.*;

import gameObjects.Road;

import gameObjects.levelGenerators.*;
import gameObjects.levelGenerators.LevelDecorations;
import gameObjects.stuff.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;


public class Gameplay extends BasicGame {

    public static final int LEVEL_DESERT = 1;
    public static final int LEVEL_ARCTIC = 2;
    public static final int LEVEL_JUNGLE = 3;
    public static final int LEVEL_CITY = 4;
    public static final int LEVEL_WORLD = 5;

    Font font;

    Clip clankSound;
    Clip carHitSound;
    private boolean soundCheck;

    private GameMenu menu;

    private boolean menuActive = false;

    private int id;
    private Player player;

    private double km = 0;

    private float generateTimer = -Road.HEIGHT;
    float konusTimer = generateTimer;
    float counter = 0;


    // Test
    Road road;
    LevelDecorations decor;
    int speed_koef;
    //


    LevelGenerator level;

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
                app.setShowFPS(false);
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
        gc.setShowFPS(false);
        gc.setTargetFrameRate(60);
        road = new Road();
        decor = new LevelDecorations();
        initPlayer();
        speed_koef = 1;
        initLevel();
        menu = new GameMenu();
        soundCheck = false;
        try {
            font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new FileInputStream(new File("res/fonts/font.otf"))).deriveFont(java.awt.Font.PLAIN, 14);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initPlayer() {
        switch (PlayerStats.carChosen) {
            case 1: {
                player = new Player(1f, Road.CENTR, 500, Road.FULL_ROAD, PlayerCars.ANISTON);
                break;
            }
            case 2: {
                player = new Player(1f, Road.CENTR, 500, Road.FULL_ROAD, PlayerCars.Stinger);
                break;
            }
            case 3: {
                player = new Player(1f, Road.CENTR, 500, Road.FULL_ROAD, PlayerCars.Z_TYPE);
                break;
            }
            case 4: {
                player = new Player(1f, Road.CENTR, 500, Road.FULL_ROAD, PlayerCars.FURORE);
                break;
            }
            case 5: {
                player = new Player(1f, Road.CENTR, 500, Road.FULL_ROAD, PlayerCars.TANK);
                break;
            }
        }
    }

    private void initLevel() {
        switch (PlayerStats.currentLevel) {
            case DESERT: {
                level = new DessertLevel();
                break;
            }
            case ARCTIC: {
                level = new AntarcticLevel();
                break;
            }
            case JUNGLE: {
                level = new JungleLevel();
                break;
            }
            case CITY: {
                level = new CityLevel();
                break;
            }
            case WORLD: {
                level = new WorldLevel();
                break;
            }
            default: {

            }
        }
    }
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
        BufferedImage image = new BufferedImage(250, 250, BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics g = image.getGraphics();
        g.setColor(java.awt.Color.BLACK);
        g.setFont(font);
        g.drawString("Speed - " + new Integer((int) player.getCurrentSpeed()).toString() + " px", 10, 30);
        g.drawString("Agility - " + new Integer((int) player.getCurrentMobility()).toString() + " px", 10, 60);
        g.drawString("Durability - " + new Integer((int) player.getCurrentDurability()).toString(), 10, 90);
        g.drawString("KM - " + (int) (km * 100) / 100f, 10, 150);
        g.drawString("CASH - " + player.getMoney() + " $", 10, 210);
        Animator.toSlickImage(image).draw(10, 10);
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
                    PlayerStats.LAST_TRIP_SCORE = km;
                    if (km > PlayerStats.HIGHSCORE) {
                        PlayerStats.HIGHSCORE = km;
                    }
                    PlayerStats.MONEY_EARNED = player.getMoney();
                    clankSound = Animator.createClip(clankSound, "src/sounds/CLANK!.wav");
                    clankSound.start();
                    if (Player.SOUND != null) {
                        Player.SOUND.stop();
                    }
                    gameContainer.setForceExit(false);
                    gameContainer.exit();
                }
            } else if (menu.isMouseOnContinue(input.getMouseX(), input.getMouseY())) {
                if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    clankSound = Animator.createClip(clankSound, "src/sounds/CLANK!.wav");
                    clankSound.start();
                    menuActive = false;
                }
            } else if (input.isKeyPressed(Input.KEY_ESCAPE)) {
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


            if (!(player.isImmortal() || player.isJumping() || !player.isBroken())) {
                if (player.checkForCollision(Road.DANGER_ZONE_LEFT)) {
                    player.dangerZone();
                } else if (player.checkForCollision(Road.DANGER_ZONE_RIGHT)) {
                    player.dangerZone();
                }
            }

            player.update(i);

            for (GameObject object : road.getObstacles()) {
                if (player.checkForCollision(object)) {
                    if (!(player.isImmortal() || player.isJumping() || !player.isBroken())) {
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


            for (GameObject car : road.getObstacles()) {
                if (car instanceof Car) {
                    for (GameObject object : road.getObstacles()) {
                        if (car == object) {
                            continue;
                        }
                        if (((Car) car).checkForCollision(object)) {
                            if (!(((Car) car).getSpeed() == 0)) {
                                if (!soundCheck) {
                                    carHitSound = Animator.createClip(carHitSound, "res/sounds/carsHit.wav");
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

            if (input.isKeyPressed(Input.KEY_ESCAPE)) {
                menuActive = true;
            }


        }
    }
}



