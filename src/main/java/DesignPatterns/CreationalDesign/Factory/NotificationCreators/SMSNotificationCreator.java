package DesignPatterns.CreationalDesign.Factory.NotificationCreators;

import DesignPatterns.CreationalDesign.Factory.NotificationFactory.Notification;
import DesignPatterns.CreationalDesign.Factory.NotificationFactory.SMSNotifacation;

public class SMSNotificationCreator implements NotificationCreator{
    @Override
    public Notification createNotification() {
        return new SMSNotifacation();
    }
}
