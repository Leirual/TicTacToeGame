package pl.codeme.jse1.gra.engine;

import static pl.codeme.jse1.gra.engine.Sign.EMPTY;

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
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                gameBoard.put(new Coordinate(y, x), EMPTY);
            }
        }
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

    }

}
