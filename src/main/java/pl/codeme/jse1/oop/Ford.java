package pl.codeme.jse1.oop;

/**
 * Klasa Reprezentująca Fordy dzidzicząca po klasie Auto
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class Ford extends Auto {

    /**
     * Konstruktor auta
     * 
     * @param pojemnosc Pojemność auta
     * @param masa Masa auta
     */
    public Ford(int pojemnosc, int masa) {
        super(pojemnosc, masa); // wywołanie konstruktora z klasy po której dziedziczymy
    }

    /**
     * Metoda umożliwiająca wyprzedzanie
     */
    public void wyprzedam() {
        System.out.println("Wyprzedzam fordm");
    }

    /**
     * Nadpisana metoda symulujaca jazdę
     */
    public int jedzie() {
        super.jedzie(); // wywołanie medody jedzie z klasy po której dziedziczymy
        System.out.println("Jadę Fordem");

        return 100;
    }
}
