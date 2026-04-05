package DesignPatterns.BehavioralDesign.Strategy.StategyFamily;

public class PayPal implements AbstractStrategy{
    private String userName;

    public PayPal(String userName) {
        this.userName = userName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("PayPal userName : " + userName + " | amount : " + amount);
    }
}
