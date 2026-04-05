package DesignPatterns.BehavioralDesign.Iterator.Iterators;

import DesignPatterns.BehavioralDesign.Iterator.Notification;

public class AllNotificationsIterator implements  NotificationIterator{
    private final NotificationCenter center;
    private int index = 0;

    public AllNotificationsIterator(NotificationCenter center) {
        this.center = center;
    }

    @Override
    public boolean hasNext() {
        return index < center.getSize();
    }

    @Override
    public Notification next() {
        return center.getAt(index++);
    }
}
