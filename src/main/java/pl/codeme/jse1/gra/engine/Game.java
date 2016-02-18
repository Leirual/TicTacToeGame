package pl.codeme.jse1.gra.engine;

import pl.codeme.jse1.gra.ui.UInterface;

public class Game {

    private static Game gameInstance;

    public static Game getInstance(UInterface uInterface) {
        if(gameInstance == null) {
            gameInstance = new Game(uInterface);
        }

        return gameInstance;
    }

    private GameConfigure config;
    private UInterface uInterface;

    private Game(UInterface uInterface) {
        config = new GameConfigure();
        this.uInterface = uInterface;

        Sign.SIGN1.setSign(config.getProperty("sign1"));
        Sign.SIGN2.setSign(config.getProperty("sign2"));
    }

    public Message send(Message message) {
        return null;
    }

    public void setInterface(UInterface uInterface) {
        this.uInterface = uInterface;
    }
}
