package DesignPatterns.BehavioralDesign.Template;

import DesignPatterns.BehavioralDesign.Template.Processor.AbstractOrderProcessor;
import DesignPatterns.BehavioralDesign.Template.Processor.StandardOrderProcessor;

public class OrderClient {
    public static void main(String... args){
        Order orderStd = new Order("1", 1000);
        Order orderPrime = new Order("2", 10000);

        AbstractOrderProcessor standardProcessor = new StandardOrderProcessor();
        AbstractOrderProcessor primeProcessor = new StandardOrderProcessor();

        standardProcessor.processOrder(orderStd);
        primeProcessor.processOrder(orderStd);
    }
}
