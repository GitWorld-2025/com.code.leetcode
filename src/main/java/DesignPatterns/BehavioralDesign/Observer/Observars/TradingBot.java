package DesignPatterns.BehavioralDesign.Observer.Observars;
import DesignPatterns.BehavioralDesign.Observer.StockExchange;
import DesignPatterns.BehavioralDesign.Observer.StockObserver;

import java.util.HashMap;
import java.util.Map;
public class TradingBot implements StockObserver {
    private final Map<String, Double> previousPrices = new HashMap<>();

    @Override
    public void onPriceUpdate(StockExchange exchange) {
        String symbol = exchange.getLastUpdatedSymbol();
        double currentPrice = exchange.getPrice(symbol);
        double previousPrice = previousPrices.getOrDefault(symbol, currentPrice);

        if (currentPrice > previousPrice) {
            System.out.println("Bot -> " + symbol + " rising ($" + previousPrice +
                    " -> $" + currentPrice + "). HOLD.");
        } else if (currentPrice < previousPrice) {
            System.out.println("Bot -> " + symbol + " dropping ($" + previousPrice +
                    " -> $" + currentPrice + "). BUY.");
        }

        previousPrices.put(symbol, currentPrice);
    }
}
