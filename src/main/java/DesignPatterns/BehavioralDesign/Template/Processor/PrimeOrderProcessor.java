package DesignPatterns.BehavioralDesign.Template.Processor;

import DesignPatterns.BehavioralDesign.Template.Order;

public class PrimeOrderProcessor extends AbstractOrderProcessor{
    @Override
    protected void validateOrder(Order order) {
        System.out.println("Prime Order validate order : " + order.getId());
    }

    @Override
    protected void calculateTotal(Order order) {
        System.out.println("Prime Order calculate order : " + order.getSubtotal());
    }

    @Override
    protected void processPayment(Order order) {
        System.out.println("Prime Order processPayment order : " + order.getSubtotal());
    }

    @Override
    protected void sendConfirmation(Order order) {
        System.out.println("Prime Order sendConfirmation order : " + order.getId());
    }

    @Override
    protected void applyDiscount(Order order) {
        order.setSubtotal(order.getSubtotal() * 0.5);
        System.out.println("Prime Order applyDiscount order : " + order.getSubtotal());
    }
}
