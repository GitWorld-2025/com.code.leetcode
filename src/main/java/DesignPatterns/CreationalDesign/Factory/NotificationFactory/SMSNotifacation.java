package DesignPatterns.CreationalDesign.Factory.NotificationFactory;

public class SMSNotifacation implements Notification{
    @Override
    public void send(String msg) {
        System.out.println("SMS Send : " + msg);
    }
}
