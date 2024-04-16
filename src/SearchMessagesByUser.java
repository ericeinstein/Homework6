package src;
import java.util.Iterator;
import java.util.List;

public class SearchMessagesByUser implements Iterator<Message> {
    private List<Message> messages;
    private String userName;
    private int currentIndex;

    public SearchMessagesByUser(List<Message> messages, String userName) {
        this.messages = messages;
        this.userName = userName;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < messages.size()) {
            Message message = messages.get(currentIndex);
            if (message.getSender().equals(userName) || containsRecipient(message.getRecipients(), userName)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Message next() {
        while (currentIndex < messages.size()) {
            Message message = messages.get(currentIndex);
            if (message.getSender().equals(userName) || containsRecipient(message.getRecipients(), userName)) {
                currentIndex++;
                return message;
            }
            currentIndex++;
        }
        return null;
    }

    private boolean containsRecipient(String[] recipients, String userName) {
        for (String recipient : recipients) {
            if (recipient.equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
