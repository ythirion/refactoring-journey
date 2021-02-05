package simplifying.conditional.expressions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceCalculator {
    private final boolean isSaleDay;

    public double calculatePrice(double price) {
        double total;

        if (isSaleDay) {
            total = price * 0.5;
            notifySales(total);
        } else {
            total = price * 0.98;
            notifySales(total);
        }
        return total;
    }

    private void notifySales(double amount) {

    }
}
