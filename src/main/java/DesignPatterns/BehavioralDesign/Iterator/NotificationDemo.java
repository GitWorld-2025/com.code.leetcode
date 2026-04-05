package DesignPatterns.BehavioralDesign.Iterator;

import DesignPatterns.BehavioralDesign.Iterator.Iterators.NotificationCenter;
import DesignPatterns.BehavioralDesign.Iterator.Iterators.NotificationIterator;

public class NotificationDemo {
    public static void main(String[] args) {
        NotificationCenter center = new NotificationCenter();
        center.add(new Notification("Your order shipped", "EMAIL"));
        center.add(new Notification("Flash sale today!", "PUSH"));
        center.add(new Notification("Verify your number", "SMS"));
        center.add(new Notification("Invoice ready", "EMAIL"));
        center.add(new Notification("New login detected", "PUSH"));

        // Mark some as read
        center.getAt(0).markRead();
        center.getAt(2).markRead();

        System.out.println("--- All Notifications ---");
        NotificationIterator all = center.createIterator();
        while (all.hasNext()) {
            System.out.println("  " + all.next());
        }

        System.out.println("\n--- Email Only ---");
        NotificationIterator emails = center.createFilteredIterator("EMAIL");
        while (emails.hasNext()) {
            System.out.println("  " + emails.next());
        }

        System.out.println("\n--- Unread Only ---");
        NotificationIterator unread = center.createUnreadIterator();
        while (unread.hasNext()) {
            System.out.println("  " + unread.next());
        }
    }
}
