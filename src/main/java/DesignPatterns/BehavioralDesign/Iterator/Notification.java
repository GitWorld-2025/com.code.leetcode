package DesignPatterns.BehavioralDesign.Iterator;

public class Notification {
    private final String message;
    private final String type; // "EMAIL", "SMS", "PUSH"
    private boolean read;

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;
        this.read = false;
    }

    public String getMessage() { return message; }
    public String getType() { return type; }
    public boolean isRead() { return read; }
    public void markRead() { this.read = true; }

    @Override
    public String toString() {
        return "[" + type + "] " + message + (read ? " (read)" : " (unread)");
    }
}
