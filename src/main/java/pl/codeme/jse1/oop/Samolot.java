// @formatoff

package pl.codeme.jse1.oop;

import java.util.ArrayList;
import java.util.List;

//import static pl.codeme.jse1.oop.Miejsce.MIEJSCE1;

public final class Samolot {

    public String lot = "Polska Warszawa - Wielka Brytania Londyn";

    public List<Miejsce> znajdzWolneMiejsce() {
        List<Miejsce> listaWolnychMiejsc = new ArrayList<>();
        for(Miejsce miejsce : Miejsce.values()) {
            if(miejsce.czyWolne()) {
                listaWolnychMiejsc.add(miejsce);
            }
        }
        return listaWolnychMiejsc;
    }

    public static void main(String[] args) {
        Samolot samolot = new Samolot();
        List<Miejsce> listaWolnychMiejsc = samolot.znajdzWolneMiejsce();
        listaWolnychMiejsc.get(1).zajmij();
        System.out.println(samolot.znajdzWolneMiejsce());

        String[] strTab = samolot.lot.split(" ");
        for(String item : strTab) {
            System.out.println(item);
        }

        String slowo = "Londyn";
        int poz = samolot.lot.toLowerCase().indexOf(slowo.toLowerCase());
        String zm = samolot.lot.toLowerCase().substring(poz, poz + slowo.length());
        System.out.println(zm);
    }

}
