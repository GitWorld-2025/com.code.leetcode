package DesignPatterns.BehavioralDesign.Iterator.Iterators;

import DesignPatterns.BehavioralDesign.Iterator.Notification;

public interface NotificationIterator {
    public boolean hasNext();
    public Notification next();
}
