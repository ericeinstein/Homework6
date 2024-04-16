package src.test;
import static org.junit.Assert.*;
import org.junit.Test;

import src.ChatHistory;
import src.Message;

public class ChatHistoryTest {
    @Test
    public void testAddMessage() {
        ChatHistory history = new ChatHistory();
        Message message = new Message("Alice", new String[]{"Bob"}, "Hello Bob!");

        history.addMessage(message);

        assertEquals(1, history.getMessages().size());
    }

    @Test
    public void testRemoveLastMessage() {
        ChatHistory history = new ChatHistory();
        Message message1 = new Message("Alice", new String[]{"Bob"}, "Hello Bob!");
        Message message2 = new Message("Bob", new String[]{"Alice"}, "Hi Alice!");

        history.addMessage(message1);
        history.addMessage(message2);

        assertEquals(2, history.getMessages().size());

        history.removeLastMessage();

        assertEquals(1, history.getMessages().size());
        assertEquals("Alice", history.getLastMessage().getSender());
    }
}
