package pl.codeme.jse1.gra.engine;

import static pl.codeme.jse1.gra.engine.Sign.EMPTY;

import java.util.Map;

public class GameBoard {

    private Map<Coordinate, Sign> gameBoard;
    private int width, hight;

    public GameBoard(int width, int hight) {
        this.width = width;
        this.hight = hight;

        clearGameBoard();
    }

    public void clearGameBoard() {
        for(int w = 0; w < width; w++) {
            for(int h = 0; h < hight; h++) {
                gameBoard.put(new Coordinate(w, h), EMPTY);
            }
        }
    }

    public static final class Coordinate {

        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

}
