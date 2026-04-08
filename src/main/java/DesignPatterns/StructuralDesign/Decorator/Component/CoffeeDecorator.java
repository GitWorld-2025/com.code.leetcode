package DesignPatterns.StructuralDesign.Decorator.Component;

import DesignPatterns.StructuralDesign.Decorator.Coffee;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee inner;

    public CoffeeDecorator(Coffee inner) {
        this.inner = inner;
    }
}
