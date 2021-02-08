package composing.methods;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class inlineTemps {
    private final Faker faker = new Faker();

    @Test
    public void deserveDiscount() {
        Order orderDeservingDiscount = Order.builder().products(new ArrayList<>(List.of(Product.builder().name("Something expensive").price(1000.01).build()))).build();
        Order orderNotDeservingDiscount = Order.builder().products(new ArrayList<>(List.of(Product.builder().name("Something less expensive").price(1000).build()))).build();

        assertTrue(OrderHelper.deserveDiscount(orderDeservingDiscount));
        assertFalse(OrderHelper.deserveDiscount(orderNotDeservingDiscount));
    }

    @Test
    public void deserveDiscountBasedOnCustomer() {
        Customer customer = Customer.builder().age(47).name("Robert Pires").build();
        Order orderDeservingDiscount = Order.builder().customer(customer).products(generateFakeProducts(12)).build();
        Order orderNotDeservingDiscount = Order.builder().customer(customer).products(generateFakeProducts(9)).build();

        assertTrue(OrderHelper.deserveDiscountBasedOnCustomer(orderDeservingDiscount));
        assertFalse(OrderHelper.deserveDiscountBasedOnCustomer(orderNotDeservingDiscount));
    }

    private ArrayList<Product> generateFakeProducts(int times) {
        return Stream.iterate(0, i -> i + 1)
                .limit(times)
                .map(i -> Product.builder().name(faker.commerce().productName()).build())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}