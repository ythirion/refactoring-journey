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

            //Add banner
            statement.append("Statement for : " + customer + "%n");

            for (Product p : products) {
                // Add details.
                statement.append("Product: " + p.getName() + " Price: " + p.getPrice() + "%n");
            }
            double total = AmountCalculator.calculatePrice(this, true, customer.getAge());
            statement.append("Total: " + total + "€");

            return statement.toString();
        } else throw new IllegalArgumentException("InvalidOrder");
    }

    public Double totalPrice() {
        return getProducts().stream().map(Product::getPrice).reduce(0.0, Double::sum);
    }
}