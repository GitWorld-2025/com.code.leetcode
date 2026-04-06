package DesignPatterns.BehavioralDesign.Observer;

import DesignPatterns.BehavioralDesign.Observer.Observars.AlertService;
import DesignPatterns.BehavioralDesign.Observer.Observars.PriceDisplay;
import DesignPatterns.BehavioralDesign.Observer.Observars.TradingBot;

public class StockTickerDemo {
    public static void main(String[] args) {
        StockExchange exchange = new StockExchange();

        PriceDisplay display = new PriceDisplay();
        AlertService alerts = new AlertService();
        TradingBot bot = new TradingBot();

        exchange.registerObserver(display);
        exchange.registerObserver(alerts);
        exchange.registerObserver(bot);

        alerts.setAlert("AAPL", 180.0);
        alerts.setAlert("GOOG", 140.0);

        exchange.updatePrice("AAPL", 175.50);
        exchange.updatePrice("GOOG", 138.25);
        exchange.updatePrice("AAPL", 182.00);
        exchange.updatePrice("GOOG", 141.75);
    }
}
