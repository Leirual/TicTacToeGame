package pl.codeme.jse1.oop;

public enum Miejsce {
    MIEJSCE1, MIEJSCE2(true), MIEJSCE3, MIEJSCE4(true);

    private boolean wolne;

    Miejsce() {
        
    }

    Miejsce(boolean wolne) {
        this.wolne = wolne;
    }

    public boolean czyWolne() {
        return wolne;
    }

    public void zajmij() {
        wolne = false;
    }

}
