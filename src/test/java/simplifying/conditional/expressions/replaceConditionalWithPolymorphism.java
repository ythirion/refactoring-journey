package simplifying.conditional.expressions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class replaceConditionalWithPolymorphism {
    @Test
    public void calculator_should_support_add() {
        int result = Calculator.calculate(1, 2, Calculator.ADD);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculator_should_support_multiply() {
        int result = Calculator.calculate(90, 4, Calculator.MULTIPLY);
        assertThat(result).isEqualTo(360);
    }

    @Test
    public void calculator_should_support_divide() {
        int result = Calculator.calculate(84, 4, Calculator.DIVIDE);
        assertThat(result).isEqualTo(21);
    }

    @Test
    public void calculator_should_support_subtract() {
        int result = Calculator.calculate(84, 23, Calculator.SUBTRACT);
        assertThat(result).isEqualTo(61);
    }

    @Test
    public void calculator_should_throw_exception_on_unsupported_operator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(84, 23, "unsupported exception"));
    }
}