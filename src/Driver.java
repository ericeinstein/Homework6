package src;

import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        // Create Chat Server
        ChatServer server = new ChatServer();

        // Create Users
        User user1 = new User("Alice", server);
        User user2 = new User("Bob", server);
        User user3 = new User("Charlie", server);

        // Register Users with the Chat Server
        server.registerUser(user1);
        server.registerUser(user2);
        server.registerUser(user3);

        // User1 sends a message to User2 and User3
        user1.sendMessage(new String[]{"Bob"}, "Hello Bob, how are you?");
        user1.sendMessage(new String[]{"Charlie"}, "Hello Charlie, how are you?");

        // User2 blocks messages from User1
        user2.blockUser("Alice");

        // User3 sends two identical messages to User1 (one will be undone)
        user3.sendMessage(new String[]{"Alice"}, "Hey Alice, how's it going?");
        user3.sendMessage(new String[]{"Alice"}, "Hey Alice, how's it going?");
        user1.undoLastMessage();

        // User1 attempts to send a message to User2 (blocked)
        user1.sendMessage(new String[]{"Bob"}, "Bob, Can you hear me?");

        // User1 attempts to send a message to User3
        user1.sendMessage(new String[]{"Charlie"}, "Charlie, Can you hear me?");
        
        // User1 checks their message history with User3 
        System.out.println("Message history with Charlie:");
        @SuppressWarnings("unchecked")
        Iterator<Message> iterator = user1.iterator(user3);
        while (iterator.hasNext()) {
            Message message = iterator.next();
            System.out.println("[" + message.getTimestamp() + "] " + message.getSender() + ": " + message.getContent());
        }
    }
}

