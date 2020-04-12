package core;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Chat implements Serializable {
    private int chatId;
    private List<Message> chatmsgs;

    public Chat(int chatId) {
        this.chatId = chatId;
        chatmsgs = new LinkedList<>();
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public List<Message> getChatmsgs() {
        return chatmsgs;
    }
}
