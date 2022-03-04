package simplifying.method.calls;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class renameMethod {
    @Test
    void john_doe_is_a_model_employee() {
        Employee johnDoe = new Employee("John Doe", "?", "Beach", List.of("Hunter", "Accountant"));

        assertThat(johnDoe.getId()).isNotNull();
        assertThat(johnDoe.getName()).isEqualTo("John Doe");
        assertThat(johnDoe.getRole()).isEqualTo("?");
        assertThat(johnDoe.getCurrentProject()).isEqualTo("Beach");
        assertThat(johnDoe.isProfessionalService()).isTrue();
        assertThat(johnDoe.isIdeal()).isTrue();
        assertThat(johnDoe.hasSomething("Accountant")).isTrue();
        assertThat(johnDoe.hasSomething("Football")).isFalse();
    }
}