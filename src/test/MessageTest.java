package src.test;

import static org.junit.Assert.*;
import org.junit.Test;

import src.Message;

public class MessageTest {
    @Test
    public void testMessageCreation() {
        String sender = "Alice";
        String[] recipients = {"Bob", "Charlie"};
        String content = "Hello, how are you?";

        Message message = new Message(sender, recipients, content);

        assertEquals(sender, message.getSender());
        assertArrayEquals(recipients, message.getRecipients());
        assertEquals(content, message.getContent());
        assertNotNull(message.getTimestamp());
    }
}


