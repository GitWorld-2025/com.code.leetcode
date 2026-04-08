package DesignPatterns.StructuralDesign.Decorator.Component;

import DesignPatterns.StructuralDesign.Decorator.Coffee;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.00;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}
