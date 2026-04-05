package DesignPatterns.BehavioralDesign.Strategy.StategyFamily;

public class CreditCardStrategy implements AbstractStrategy {
    private int credtCardLastDigits;

    public CreditCardStrategy(int credtCardLastDigits) {
        this.credtCardLastDigits = credtCardLastDigits;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Credit Card number : " + credtCardLastDigits + " | amount : " + amount);
    }
}
