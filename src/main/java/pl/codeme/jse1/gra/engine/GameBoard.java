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

    public void set(Coordinate coord, Sign sign) {
        gameBoard.put(findKey(coord), sign);
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
