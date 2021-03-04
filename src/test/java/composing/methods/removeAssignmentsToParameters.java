package composing.methods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class removeAssignmentsToParameters {
    @Test
    void updateStock() {
        Stock stock = new Stock(5);
        Stock newStock = OrderHelper.calculateNewStock(stock, 3);

        assertThat(stock.getNbOfItems()).isEqualTo(5);
        assertThat(newStock.getNbOfItems()).isEqualTo(12);
    }
}