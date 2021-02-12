package simplifying.method.calls;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class renameMethod {
    @Test
    public void john_doe_is_a_model_employee() {
        Employee johnDoe = new Employee("John Doe", "?", "Beach", List.of("Hunter", "Accountant"));

        assertThat(johnDoe.get()).isNotNull();
        assertThat(johnDoe.getN()).isEqualTo("John Doe");
        assertThat(johnDoe.getR()).isEqualTo("?");
        assertThat(johnDoe.getP()).isEqualTo("Beach");
        assertThat(johnDoe.isProfessionalService()).isTrue();
        assertThat(johnDoe.isIdeal()).isTrue();
        assertThat(johnDoe.hasSomething("Accountant")).isTrue();
        assertThat(johnDoe.hasSomething("Football")).isFalse();
    }
}