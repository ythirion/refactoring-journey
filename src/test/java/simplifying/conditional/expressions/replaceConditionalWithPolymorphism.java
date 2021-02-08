package simplifying.conditional.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class replaceConditionalWithPolymorphism {
    @Test
    public void calculator_should_support_add() {
        int result = Calculator.calculate(1, 2, "add");
        assertEquals(3, result);
    }

    @Test
    public void calculator_should_support_multiply() {
        int result = Calculator.calculate(90, 4, "multiply");
        assertEquals(360, result);
    }

    @Test
    public void calculator_should_support_divide() {
        int result = Calculator.calculate(84, 4, "divide");
        assertEquals(21, result);
    }

    @Test
    public void calculator_should_support_subtract() {
        int result = Calculator.calculate(84, 23, "subtract");
        assertEquals(61, result);
    }

    @Test
    public void calculator_should_throw_exception_on_unsupported_operator() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(84, 23, "unsupported exception"));
    }
}