package simplifying.conditional.expressions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceCalculator {
    private static final double SALE_DISCOUNT = 0.5;
    private static final double NORMAL_DAY_DISCOUNT = 0.98;
    private final boolean isSaleDay;

    public double calculatePrice(double price) {
        double total = price * (isSaleDay ? SALE_DISCOUNT : NORMAL_DAY_DISCOUNT);
        notifySales(total);
        
        return total;
    }

    private void notifySales(double amount) {

    }
}
