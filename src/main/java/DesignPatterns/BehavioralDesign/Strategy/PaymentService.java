package DesignPatterns.BehavioralDesign.Strategy;

import DesignPatterns.BehavioralDesign.Strategy.StategyFamily.AbstractStrategy;

public class PaymentService {
    private AbstractStrategy strategy;


    public PaymentService(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount){
        System.out.println(this.strategy.getClass().getName() + "Payment Method is used");
        this.strategy.pay(amount);
    }
}
