package simplifying.method.calls;

import lombok.Getter;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Client {
    private final HashMap<String, Double> orderLines;
    @Getter
    private double totalAmount;

    public Client(HashMap<String, Double> orderLines) {
        this.orderLines = orderLines;
    }

    public String toStatement() {
        return orderLines.entrySet().stream()
                .map(entry -> formatLine(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("%n"))
                .concat("%nTotal : " + totalAmount + "€");
    }

    private String formatLine(String name, Double value) {
        totalAmount += value;
        return name + " for " + value + "€";
    }
}
