package DesignPatterns.StructuralDesign.Decorator;

import DesignPatterns.StructuralDesign.Decorator.Component.MilkDecorator;
import DesignPatterns.StructuralDesign.Decorator.Component.SimpleCoffee;
import DesignPatterns.StructuralDesign.Decorator.Component.SugarDecorator;
import DesignPatterns.StructuralDesign.Decorator.Component.WhippedCreamDecorator;

public class CoffeeShopDemo {
    public static void main(String[] args) {
        // Order 1: Simple coffee
        Coffee order1 = new SimpleCoffee();
        System.out.printf("Order 1: %s | $%.2f%n",
                order1.getDescription(), order1.getCost());

        // Order 2: Coffee with milk and sugar
        Coffee order2 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.printf("Order 2: %s | $%.2f%n",
                order2.getDescription(), order2.getCost());

        // Order 3: Coffee with double milk, sugar, and whipped cream
        Coffee order3 = new WhippedCreamDecorator(
                new SugarDecorator(new MilkDecorator(new MilkDecorator(new SimpleCoffee()))));
        System.out.printf("Order 3: %s | $%.2f%n",
                order3.getDescription(), order3.getCost());
    }
}
