package DesignPatterns.BehavioralDesign.Iterator.Iterators;

import DesignPatterns.BehavioralDesign.Iterator.Notification;

public class UnreadIterator implements NotificationIterator{
    private final NotificationCenter center;
    private int index = 0;

    public UnreadIterator(NotificationCenter center) {
        this.center = center;
        advanceToNext();
    }

    private void advanceToNext() {
        while (index < center.getSize() && center.getAt(index).isRead()) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < center.getSize();
    }

    @Override
    public Notification next() {
        Notification notification = center.getAt(index);
        index++;
        advanceToNext();
        return notification;
    }
}
