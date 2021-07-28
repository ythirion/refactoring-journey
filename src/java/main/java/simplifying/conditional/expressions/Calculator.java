package simplifying.conditional.expressions;

public class Calculator {
    public static int calculate(int a, int b, String operator) {
        int result;

        if ("add".equals(operator)) {
            result = a + b;
        } else if ("multiply".equals(operator)) {
            result = a * b;
        } else if ("divide".equals(operator)) {
            result = a / b;
        } else if ("subtract".equals(operator)) {
            result = a - b;
        } else {
            throw new IllegalArgumentException("Not supported operator");
        }
        return result;
    }
}