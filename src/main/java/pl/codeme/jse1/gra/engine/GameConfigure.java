package pl.codeme.jse1.gra.engine;

import java.io.IOException;
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
        try {
            this.load(ClassLoader.getSystemResourceAsStream("META-INF/game.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
