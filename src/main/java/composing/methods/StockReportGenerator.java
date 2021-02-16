package composing.methods;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class StockReportGenerator {
    public String generate(Warehouse warehouse) {
        return createReport(warehouse.getId())
                .append(formatStock(warehouse.getStock()))
                .append("\nTotal: ").append(warehouse.calculateStockValue()).append("€")
                .toString();
    }

    private StringBuilder createReport(int id) {
        return new StringBuilder("Report for warehouse : " + id + "\n");
    }

    private String formatStock(LinkedHashMap<Product, Integer> stock) {
        return stock
                .entrySet()
                .stream()
                .map(entry -> "Product: " + entry.getKey().getName() + " Price: " + entry.getKey().getPrice() + " Stock : " + entry.getValue() + " units")
                .collect(Collectors.joining("\n"));
    }
}