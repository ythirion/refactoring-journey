package simplifying.conditional.expressions;

import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    public static final String ADD = "add";
    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String SUBTRACT = "subtract";

    private static final Map<String, BiFunction<Integer, Integer, Integer>> supportedOperations = Map.of(
            ADD, Integer::sum,
            MULTIPLY, (a, b) -> a * b,
            DIVIDE, (a, b) -> a / b,
            SUBTRACT, (a, b) -> a - b
    );

    public static int calculate(int a,
                                int b,
                                String operator) {
        if (!supportedOperations.containsKey(operator)) {
            throw new IllegalArgumentException("Not supported operator");
        }
        return supportedOperations.get(operator).apply(a, b);
    }
}