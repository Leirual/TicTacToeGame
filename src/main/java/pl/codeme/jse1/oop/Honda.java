package pl.codeme.jse1.oop;

/**
 * Klasa Reprezentująca Fordy dzidzicząca po klasie Auto
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class Honda extends Auto {

    /**
     * Konstruktor auta
     * 
     * @param pojemnosc Pojemność auta
     * @param masa Masa auta
     */
    public Honda(int pojemnosc, int masa) {
        super(pojemnosc, masa);
    }

    /**
     * Metoda umożliwiająca wyprzedzanie
     */
    public void wyprzedam() {
        System.out.println("Wyprzedzam hondą");
    }

    /**
     * Nadpisana metoda symulujaca hamowanie
     */
    public void hamuje() {
        System.out.println("Hamuję hondą");
    }
}
