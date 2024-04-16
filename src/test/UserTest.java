package src.test;


import static org.junit.Assert.*;
import org.junit.Test;

import src.ChatServer;
import src.User;

public class UserTest {

    @Test
    public void testSendMessage() {
        ChatServer server = new ChatServer();
        User user1 = new User("Alice", server);
        User user2 = new User("Bob", server);

        String[] recipients = {"Bob"};
        String content = "Hello Bob!";
        user1.sendMessage(recipients, content);

        assertEquals(0, user2.getHistory().getMessages().size());
    }

    @Test
    public void testUndoLastMessage() {
        ChatServer server = new ChatServer();
        User user1 = new User("Alice", server);

        String[] recipients = {"Bob"};
        String content = "Hello Bob!";
        user1.sendMessage(recipients, content);
        assertEquals(0, user1.getHistory().getMessages().size());

        user1.undoLastMessage();
        assertEquals(0, user1.getHistory().getMessages().size());
    }

    @Test
    public void testBlockUser() {
        ChatServer server = new ChatServer();
        User user2 = new User("Bob", server);

        user2.blockUser("Alice");

        assertTrue(server.isBlocked("Bob", "Alice"));
    }
}
