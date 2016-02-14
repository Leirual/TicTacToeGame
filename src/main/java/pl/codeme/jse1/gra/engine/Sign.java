package pl.codeme.jse1.gra.engine;

public enum Sign {

    SIGN1, SIGN2, EMPTY;

    private char sign;

    Sign() {
        this(' ');
    }

    Sign(char sign) {
        this.sign = sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

}
