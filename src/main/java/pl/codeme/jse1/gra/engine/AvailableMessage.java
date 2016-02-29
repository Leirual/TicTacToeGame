package pl.codeme.jse1.gra.engine;

import java.util.Map;

import pl.codeme.jse1.gra.engine.GameBoard.Coordinate;

public enum AvailableMessage implements Message {
    PLAYER, TURN, NEW, END, SAVE, LOAD, ERROR;

    private String text;
    private Map<Coordinate, Sign> gameBoardMap;
    private Object data;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setGameBoardMap(Map<Coordinate, Sign> gameBoardMap) {
        this.gameBoardMap = gameBoardMap;
    }

    @Override
    public Map<Coordinate, Sign> getGameBoardMap() {
        return gameBoardMap;
    }

    @Override
    public Message getMessageByText(String text) {
        for(AvailableMessage item : AvailableMessage.values()) {
            if(item.toString().equals(text.toUpperCase())) {
                return item;
            }
        }

        return null;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

}
