package pl.codeme.jse1.oop;

/**
 * Typ wyliczeniowy miejsc siedzących
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public enum Miejsce {
    MIEJSCE1, MIEJSCE2(true), MIEJSCE3, MIEJSCE4(true); // lista elementów

    /**
     * Czy miejsce jest wolne
     */
    private boolean wolne;

    Miejsce() {
        
    }

    /**
     * Konstruktor elementów z listy
     * 
     * @param wolne Czy wolne miejsce
     */
    Miejsce(boolean wolne) {
        this.wolne = wolne;
    }

    /**
     * Metoda zwraca czy wolne miejsce
     * 
     * @return Czy wolne miejsce
     */
    public boolean czyWolne() {
        return wolne;
    }

    /**
     * Metoda zajmuje miejsce
     * 
     */
    public void zajmij() {
        wolne = false;
    }

}
