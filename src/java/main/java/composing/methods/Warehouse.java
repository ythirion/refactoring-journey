package composing.methods;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;

@AllArgsConstructor
@Getter
public class Warehouse {
    private final int id;
    private final LinkedHashMap<Product, Integer> stock;
    private final StockReportGenerator reportGenerator;

    public String generateStockReport() {
        return reportGenerator.generate(this);
    }

    public double calculateStockValue() {
        return stock
                .entrySet()
                .stream()
                .map(kvp -> kvp.getKey().getPrice() * kvp.getValue())
                .reduce(0.0, Double::sum);
    }
}
