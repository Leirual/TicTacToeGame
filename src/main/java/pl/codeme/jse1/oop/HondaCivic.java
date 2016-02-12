package pl.codeme.jse1.oop;

/**
 * Klasa reprezentująca Honde Civic w wersji sportowej (implementacja interfejsu WersjaTypeR)
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class HondaCivic extends Honda implements WersjaTypeR {

    /**
     * Konstruktor klasy
     */
    public HondaCivic() {
        super(1800, 1000);
    }

    /**
     * Implementacja metody przyśpieszającej z interwejsu WersjaTypeR
     * 
     * @param predkosc O ile zwiekszamy prędkość auta
     */
    public void typeR(int predkosc) {
        this.predkosc += predkosc;
    }

}
