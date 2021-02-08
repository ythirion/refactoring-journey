package composing.methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class removeAssignmentsToParameters {
    @Test
    public void updateStock() {
        Stock stock = new Stock(5);
        int newStock = OrderHelper.calculateNewStock(stock, 3);

        assertEquals(2, stock.getNbOfItems());
        assertEquals(12, newStock);
    }
}