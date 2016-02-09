package pl.codeme.jse1.gra; // nazwa pakietu

import java.util.Scanner; // import klasy używanej w programie

/**
 * Klasa uruchamiająca aplikację
 * 
 * @author pawel.apanasewiczcodeme.pl
 *
 */
public class App { // deklaracja klasy
    /**
     * Tablica literałów cyfr
     */
    static String[] tab = { "zero", "jeden", "dwa", "trzy", "cztery", "pięć", "ala", "siedem" };

    /**
     * Funkcja zamieniająca cyfrę na odpowiadający jej literał
     * 
     * @param liczba Podana cyfra
     * 
     * @return Literał
     */
    static String zamien(int liczba) {
        String tekst;
        if(tab.length - 1 >= liczba) {
            tekst = tab[liczba]; // użycie indeksu tablicy do zamiany cyfry na literał
        } else {
            tekst = "podaj odpowiednia liczbe";
        }

        return tekst;
    }

    /**
     * Metoda uruchamialna
     * 
     * @param args Parametry z linii komend
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // inicjalizacja obiektu komunikującego się z konsolą

        int liczba = 0;
        // nieskończona pętla aplikacji
        do {
            System.out.println("Podaj liczby z przedziału 0 - " + (tab.length - 1));
            String komenda = scanner.nextLine(); // pobranie tekstu z konsoli

            // jeśli podany tekst to end przerywamy działanie pętli
            if(komenda.equals("end")) {
                break;
            }

           liczba = Integer.valueOf(komenda); // konwersja tekstu na liczbę
            System.out.println("ze switch " + zamien(liczba));
        } while(true);

        // pętla for postać do obsługi kolekcji
        for(String item : tab) {
            System.out.println(item);
        }

        scanner.close(); // zamknięcie połączenia z konsolą
    }

}
