package pl.codeme.jse1.gra.engine;

import pl.codeme.jse1.gra.ui.UInterface;

/**
 * Silnik gry
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public class Game {

    /**
     * Pole przechowuje instancję gry (element wzorca singleton)
     */
    private static Game gameInstance;

    /**
     * Metoda zwracająca instancję klasy Game (element wzorca singleton)
     * 
     * @param uInterface Uchwyt do intrfejsu gracza
     * 
     * @return Instancję klasy Game
     */
    public static Game getInstance(UInterface uInterface) {
        if(gameInstance == null) { // jeśli nie ma jeszcze stworzonej instancji klasy Game to ją tworzymy
            gameInstance = new Game(uInterface);
        }

        return gameInstance;
    }

    /**
     * Pole przechowujące konfigurację gry
     */
    private GameConfigure config;

    /**
     * Interfejs łączoncy grę z graczem
     */
    private UInterface uInterface;

    /**
     * Konstruktor klasy
     * 
     * @param uInterface Uchwyt do interfejsu gracza
     */
    private Game(UInterface uInterface) {
        config = new GameConfigure();
        this.uInterface = uInterface;

        // inicjalizacja wartości znaków z konfiguracji
        Sign.SIGN1.setSign(config.getProperty("sign1"));
        Sign.SIGN2.setSign(config.getProperty("sign2"));
    }

    /**
     * Metoda do wysyłania wiadomości do gry
     * 
     * @param message Wiadomość do gry
     * 
     */
    public void send(Message message) {
        AvailableMessage msg;
        if(message == null) {
            msg = AvailableMessage.PLAYER;
        } else {
            msg = (AvailableMessage)message;
        }
        System.out.println("UI: " + msg);
        switch(msg) {
        case END:
            break;
        case ERROR:
            break;
        case LOAD:
            break;
        case NEW:
            break;
        case PLAYER:
            if(msg.getText() != null) {
                
            }
            msg.setText("Podaj imię gracza ");
            break;
        case SAVE:
            break;
        case TURN:
            break;
        default:
            break;
        }

        uInterface.send(msg);
    }

    public void setInterface(UInterface uInterface) {
        this.uInterface = uInterface;
    }

}
