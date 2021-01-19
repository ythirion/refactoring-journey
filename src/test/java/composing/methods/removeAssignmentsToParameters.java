package composing.methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class removeAssignmentsToParameters {
    @Test
    public void updateStock() {
        Stock stock = new Stock(5);
        int newStock = OrderHelper.calculateNewStock(stock, 3);

        Assertions.assertEquals(2, stock.getNbOfItems());
        Assertions.assertEquals(12, newStock);
    }
}