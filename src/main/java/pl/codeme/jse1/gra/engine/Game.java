package pl.codeme.jse1.gra.engine;

public class Game {

    private static Game instance;

    private GameConfigure config;
    private GameBoard gameBoard;

    public static Game getInstance() {
        if(Game.instance == null) {
            Game.instance = new Game();
        }

        return Game.instance;
    }

    private Game() {
        config = new GameConfigure();
        gameBoard = new GameBoard(Integer.valueOf(config.getProperty("gameBoardWdth")), Integer.valueOf(config.getProperty("gameBoardHeight")));
    }

    public Message sendMessage(Message message) {
        return null;
    }

}
