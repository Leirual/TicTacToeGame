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
        // malowanie na płutnie
        Plutno plutno = new Plutno();
        Kwadrat kwadrat = new Kwadrat();
        Trojkat trojkat = new Trojkat();
        plutno.rysuje(kwadrat); // namalowanie kwadratu
        plutno.rysuje(trojkat); // namalowanie trojkąta

        // sprawdzenie przekazania przez wartość
        int liczba = 1;
        int liczba2 = oblicz(liczba);
        System.out.println(liczba + " - " + liczba2);

        WersjaTypeR auto1 = new HondaCivic(); // inicjalizacja zmiennej obiektowej typu Honda
        auto1.typeR(100);
        HondaCivic civic = (HondaCivic)auto1;
        System.out.println(civic.jedzie()); // wywołanie medtody z obiektu
        civic.hamuje();
        civic.zepsuj();

        Ford auto2 = new Ford(1700, 1100);
        auto2.jedzie();
        auto2.hamuje();
        auto2.zepsuj();

        App app = new App();
        Warsztat warsztat = app.new Warsztat(); // inicjalizacja obiektu typu Warsztat z subklasy
        // sprawdzenie przekazania przez referencje
        Auto naprawione1 = warsztat.napraw(civic);
        Auto naprawione2 = warsztat.napraw(auto2);
        System.out.println(civic.czyZepsute() + " - " + naprawione1.czyZepsute());
        System.out.println(auto2.czyZepsute() + " - " + naprawione2.czyZepsute());
    }

    /**
     * Metoda zwiększa wartość parametru o 10
     * 
     * @param liczba Liczba do zwiększenia
     * 
     * @return Zwiekszony parametr o 10
     */
    public static int oblicz(int liczba) {
        return liczba += 10; // zwiększenie liczby o 10
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
        public Auto napraw(Auto auto) {
            auto.naprawiam(); // wywołanie metody z obiektu Auto

            return auto;
        }

    }

}
