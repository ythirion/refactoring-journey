package simplifying.conditional.expressions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class replaceConditionalWithPolymorphism {
    @Test
    public void calculator_should_support_add() {
        int result = Calculator.calculate(1, 2, "add");
        Assertions.assertEquals(3, result);
    }

    @Test
    public void calculator_should_support_multiply() {
        int result = Calculator.calculate(90, 4, "multiply");
        Assertions.assertEquals(360, result);
    }

    @Test
    public void calculator_should_support_divide() {
        int result = Calculator.calculate(84, 4, "divide");
        Assertions.assertEquals(21, result);
    }

    @Test
    public void calculator_should_support_subtract() {
        int result = Calculator.calculate(84, 23, "subtract");
        Assertions.assertEquals(61, result);
    }

    @Test
    public void calculator_should_throw_exception_on_unsupported_operator() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(84, 23, "unsupported exception"));
    }
}