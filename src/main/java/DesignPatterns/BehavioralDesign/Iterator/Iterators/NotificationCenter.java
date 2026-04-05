package DesignPatterns.BehavioralDesign.Iterator.Iterators;

import DesignPatterns.BehavioralDesign.Iterator.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter {
    private final List<Notification> notifications = new ArrayList<>();

    public void add(Notification notification) {
        notifications.add(notification);
    }

    public Notification getAt(int index) {
        return notifications.get(index);
    }

    public int getSize() {
        return notifications.size();
    }

    public NotificationIterator createIterator() {
        return new AllNotificationsIterator(this);
    }

    public NotificationIterator createFilteredIterator(String type) {
        return new FilteredIterator(this, type);
    }

    public NotificationIterator createUnreadIterator() {
        return new UnreadIterator(this);
    }
}
