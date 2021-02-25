package composing.methods;

import lombok.AllArgsConstructor;

import java.util.LinkedHashMap;

@AllArgsConstructor
public class Warehouse {
    private final int id;
    private final LinkedHashMap<Product, Integer> stock;

    public String generateStockReport() {
        StringBuilder report = new StringBuilder();
        report.append("Report for warehouse : " + id + "%n");

        stock.forEach((key, value) -> report.append("Product: " + key.getName() + " Price: " + key.getPrice() + " Stock : " + value + " units%n"));

        report.append("Total: " + stock.entrySet().stream().map(kvp -> kvp.getKey().getPrice() * kvp.getValue()).reduce(0.0, Double::sum) + "€");

        return report.toString();
    }
}
