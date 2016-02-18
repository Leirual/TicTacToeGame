package pl.codeme.jse1.gra.engine;

import java.util.Properties;

public class GameConfigure extends Properties {

    private static final long serialVersionUID = -8390417907616390869L;

    public GameConfigure() {
        this.setProperty("width", "3");
        this.setProperty("height", "3");
        this.setProperty("sign1", "O");
        this.setProperty("sign2", "X");
        this.setProperty("first", "sign1");
    }

}
