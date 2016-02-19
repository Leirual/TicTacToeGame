package pl.codeme.jse1.gra.engine;

/**
 * Typ wyliczeniowy przechowujący stany pól planszy
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public enum Sign {

    SIGN1, SIGN2, EMPTY(" "); // trzy stany znak1, znak2 i puste pole

    /**
     * Pole przechowujące wartość znaku
     */
    private String sign;

    /**
     * Konstruktor elementu bez parametru dla SIGN1 i SIGN2
     */
    Sign() { }

    /**
     * Konstruktor (przeciazenie) z parametrem dla EMPTY
     * 
     * @param sign Wartość znaku
     */
    Sign(String sign) {
        setSign(sign); // wywołanie metody ustawiającej pole sign
    }

    /**
     * Metoda ustawia wartość elementu
     * 
     * @param sign Wartość elementu
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Metoda pobiera wartość elementu
     * 
     * @return wartosc (znak) elementu
     */
    public String getSign() {
        return sign;
    }

}
