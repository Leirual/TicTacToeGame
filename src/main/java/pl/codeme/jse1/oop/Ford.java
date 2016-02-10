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
    @Override
    public int jedzie() {
        System.out.println("Jadę Fordem");

        return predkosc;
    }

    @Override
    public void hamuje() {
        System.out.println("Hamuje Fordem");
    }

}
