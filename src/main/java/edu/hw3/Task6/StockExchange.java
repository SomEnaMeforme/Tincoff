package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockExchange implements StockMarket {
    private final Comparator<Stock> priceComparator = (stock1, stock2) -> stock2.price().compareTo(stock1.price());
    private final PriorityQueue<Stock> stocks =
        new PriorityQueue<>(priceComparator);

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
