package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser {
    private List<Message> messages;

    public ChatHistory() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getLastMessage() {
        if (!messages.isEmpty()) {
            return messages.get(messages.size() - 1);
        }
        return null;
    }

    public void removeLastMessage() {
        if (!messages.isEmpty()) {
            messages.remove(messages.size() - 1);
        }
    }
    public List<Message> getMessages() {
        return messages;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Iterator iterator(User userToSearchWith) {
        return new SearchMessagesByUser(messages, userToSearchWith.getName());
    }
}


