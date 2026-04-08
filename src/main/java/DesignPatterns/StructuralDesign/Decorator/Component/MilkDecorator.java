package DesignPatterns.StructuralDesign.Decorator.Component;

import DesignPatterns.StructuralDesign.Decorator.Coffee;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee inner) {
        super(inner);
    }

    @Override
    public double getCost() {
        return inner.getCost() + 0.50;
    }

    @Override
    public String getDescription() {
        return inner.getDescription() + ", milk";
    }
}
