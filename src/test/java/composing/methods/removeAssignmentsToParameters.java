package composing.methods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class removeAssignmentsToParameters {
    @Test
    public void updateStock() {
        Stock stock = new Stock(5);
        int newStock = OrderHelper.calculateNewStock(stock, 3);

        assertThat(stock.getNbOfItems()).isEqualTo(2);
        assertThat(newStock).isEqualTo(12);
    }
}