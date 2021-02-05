package simplifying.conditional.expressions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class consolidateDuplicateConditionalFragments {
    @Test
    public void priceCalculator_should_return_half_price_on_sale_day() {
        PriceCalculator priceCalculator = new PriceCalculator(true);
        double result = priceCalculator.calculatePrice(90.65);

        Assertions.assertEquals(45.32, result, 0.01);
    }

    @Test
    public void priceCalculator_should_return_a_full_price_on_normal_day() {
        PriceCalculator priceCalculator = new PriceCalculator(false);
        double result = priceCalculator.calculatePrice(90.65);

        Assertions.assertEquals(88.83, result, 0.01);
    }
}