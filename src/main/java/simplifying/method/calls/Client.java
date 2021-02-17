package simplifying.method.calls;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Client {
    private final HashMap<String, Double> orderLines;

    public String toStatement() {
        return orderLines.entrySet().stream()
                .map(entry -> formatLine(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"))
                .concat("\nTotal : " + calculateTotalAmount() + "€");
    }

    private String formatLine(String name, Double value) {
        return name + " for " + value + "€";
    }

    private double calculateTotalAmount() {
        return orderLines.values()
                .stream()
                .mapToDouble(d -> d)
                .sum();
    }
}
