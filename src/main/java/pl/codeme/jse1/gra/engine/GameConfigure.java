package pl.codeme.jse1.gra.engine;

import java.util.Properties;

public class GameConfigure extends Properties {

    private static final long serialVersionUID = 6737563525646844377L;

    public GameConfigure() {
        this.setProperty("sign1", "O");
        this.setProperty("sign2", "X");
        this.setProperty("first", "SIGN1");
        this.setProperty("gameBoardWdth", "3");
        this.setProperty("gameBoardHeight", "3");
    }

}
