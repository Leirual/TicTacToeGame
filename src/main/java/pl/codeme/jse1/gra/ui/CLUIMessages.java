package pl.codeme.jse1.gra.ui;

import pl.codeme.jse1.gra.engine.Message;
import pl.codeme.jse1.gra.engine.Messages;

public class CLUIMessages implements Messages {

    private Message message;

    @Override
    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
