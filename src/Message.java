package src;
import java.time.LocalDateTime;

public class Message {
    private String sender;
    private String[] recipients;
    private LocalDateTime timestamp;
    private String content;

    public Message(String sender, String[] recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = LocalDateTime.now();
        this.content = content;
    }

    // Getters
    public String getSender() {
        return sender;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}

