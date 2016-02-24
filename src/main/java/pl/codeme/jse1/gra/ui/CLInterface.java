package pl.codeme.jse1.gra.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import pl.codeme.jse1.gra.engine.Game;
import pl.codeme.jse1.gra.engine.GameBoard.Coordinate;
import pl.codeme.jse1.gra.engine.Message;
import pl.codeme.jse1.gra.engine.Sign;

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

    private String getSign(int y, int x, Map<Coordinate, Sign> gameBoard) {
        Coordinate coord = new Coordinate(y, x);
        Iterator<Coordinate> keys = gameBoard.keySet().iterator();
        while(keys.hasNext()) {
            Coordinate key = keys.next();
            if(key.equals(coord)) {
                return gameBoard.get(key).getSign();
            }
        }
        return gameBoard.get(coord).getSign();
    }

    private void drowGameBoard(Map<Coordinate, Sign> gameBoard) {
        for(int x = 0; x < game.getGamBoardWidth(); x++) {
            if(x == 0) {
                System.out.print("  ");
            }
            System.out.print(x + " ");
        }
        System.out.println();
        for(int y = 0; y < game.getGameBoardHeight(); y++) {
            for(int x = 0; x < game.getGamBoardWidth(); x++) {
                if(x == 0) {
                    System.out.print(y + " ");
                }
                System.out.print(getSign(y, x, gameBoard));
                if(x < game.getGamBoardWidth() - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(y < game.getGameBoardHeight() -1) {
                for(int x = 0; x < game.getGamBoardWidth(); x++) {
                    if(x == 0) {
                        System.out.print("  ");
                    }
                    System.out.print("-");
                    if(x < game.getGamBoardWidth() - 1) {
                        System.out.print("+");
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public void send(Message message) {
        System.out.println("GAME: " + message);
        if(message.getGameBoardMap() != null) {
            drowGameBoard(message.getGameBoardMap());
        }

        String text = askUser(message.getText());
        Message msg = message.getMessageByText(text);
        if(msg == null) {
            msg = message;
        }

        msg.setText(text);
        game.send(msg);
    }

    public void start() {
        System.out.println("Gra w kółko i krzyżyk");
        game.send(null);
    }

}
