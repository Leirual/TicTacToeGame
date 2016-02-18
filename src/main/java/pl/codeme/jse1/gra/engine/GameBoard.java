package pl.codeme.jse1.gra.engine;

import static pl.codeme.jse1.gra.engine.Sign.EMPTY;

import java.util.Map;

public class GameBoard {

    private Map<Coordinate, Sign> gameBoard;
    private int                   height;
    private int                   width;

    public GameBoard(int height, int width) {
        this.height = height;
        this.width = width;
        clear();
    }

    public void clear() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                gameBoard.put(new Coordinate(y, x), EMPTY);
            }
        }
    }

    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int y, int x) {
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
