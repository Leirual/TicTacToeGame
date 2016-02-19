package pl.codeme.jse1.gra.engine;

import java.util.Properties;

/**
 * Klasa odpowiedzialna za konfigurację gry
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class GameConfigure extends Properties {

    /**
     * Generowane 
     */
    private static final long serialVersionUID = -8390417907616390869L;

    /**
     * Konstruktor klasy
     */
    public GameConfigure() {
        this.setProperty("width", "3");
        this.setProperty("height", "3");
        this.setProperty("sign1", "O");
        this.setProperty("sign2", "X");
        this.setProperty("first", "sign1");
    }

}
