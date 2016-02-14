package pl.codeme.jse1.gra.ui;

import pl.codeme.jse1.gra.engine.Message;

public enum AvailableMessage implements Message {

    END, NEW, TURN, ERROR, SAVE, LOAD, PLAYER;

    private String text;

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
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

}
