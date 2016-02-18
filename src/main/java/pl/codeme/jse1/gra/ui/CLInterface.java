package pl.codeme.jse1.gra.ui;

import pl.codeme.jse1.gra.engine.Game;
import pl.codeme.jse1.gra.engine.Message;

public class CLInterface implements UInterface {

    public static Game game;

    public CLInterface() {
        game = Game.getInstance(this);
    }

    public static void main(String[] args) {
        
    }

    @Override
    public Message send(Message message) {
        return null;
    }

}
