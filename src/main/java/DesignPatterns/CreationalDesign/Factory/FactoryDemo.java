package DesignPatterns.CreationalDesign.Factory;

import DesignPatterns.CreationalDesign.Factory.NotificationCreators.EmailNotificationCreator;
import DesignPatterns.CreationalDesign.Factory.NotificationCreators.NotificationCreator;
import DesignPatterns.CreationalDesign.Factory.NotificationCreators.SMSNotificationCreator;
import DesignPatterns.CreationalDesign.Factory.NotificationFactory.Notification;
import DesignPatterns.CreationalDesign.Factory.NotificationFactory.SMSNotifacation;

public class FactoryDemo {
    public static void main(String... args){
        NotificationCreator emailCreator = new EmailNotificationCreator();
        Notification emailCHannel = emailCreator.createNotification();
        emailCHannel.send("Msg With Email");

        NotificationCreator smsCreator = new SMSNotificationCreator();
        Notification smsChannel = smsCreator.createNotification();
        smsChannel.send("Msg With SMS");
    }
}
