package composing.methods;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Warehouse {
    private final int id;
    private final HashMap<Product, Integer> stock;

    public String generateStockReport() {
        StringBuilder report = new StringBuilder();
        report.append("Report for warehouse : " + id + "\n");

        for (Map.Entry<Product, Integer> line : stock.entrySet()) {
            report.append("Product: " + line.getKey().getName() + " Price: " + line.getKey().getPrice() +
                    " Stock : " + line.getValue() + " units\n");
        }
        report.append("Total: " + stock.entrySet().stream().map(kvp -> kvp.getKey().getPrice() * kvp.getValue()).reduce(0.0, Double::sum) + "€");

        return report.toString();
    }
}
