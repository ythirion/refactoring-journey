package composing.methods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Builder
public class Order {
    private final Customer customer;
    private final ArrayList<Product> products;

    public String generateStatement() {
        checkState();
        double total = AmountCalculator.calculatePrice(this, true, customer.getAge());

        return createStatement()
                .append(formatProducts() + "\n")
                .append(formatTotal(total))
                .toString();
    }

    private void checkState() {
        if (customer == null || customer.getName().isEmpty() || products.isEmpty()) {
            throw new IllegalArgumentException("InvalidOrder");
        }
    }

    private StringBuilder createStatement() {
        return new StringBuilder("Statement for : " + customer + "\n");
    }

    private String formatProducts() {
        return getProducts()
                .stream()
                .map(product -> "Product: " + product.getName() + " Price: " + product.getPrice())
                .collect(Collectors.joining("\n"));
    }

    private String formatTotal(double total) {
        return "Total: " + total + "€";
    }

    public Double totalPrice() {
        return getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }
}