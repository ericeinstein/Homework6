package src;

import java.util.*;

public class ChatServer {
    private Map<String, User> users;
    private Map<String, Set<String>> blockedUsers;

    public ChatServer() {
        this.users = new HashMap<>();
        this.blockedUsers = new HashMap<>();
    }

    public void registerUser(User user) {
        users.put(user.getName(), user);
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
    }

    public void sendMessage(User sender, String[] recipients, String content) {
        Message message = new Message(sender.getName(), recipients, content);
        for (String recipient : recipients) {
            if (!isBlocked(recipient, sender.getName())) {
                User user = users.get(recipient);
                if (user != null) {
                    user.receiveMessage(message);
                } else {
                    System.out.println("User '" + recipient + "' not found.");
                }
            } else {
                System.out.println("Message from " + sender.getName() + " to " + recipient + " blocked.");
            }
        }
    }

    public void blockUser(User blocker, String userName) {
        Set<String> blocked = blockedUsers.computeIfAbsent(blocker.getName(), k -> new HashSet<>());
        blocked.add(userName);
    }

    public boolean isBlocked(String userName, String blockerName) {
        Set<String> blocked = blockedUsers.get(userName);
        return blocked != null && blocked.contains(blockerName);
    }
}


