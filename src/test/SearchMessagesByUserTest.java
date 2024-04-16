package src.test;

import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.Test;

import src.ChatHistory;
import src.Message;
import src.SearchMessagesByUser;

public class SearchMessagesByUserTest {
    @Test
    public void testSearchMessagesByUser() {
        ChatHistory history = new ChatHistory();
        Message message1 = new Message("Alice", new String[]{"Bob"}, "Hello Bob!");
        Message message2 = new Message("Bob", new String[]{"Alice"}, "Hi Alice!");

        history.addMessage(message1);
        history.addMessage(message2);

        Iterator<Message> iterator = new SearchMessagesByUser(history.getMessages(), "Alice");
        assertTrue(iterator.hasNext());
        assertEquals("Alice", iterator.next().getSender());
    }
}

