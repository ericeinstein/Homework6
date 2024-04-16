package src;
import java.util.Iterator;

public class User implements IterableByUser {
    private String name;
    private ChatServer server;
    private ChatHistory history;

    public User(String name, ChatServer server) {
        this.name = name;
        this.server = server;
        this.history = new ChatHistory();
    }

    public void sendMessage(String[] recipients, String content) {
        server.sendMessage(this, recipients, content);
    }

    public void receiveMessage(Message message) {
        history.addMessage(message);
        System.out.println("[" + message.getTimestamp() + "] " + message.getSender() + ": " + message.getContent());
    }
    public void undoLastMessage() {
        Message lastMessage = history.getLastMessage();
        if (lastMessage != null && containsRecipient(lastMessage.getRecipients(), name)) {
            history.removeLastMessage();
            System.out.println("Last message from " + lastMessage.getSender() + " has been undone.");
        } else {
            System.out.println("You can only undo your own messages.");
        }
    }
    
    private boolean containsRecipient(String[] recipients, String userName) {
        for (String recipient : recipients) {
            if (recipient.equals(userName)) {
                return true;
            }
        }
        return false;
    }
    
    public void blockUser(String userName) {
        server.blockUser(this, userName);
    }

    public String getName() {
        return name;
    }

    public ChatHistory getHistory() {
        return history;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Iterator iterator(User userToSearchWith) {
        return history.iterator(userToSearchWith);
    }
}

