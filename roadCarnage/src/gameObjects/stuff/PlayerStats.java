package gameObjects.stuff;

import gameObjects.stuff.PlayerCars;

public class PlayerStats {
    private PlayerStats() {
    }

    private static int money;
    public static int carChosen;
    public static Levels currentLevel;

    public static double HIGHSCORE;
    public static double LAST_TRIP_SCORE;
    public static int MONEY_EARNED;

    static
    {
        money = 0;
        carChosen = 1;
        currentLevel = Levels.ARCTIC;

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
