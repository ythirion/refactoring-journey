package simplifying.conditional.expressions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class consolidateDuplicateConditionalFragments {
    @Test
    void priceCalculator_should_return_half_price_on_sale_day() {
        PriceCalculator priceCalculator = new PriceCalculator(true);
        double result = priceCalculator.calculatePrice(90.65);

        assertThat(result).isEqualTo(45.32, offset(0.01));
    }

    @Test
    void priceCalculator_should_return_a_full_price_on_normal_day() {
        PriceCalculator priceCalculator = new PriceCalculator(false);
        double result = priceCalculator.calculatePrice(90.65);

        assertThat(result).isEqualTo(88.83, offset(0.01));
    }
}