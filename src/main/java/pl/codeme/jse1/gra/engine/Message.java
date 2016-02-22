package pl.codeme.jse1.gra.engine;

import java.util.Map;

import pl.codeme.jse1.gra.engine.GameBoard.Coordinate;

/**
 * Interfejs komunikatów wymienianych między Game i CLInterface
 * 
 * @author pawel.apanasewicz@codeme.pl
 *
 */
public interface Message {

    public void setText(String text);

    public String getText();

    public void setGameBoardMap(Map<Coordinate, Sign> gameBoardMap);

    public Map<Coordinate, Sign> getGameBoardMap();

    public Message getMessageByText(String text);

}
