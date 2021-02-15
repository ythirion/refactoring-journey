package composing.methods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Builder
public class Order {
    private final Customer customer;
    private final ArrayList<Product> products;

    public String generateStatement() {
        if (customer != null && !customer.getName().isEmpty() && products.size() > 0) {
            StringBuilder statement = new StringBuilder();

            appendBanner(statement);
            for (Product p : products) {
                appendProductDetails(statement, p);
            }
            double total = AmountCalculator.calculatePrice(this, true, customer.getAge());

            appendTotal(statement, total);

            return statement.toString();
        } else throw new IllegalArgumentException("InvalidOrder");
    }

    private void appendBanner(StringBuilder statement) {
        statement.append("Statement for : " + customer + "\n");
    }

    private void appendProductDetails(StringBuilder statement, Product p) {
        statement.append("Product: " + p.getName() + " Price: " + p.getPrice() + "\n");
    }

    private void appendTotal(StringBuilder statement, double total) {
        statement.append("Total: " + total + "€");
    }

    public Double totalPrice() {
        return getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }
}