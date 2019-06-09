package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame{

    public static final String GAME_NAME = "Road Carnage";
    public static final int GAMEPLAY_STATE = 0;

    public static void main(String[] args) {
        Game game = new Game(GAME_NAME);
        AppGameContainer app = null;
        try {
            app = new AppGameContainer(game);
            app.setDisplayMode(1000,700,false);
            app.setTargetFrameRate(60);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Game(String gameName){
        super(gameName);
        addState(new Gameplay(GAMEPLAY_STATE));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        getState(0).init(gameContainer,this);
    }
}
