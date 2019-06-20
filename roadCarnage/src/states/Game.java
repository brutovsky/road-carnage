package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame{

    public static final String GAME_NAME = "Road Carnage";
    public static final int GAMEPLAY_STATE = 0;
    public static final float WIDTH = 1000;
    public static final float HEIGHT = 700;

    public Game(String gameName){
        super(gameName);
        addState(new Gameplay(GAMEPLAY_STATE));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.enterState(GAMEPLAY_STATE);
    }
}
