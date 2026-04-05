package DesignPatterns.BehavioralDesign.Template;

public class Order {

    private String id;
    private double subtotal;

    public Order(String id, double subtotal) {
        this.id = id;
        this.subtotal = subtotal;
    }

    public String getId() {
        return id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setId(String id) {
        this.id = id;
    }

}
