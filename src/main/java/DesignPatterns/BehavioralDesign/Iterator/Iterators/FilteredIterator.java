package DesignPatterns.BehavioralDesign.Iterator.Iterators;

import DesignPatterns.BehavioralDesign.Iterator.Notification;

public class FilteredIterator  implements  NotificationIterator{
    private final NotificationCenter center;
    private final String type;
    private int index = 0;

    public FilteredIterator(NotificationCenter center, String type) {
        this.center = center;
        this.type = type;
        advanceToNext();
    }

    private void advanceToNext() {
        while (index < center.getSize()
                && !center.getAt(index).getType().equals(type)) {
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
