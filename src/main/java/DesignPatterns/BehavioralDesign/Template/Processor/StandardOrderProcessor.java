package DesignPatterns.BehavioralDesign.Template.Processor;

import DesignPatterns.BehavioralDesign.Template.Order;

public class StandardOrderProcessor extends AbstractOrderProcessor {
    @Override
    protected void validateOrder(Order order) {
        System.out.println("Standard Order validate order : " + order.getId());
    }

    @Override
    protected void calculateTotal(Order order) {
        System.out.println("Standard Order calculate order : " + order.getSubtotal());
    }

    @Override
    protected void processPayment(Order order) {
        System.out.println("Standard Order processPayment order : " + order.getSubtotal());
    }

    @Override
    protected void sendConfirmation(Order order) {
        System.out.println("Standard Order sendConfirmation order : " + order.getId());
    }
}
