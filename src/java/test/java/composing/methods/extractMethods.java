package composing.methods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class extractMethods {
    private final ArrayList<Product> products = new ArrayList<>(
            List.of(Product.builder().name("Blu Ray Tenet").price(31.0).build(),
                    Product.builder().name("Book Fundamentals of Software Architecture").price(54.22).build(),
                    Product.builder().name("T-Shirt Geek Kaamelott").price(25.90).build())
    );
    private final Customer customer = Customer.builder().age(35).name("Mando").build();
    private final Order order = Order.builder().products(products).customer(customer).build();

    @Test
    void generateStatement() {
        assertThat(order.generateStatement())
                .isEqualTo("Statement for : Customer{name='Mando', age=35}%n" +
                        "Product: Blu Ray Tenet Price: 31.0%n" +
                        "Product: Book Fundamentals of Software Architecture Price: 54.22%n" +
                        "Product: T-Shirt Geek Kaamelott Price: 25.9%n" +
                        "Total: 111.12€");
    }

    @Test
    void calculatePrice() {
        assertThat(AmountCalculator.calculatePrice(14.5, 16)).isEqualTo(9.425);
        assertThat(AmountCalculator.calculatePrice(14.5, 12)).isEqualTo(9.425);
        assertThat(AmountCalculator.calculatePrice(14.5, 30)).isEqualTo(14.5);
        assertThat(AmountCalculator.calculatePrice(14.5, 60)).isEqualTo(11.6);
        assertThat(AmountCalculator.calculatePrice(14.5, 80)).isEqualTo(11.6);
    }

    @Test
    void calculatePriceForOrders() {
        assertThat(AmountCalculator.calculatePrice(order, true, 16)).isEqualTo(72.22, offset(0.01));
        assertThat(AmountCalculator.calculatePrice(order, false, 16)).isEqualTo(111.12, offset(0.01));
        assertThat(AmountCalculator.calculatePrice(order, true, 40)).isEqualTo(111.12, offset(0.01));
        assertThat(AmountCalculator.calculatePrice(order, true, 70)).isEqualTo(88.89, offset(0.01));
        assertThat(AmountCalculator.calculatePrice(order, false, 70)).isEqualTo(111.12, offset(0.01));
    }
}
