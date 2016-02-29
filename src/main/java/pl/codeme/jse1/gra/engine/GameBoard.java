package pl.codeme.jse1.gra.engine;

import static pl.codeme.jse1.gra.engine.Sign.EMPTY;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Klasa reprezentująca planszę gry
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class GameBoard {

    public enum GameState { WIN, PAT, RUN }

    /**
     * Mapa przechowująca stan gry (ustawione znaki na polach)
     */
    private Map<Coordinate, Sign> gameBoard;

    /**
     * Wysokość planszy (x)
     */
    private int                   height;

    /**
     * Szerokość planszy (y)
     */
    private int                   width;

    /**
     * Konstruktor klasy
     * 
     * @param height Wysokość planszy
     * @param width Szerokość planszy
     */
    public GameBoard(int height, int width) {
        this.height = height;
        this.width = width;
        clear();
    }

    /**
     * Metoda czyszcząca planszę
     */
    public void clear() {
        if(gameBoard == null) {
            gameBoard = new HashMap<>();
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    gameBoard.put(new Coordinate(y, x), EMPTY);
                }
            }
        } else {
            Iterator<Coordinate> keys = gameBoard.keySet().iterator();
            while(keys.hasNext()) {
                gameBoard.put(keys.next(), EMPTY);
            }
        }
    }

    public Map<Coordinate, Sign> getGameBoard() {
        return gameBoard;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Coordinate findKey(Coordinate coord) {
        Iterator<Coordinate> keys = gameBoard.keySet().iterator();
        while(keys.hasNext()) {
            Coordinate key = keys.next();
            if(key.equals(coord)) {
                return key;
            }
        }

        return null;
    }

    private boolean hasEmpty() {
        Iterator<Coordinate> keys = gameBoard.keySet().iterator();
        while(keys.hasNext()) {
            if(gameBoard.get(keys.next()).equals(EMPTY)) {
                return true;
            }
        }

        return false;
    }

    private GameState check() {
        GameState state = GameState.RUN;

        if(!hasEmpty()) {
            state = GameState.PAT;
        }

        if(
            (
                // poziomo
                (
                    !gameBoard.get(findKey(new Coordinate(0, 0))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(0, 0))).equals(gameBoard.get(findKey(new Coordinate(0, 1)))) &&
                    gameBoard.get(findKey(new Coordinate(0, 0))).equals(gameBoard.get(findKey(new Coordinate(0, 2)))) 
                ) || (
                    !gameBoard.get(findKey(new Coordinate(1, 0))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(1, 0))).equals(gameBoard.get(findKey(new Coordinate(1, 1)))) &&
                    gameBoard.get(findKey(new Coordinate(1, 0))).equals(gameBoard.get(findKey(new Coordinate(1, 2))))
                ) || (
                    !gameBoard.get(findKey(new Coordinate(2, 0))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(2, 0))).equals(gameBoard.get(findKey(new Coordinate(2, 1)))) &&
                    gameBoard.get(findKey(new Coordinate(2, 0))).equals(gameBoard.get(findKey(new Coordinate(2, 2))))
                )
            ) || (
                // pionowo
                (
                    !gameBoard.get(findKey(new Coordinate(0, 0))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(0, 0))).equals(gameBoard.get(findKey(new Coordinate(1, 0)))) &&
                    gameBoard.get(findKey(new Coordinate(0, 0))).equals(gameBoard.get(findKey(new Coordinate(2, 0)))) 
                ) || (
                    !gameBoard.get(findKey(new Coordinate(0, 1))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(0, 1))).equals(gameBoard.get(findKey(new Coordinate(1, 1)))) &&
                    gameBoard.get(findKey(new Coordinate(0, 1))).equals(gameBoard.get(findKey(new Coordinate(2, 1))))
                ) || (
                    !gameBoard.get(findKey(new Coordinate(0, 2))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(0, 2))).equals(gameBoard.get(findKey(new Coordinate(1, 2)))) &&
                    gameBoard.get(findKey(new Coordinate(0, 2))).equals(gameBoard.get(findKey(new Coordinate(2, 2))))
                )
            ) || (
                // ukos
                (
                    !gameBoard.get(findKey(new Coordinate(0, 0))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(0, 0))).equals(gameBoard.get(findKey(new Coordinate(1, 1)))) &&
                    gameBoard.get(findKey(new Coordinate(0, 0))).equals(gameBoard.get(findKey(new Coordinate(2, 2))))
                ) || (
                    !gameBoard.get(findKey(new Coordinate(0, 2))).equals(EMPTY) && 
                    gameBoard.get(findKey(new Coordinate(0, 2))).equals(gameBoard.get(findKey(new Coordinate(1, 1)))) &&
                    gameBoard.get(findKey(new Coordinate(0, 2))).equals(gameBoard.get(findKey(new Coordinate(2, 0))))
                )
            )
        ) {
            state = GameState.WIN;
        }

        return state;
    }

    public GameState set(Coordinate coord, Sign sign) throws GameFieldNotEmptyException {
        Coordinate key = findKey(coord);
        if(!gameBoard.get(key).equals(EMPTY)) {
            throw new GameFieldNotEmptyException();
        }
        gameBoard.put(key, sign);

        return check();
    }

    /**
     * Klasa wewnętrzna przechowująca koordynaty znaku na planszy
     * 
     * @author pawel.apanasewicz@codeme.pl
     *
     */
    public static class Coordinate {

        /**
         * Wartość x
         */
        private int x;

        /**
         * Wartość y
         */
        private int y;

        /**
         * Konstruktor klasy
         * 
         * @param y Wartość y
         * @param x Wartość x
         */
        public Coordinate(int y, int x) {
            this.x = x;
            this.y = y;
        }

        /**
         * Metoda zwraca wartość x
         * 
         * @return Wartość x
         */
        public int getX() {
            return x;
        }

        /**
         * Metoda zwraca wartość y
         * 
         * @return Wartość y
         */
        public int getY() {
            return y;
        }

        public boolean equals(Object object) {
            if(object instanceof Coordinate) {
                Coordinate coord = (Coordinate)object;
                if(coord.getX() == x && coord.getY() == y) {
                    return true;
                }
            }

            return false;
        }

        public static Coordinate getCoordenateByText(String text) {
            String[] textTab = text.split(",");

            return new Coordinate(Integer.valueOf(textTab[0]), Integer.valueOf(textTab[1]));
        }

    }

}
