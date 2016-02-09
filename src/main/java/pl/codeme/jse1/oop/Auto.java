package pl.codeme.jse1.oop;

/**
 * Klasa reprezentująca auta
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class Auto {

    /**
     * Pole statyczne nazwa producenta auta
     */
    protected static String producent;

    /**
     * Pole reprezentujące pojemność auta w cm3
     */
    private int pojemnosc;

    /**
     * Pole reprezentujące mase auta w kg
     */
    private int masa;

    /**
     * Maksymalna pojemność baku w litrach
     */
    private int maxBak;

    /**
     * Aktualne napełnienie baku
     */
    private int aktBak;

    /**
     * Pole reprezentujące maksymalną prędkość auta
     */
    private int predkosc;

    /**
     * Konstruktor klasy
     * 
     * @param pojemnosc Pojemność auta
     * @param masa Masa auta
     */
    public Auto(int pojemnosc, int masa) {
        Auto.producent = "Producent"; // definicja statycznego pola klasy

        this.pojemnosc = pojemnosc; // podstawienie pola w obiekcie
        this.masa = masa; // podstawienie pola w obiekcie
        maxBak = 70; // podstawienie pola w obiekcie
        this.oblicPredkosc(); // wywołanie metody w obiekcie
    }

    /**
     * Prywatna metoda słuzaca do obliczania prędkości 
     * na podstawie pojemności i masy
     */
    private void oblicPredkosc() {
        predkosc = (int)(((double)pojemnosc / (double)masa) * 100);
    }

    /**
     * Metoda umozliwiająca zatankowanie auta
     * 
     * @param iloscPaliwa Ilość wlewanego paliwa
     */
    public void tankuje(int iloscPaliwa) {
        aktBak += iloscPaliwa;
    }

    /**
     * Przeciażona metoda tankujaca do pełna
     * 
     * @return Ilość zatankowanego paliwa
     */
    public int tankuje() {
        int iloscPaliwa = maxBak - aktBak;
        tankuje(iloscPaliwa); // wywołanie metody przeciazanej tankuj z parametrem

        return iloscPaliwa;
    }

    /**
     * Metoda symulująca jazdę auta
     * 
     * @return Pędkosć auta
     */
    public int jedzie() {
        System.out.println("jadę autem z prędkością " + predkosc);

        return predkosc;
    }

    /**
     * Symulacja hamowania samochodu
     */
    public void hamuje() {
        System.out.println("hamuje autem");
    }

    /**
     * Symulacja naprawy auta
     */
    public void naprawiam() {
        System.out.println("naprawiam auto");
    }

}
