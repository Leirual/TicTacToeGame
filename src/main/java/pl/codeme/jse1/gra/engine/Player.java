package pl.codeme.jse1.gra.engine;

/**
 * Klasa reprezentująca gracza
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class Player {

    /**
     * Pole przechowujące nazwę gracza
     */
    private String name;

    /**
     * Pole przechowujące znak gracza
     */
    private Sign   sign;

    /**
     * Metoda zwraca nazwę gracza
     * 
     * @return Nazwa gracza
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawienie nazwy gracza
     * 
     * @param name Nazwa gracza
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda zwraca znak gracza
     * 
     * @return Znak gracza
     */
    public Sign getSign() {
        return sign;
    }

    /**
     * Ustawienie znaku gracza
     * 
     * @param sign Znak gracza
     */
    public void setSign(Sign sign) {
        this.sign = sign;
    }

}
