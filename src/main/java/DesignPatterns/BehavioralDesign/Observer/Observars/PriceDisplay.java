package DesignPatterns.BehavioralDesign.Observer.Observars;

import DesignPatterns.BehavioralDesign.Observer.StockExchange;
import DesignPatterns.BehavioralDesign.Observer.StockObserver;

public class PriceDisplay  implements StockObserver {
    @Override
    public void onPriceUpdate(StockExchange exchange) {
        String symbol = exchange.getLastUpdatedSymbol();
        System.out.println("Display -> " + symbol + ": $" + exchange.getPrice(symbol));
    }
}
