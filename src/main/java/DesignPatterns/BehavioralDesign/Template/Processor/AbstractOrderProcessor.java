package DesignPatterns.BehavioralDesign.Template.Processor;

import DesignPatterns.BehavioralDesign.Template.Order;

public abstract class AbstractOrderProcessor {
    public final void processOrder(Order order) {
        validateOrder(order);
        calculateTotal(order);
        applyDiscount(order);      // Hook
        processPayment(order);
        sendConfirmation(order);    // Hook
        System.out.println("Order processing complete: " + order.getId());
    }

    protected abstract void validateOrder(Order order);

    protected abstract void calculateTotal(Order order);

    protected void applyDiscount(Order order) {
        order.setSubtotal(order.getSubtotal() * 0.9);
        System.out.println("Default Order applyDiscount order : " + order.getSubtotal());
    }

    protected abstract void processPayment(Order order);

    protected void sendConfirmation(Order order) {
        System.out.println("Sent Payment confirmation on Order : " + order.getId());
    }
}
