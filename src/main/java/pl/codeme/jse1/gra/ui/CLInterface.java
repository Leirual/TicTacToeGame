package pl.codeme.jse1.gra.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pl.codeme.jse1.gra.engine.Game;
import pl.codeme.jse1.gra.engine.Message;

public class CLInterface implements UInterface {

    public static Game game;

    private BufferedReader reader;

    public CLInterface() {
        game = Game.getInstance(this);
        InputStreamReader isr = new InputStreamReader(System.in);
        reader = new BufferedReader(isr);
    }

    private String askUser(String question) {
        System.out.println(question);
        try {
            return reader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void send(Message message) {
        System.out.println("GAME: " + message);
        
        game.send(message);
    }

    public void start() {
        System.out.println("Gra w kółko i krzyżyk");
        game.send(null);
    }

}
