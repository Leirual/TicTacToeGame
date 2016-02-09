package pl.codeme.jse1.oop;

/**
 * Klasa uruchamiająca Program auta
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class App {

    /**
     * Metoda uruchamialna
     * 
     * @param args Parametry z linii komend
     */
    public static void main(String[] args) {
        Honda auto1 = new Honda(1500, 800); // inicjalizacja zmiennej obiektowej typu Honda
        auto1.jedzie(); // wywołanie medtody z obiektu
        auto1.hamuje();

        Ford auto2 = new Ford(1700, 1100);
        auto2.jedzie();
        auto2.hamuje();

        App app = new App();
        Warsztat warsztat = app.new Warsztat(); // inicjalizacja obiektu typu Warsztat z subklasy
        warsztat.napraw(auto1);
        warsztat.napraw(auto2);
    }

    /**
     * Subklasa reprezentująca warsztat
     * 
     * @author pawel.apanasewicz@codeme.pl
     *
     */
    public class Warsztat {

        /**
         * Metoda naprawiająca Auta
         * 
         * @param auto Auto do naprawy
         */
        public void napraw(Auto auto) {
            auto.naprawiam(); // wywołanie metody z obiektu Auto
        }

    }

}
