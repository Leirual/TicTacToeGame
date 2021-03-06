package pl.codeme.jse1.gra.engine;

import pl.codeme.jse1.gra.engine.GameBoard.Coordinate;
import pl.codeme.jse1.gra.engine.GameBoard.GameState;
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

    private Player[] players;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private GameBoard gameBoard;

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

        gameBoard = new GameBoard(
            Integer.valueOf(config.getProperty("height")), 
            Integer.valueOf(config.getProperty("width"))
        );

        // inicjalizacja wartości znaków z konfiguracji
        Sign.SIGN1.setSign(config.getProperty("sign1"));
        Sign.SIGN2.setSign(config.getProperty("sign2"));

        players = new Player[2];
        currentPlayerIndex = Integer.valueOf(config.getProperty("first")) - 1;
    }

    private int getNextEmptyPlayer() {
        for(int ix = 0; ix < players.length; ix++) {
            if(players[ix] == null) {
                return ix + 1;
            }
        }

        return 0;
    }

    public int getGamBoardWidth() {
        return gameBoard.getWidth();
    }

    public int getGameBoardHeight() {
        return gameBoard.getHeight();
    }

    private void setPlayer(String name) {
        int playerNumber = getNextEmptyPlayer();
        Player player = new Player();
        player.setName(name);
        player.setSign(Sign.getSignByNumber(playerNumber));
        players[playerNumber - 1] = player;
    }

    private void changePlayer() {
        if(currentPlayerIndex < players.length - 1) {
            currentPlayerIndex++;
        } else {
            currentPlayerIndex = 0;
        }
        currentPlayer = players[currentPlayerIndex];
    }

    private AvailableMessage turn(Message message) throws GameFieldNotEmptyException {
        AvailableMessage msg = AvailableMessage.TURN;
        GameState state = gameBoard.set(Coordinate.getCoordenateByText(message.getText()), currentPlayer.getSign());
        System.out.println("Stan gry: " + state);
        switch(state) {
        case PAT:
            msg = AvailableMessage.NEW;
            msg.setText("Remis, aby grać dalej wcisnij enter");
            break;
        case RUN:
            changePlayer();
            msg.setText("Ruch gracza " + currentPlayer.getName() + "( " + currentPlayer.getSign().getSign() + " )");
            msg.setGameBoardMap(gameBoard.getGameBoard());
            break;
        case WIN:
            msg = AvailableMessage.NEW;
            msg.setText("Wygrał gracz " + currentPlayer.getName() + "( " + currentPlayer.getSign().getSign() + " )!!!\n Aby kontynuować wciśnij enter.");
            break;
        }
        msg.setGameBoardMap(gameBoard.getGameBoard());

        return msg;
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

        if(msg.equals(AvailableMessage.ERROR)) {
            msg = (AvailableMessage)msg.getData();
            msg.setText(AvailableMessage.ERROR.getText());
        }

        System.out.println("UI: " + msg);
        try {
            switch(msg) {
            case END:
                System.exit(0);
                break;
            case LOAD:
                break;
            case NEW:
                gameBoard.clear();
                msg = AvailableMessage.TURN;
                msg.setText("Ruch gracza " + currentPlayer.getName() + "( " + currentPlayer.getSign().getSign() + " )");
                msg.setGameBoardMap(gameBoard.getGameBoard());
                break;
            case PLAYER:
                if(msg.getText() != null) {
                    setPlayer(msg.getText());
                }
                int playerNumber = getNextEmptyPlayer();
                if(playerNumber > 0) {
                    msg.setText("Podaj imię gracza " + playerNumber);
                } else {
                    msg = AvailableMessage.TURN;
                    currentPlayer = players[currentPlayerIndex];
                    msg.setText("Ruch gracza " + currentPlayer.getName() + "( " + currentPlayer.getSign().getSign() + " )");
                    msg.setGameBoardMap(gameBoard.getGameBoard());
                }
                break;
            case SAVE:
                break;
            case TURN:
                msg = turn(msg);
                break;
            default:
                break;
            }
        } catch(GameFieldNotEmptyException e) {
            msg = AvailableMessage.ERROR;
            msg.setText(e.getMessage());
            msg.setData(AvailableMessage.TURN);
        }

        uInterface.send(msg);
    }

    public void setInterface(UInterface uInterface) {
        this.uInterface = uInterface;
    }

}
