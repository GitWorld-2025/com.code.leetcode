package DesignPatterns.StructuralDesign.Decorator.Component;

import DesignPatterns.StructuralDesign.Decorator.Coffee;

public class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee inner) {
        super(inner);
    }

    @Override
    public double getCost() {
        return inner.getCost() + 1.00;
    }

    @Override
    public String getDescription() {
        return inner.getDescription() + ", whipped cream";
    }
}
