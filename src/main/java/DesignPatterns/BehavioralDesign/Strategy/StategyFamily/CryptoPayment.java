package DesignPatterns.BehavioralDesign.Strategy.StategyFamily;

public class CryptoPayment  implements AbstractStrategy{
    private int cryptos;

    public CryptoPayment(int cryptos) {
        this.cryptos = cryptos;
    }

    @Override
    public void pay(double amount) {
        System.out.println("CryptoPayment : " + cryptos + " | amount : " + amount);
    }
}
