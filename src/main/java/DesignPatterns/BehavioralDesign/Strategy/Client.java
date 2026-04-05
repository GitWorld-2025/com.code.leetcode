package DesignPatterns.BehavioralDesign.Strategy;

import DesignPatterns.BehavioralDesign.Strategy.StategyFamily.AbstractStrategy;
import DesignPatterns.BehavioralDesign.Strategy.StategyFamily.CreditCardStrategy;
import DesignPatterns.BehavioralDesign.Strategy.StategyFamily.CryptoPayment;
import DesignPatterns.BehavioralDesign.Strategy.StategyFamily.PayPal;

public class Client {
    public static void main(String... args){
        AbstractStrategy credit = new CreditCardStrategy(1234);
        AbstractStrategy payPal = new PayPal("razorPay");
        AbstractStrategy crypto = new CryptoPayment(55555);

        PaymentService payCredit = new PaymentService(credit);
        PaymentService payPaypal = new PaymentService(payPal);
        PaymentService payCrypto = new PaymentService(crypto);

        payCredit.checkout(1000);
        payPaypal.checkout(2000);
        payCrypto.checkout(3000);
    }
}
