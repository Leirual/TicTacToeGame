package pl.codeme.jse1.gra.engine;

public enum Sign {

    SIGN1, SIGN2, EMPTY(" ");

    private String sign;

    Sign() { }

    Sign(String sign) {
        setSign(sign);
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

}
