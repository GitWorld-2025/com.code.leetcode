package DesignPatterns.CreationalDesign.Factory.NotificationCreators;

import DesignPatterns.CreationalDesign.Factory.NotificationFactory.Notification;

public interface NotificationCreator {
    Notification createNotification();
    default void sendMessage(Notification channel, String msg){
        channel.send(msg);
    }
}
