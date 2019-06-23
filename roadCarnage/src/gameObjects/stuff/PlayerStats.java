package gameObjects.stuff;

import gameObjects.stuff.PlayerCars;

public class PlayerStats {
    private PlayerStats() {
    }

    private static int money;
    public static int carChosen;
    public static Levels currentLevel;
    public static boolean ownCar1;
    public static boolean ownCar2;
    public static boolean ownCar3;
    public static boolean ownCar4;
    public static boolean ownCar5;

    public static boolean openLevel1;
    public static boolean openLevel2;
    public static boolean openLevel3;
    public static boolean openLevel4;
    public static boolean openLevel5;

    public static double HIGHSCORE;
    public static double LAST_TRIP_SCORE;
    public static int MONEY_EARNED;

    static
    {
        money = 0;
        carChosen = 1;
        currentLevel = Levels.ARCTIC;

        ownCar1 = true;
        ownCar2 = false;
        ownCar3 = false;
        ownCar4 = false;
        ownCar5 = false;

        openLevel1 = true;
        openLevel2 = false;
        openLevel3 = false;
        openLevel4 = false;
        openLevel5 = false;

        HIGHSCORE = 0;
        LAST_TRIP_SCORE = 0;
        MONEY_EARNED = 0;
    }

    public static void putMoney(int m) {
        money += m;
    }

    public static void spendMoney(int m) {
        money -= m;
    }

    public static int getMoney() {
        return money;
    }
}
