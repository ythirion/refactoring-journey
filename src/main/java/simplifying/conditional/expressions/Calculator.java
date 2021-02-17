package simplifying.conditional.expressions;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Calculator {
    public static final String ADD = "add";
    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String SUBTRACT = "subtract";

    private static final HashMap<String, BiFunction<Integer, Integer, Integer>> supportedOperations = new HashMap<>() {{
        put(ADD, Integer::sum);
        put(MULTIPLY, (a, b) -> a * b);
        put(DIVIDE, (a, b) -> a / b);
        put(SUBTRACT, (a, b) -> a - b);
    }};

    public static int calculate(int a,
                                int b,
                                String operator) {
        if (!supportedOperations.containsKey(operator)) {
            throw new IllegalArgumentException("Not supported operator");
        }
        return supportedOperations.get(operator).apply(a, b);
    }
}