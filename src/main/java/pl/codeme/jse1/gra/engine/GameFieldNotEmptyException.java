package pl.codeme.jse1.gra.engine;

public class GameFieldNotEmptyException extends Exception {

    private static final long serialVersionUID = -1702190104488850809L;

    public GameFieldNotEmptyException() {
        super("Podane koordynaty nie są puste podaj prawidłowe koordynaty!");
    }

}
