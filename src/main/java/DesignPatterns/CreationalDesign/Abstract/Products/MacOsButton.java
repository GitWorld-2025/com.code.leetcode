package DesignPatterns.CreationalDesign.Abstract.Products;

public class MacOsButton implements Button{
    @Override
    public void render() {
        System.out.println("MacOS Button Rendered");
    }
}
