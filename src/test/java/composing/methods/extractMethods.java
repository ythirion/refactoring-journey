package composing.methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class extractMethods {
    private final ArrayList<Product> products = new ArrayList<>(
            List.of(Product.builder().name("Blu Ray Tenet").price(31.0).build(),
                    Product.builder().name("Book Fundamentals of Software Architecture").price(54.22).build(),
                    Product.builder().name("T-Shirt Geek Kaamelott").price(25.90).build())
    );
    private final Customer customer = Customer.builder().age(35).name("Mando").build();
    private final Order order = Order.builder().products(products).customer(customer).build();

    @Test
    public void generateStatement(){
        Assertions.assertEquals("Statement for : Customer{name='Mando', age=35}\n" +
                "Product: Blu Ray Tenet Price: 31.0\n" +
                "Product: Book Fundamentals of Software Architecture Price: 54.22\n" +
                "Product: T-Shirt Geek Kaamelott Price: 25.9\n" +
                "Total: 111.12€", order.generateStatement());
    }

    @Test
    public void calculatePrice(){
        Assertions.assertEquals(9.425, AmountCalculator.calculatePrice(14.5, 16));
        Assertions.assertEquals(9.425, AmountCalculator.calculatePrice(14.5, 12));
        Assertions.assertEquals(14.5, AmountCalculator.calculatePrice(14.5, 30));
        Assertions.assertEquals(11.6, AmountCalculator.calculatePrice(14.5, 60));
        Assertions.assertEquals(11.6, AmountCalculator.calculatePrice(14.5, 80));
    }

    @Test
    public void calculatePriceForOrders(){
        Assertions.assertEquals(72.22, AmountCalculator.calculatePrice(order, true, 16), 0.01);
        Assertions.assertEquals(111.12, AmountCalculator.calculatePrice(order, false, 16), 0.01);
        Assertions.assertEquals(111.12, AmountCalculator.calculatePrice(order, true, 40), 0.01);
        Assertions.assertEquals(88.89, AmountCalculator.calculatePrice(order, true, 70), 0.01);
        Assertions.assertEquals(111.12, AmountCalculator.calculatePrice(order, false, 70), 0.01);
    }
}
