package DesignPatterns.CreationalDesign.Factory.NotificationCreators;

import DesignPatterns.CreationalDesign.Factory.NotificationFactory.EmailNotification;
import DesignPatterns.CreationalDesign.Factory.NotificationFactory.Notification;

public class EmailNotificationCreator implements NotificationCreator{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
