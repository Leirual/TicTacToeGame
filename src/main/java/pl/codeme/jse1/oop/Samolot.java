// @formatoff

package pl.codeme.jse1.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca samolot
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public final class Samolot {

    /**
     * Pole opisujące lot samolotu
     */
    public String lot = "Polska Warszawa - Wielka Brytania Londyn";

    /**
     * Metoda wyszukująca wolne miejsca w samolocie
     * 
     * @return Lista wolnych miejsc
     */
    public List<Miejsce> znajdzWolneMiejsce() {
        List<Miejsce> listaWolnychMiejsc = new ArrayList<>(); // deklaracja i definicja List (kolekcji)
        // przekjrzenie i dodanie do listy wszystkich wolnych miejsc
        for(Miejsce miejsce : Miejsce.values()) {
            if(miejsce.czyWolne()) {
                listaWolnychMiejsc.add(miejsce);
            }
        }
        return listaWolnychMiejsc;
    }

    /**
     * Metoda uruchamialna
     * 
     * @param args Parametry linii komend
     */
    public static void main(String[] args) {
        Samolot samolot = new Samolot();
        List<Miejsce> listaWolnychMiejsc = samolot.znajdzWolneMiejsce(); // pobranie wolnych miejsc
        listaWolnychMiejsc.get(1).zajmij(); // zajęcie piejsca z pozycji 2
        System.out.println(samolot.znajdzWolneMiejsce());

        String[] strTab = samolot.lot.split(" "); // zamiana opisu lotu na tablice po " "
        for(String item : strTab) {
            System.out.println(item);
        }

        String slowo = "Londyn";
        int poz = samolot.lot.toLowerCase().indexOf(slowo.toLowerCase()); // wyszukiwanie pozycji slowo
        String zm = samolot.lot.toLowerCase().substring(poz, poz + slowo.length()); // wycięcie slowo
        System.out.println(zm);
    }

}
