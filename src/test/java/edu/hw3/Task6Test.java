package edu.hw3;

import org.junit.jupiter.api.Test;
import edu.hw3.Task6.StockExchange;
import edu.hw3.Task6.Stock;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    private StockExchange preprocessing() {
        var stock1 = new Stock(5);
        var stock2 = new Stock(11);
        var stock3 = new Stock(7);
        var exchange = new StockExchange();
        exchange.add(stock1);
        exchange.add(stock2);
        exchange.add(stock3);
        return exchange;
    }
    @Test
    public void isMethodMostValuableStockWorkCorrectTest() {
        var exchange = preprocessing();
        assertThat(exchange.mostValuableStock().price()).isEqualTo(11);
    }
    @Test
    public void isMethodAddWorkCorrectTest2() {
        var exchange = preprocessing();
        var stock4 = new Stock(21);
        exchange.add(stock4);
        assertThat(exchange.mostValuableStock().price()).isEqualTo(21);
    }
    @Test
    public void isMethodRemoveWorkCorrectTest2() {
        var exchange = preprocessing();
        var stock4 = new Stock(21);
        exchange.add(stock4);
        exchange.remove(stock4);
        assertThat(exchange.mostValuableStock().price()).isEqualTo(11);
    }
}
