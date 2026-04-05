package DesignPatterns.CreationalDesign.Factory.NotificationFactory;

public class EmailNotification implements Notification{
    @Override
    public void send(String msg) {
        System.out.println("Email Send : " + msg);
    }
}
