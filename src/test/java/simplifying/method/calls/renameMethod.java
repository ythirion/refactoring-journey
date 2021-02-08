package simplifying.method.calls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class renameMethod {
    @Test
    public void john_doe_is_a_model_employee() {
        Employee johnDoe = new Employee("John Doe", "?", "Beach", List.of("Hunter", "Accountant"));

        Assertions.assertNotNull(johnDoe.get());
        Assertions.assertEquals("John Doe", johnDoe.getN());
        Assertions.assertEquals("?", johnDoe.getR());
        Assertions.assertEquals("Beach", johnDoe.getP());
        Assertions.assertTrue(johnDoe.isProfessionalService());
        Assertions.assertTrue(johnDoe.isIdeal());
        Assertions.assertTrue(johnDoe.hasSomething("Accountant"));
        Assertions.assertFalse(johnDoe.hasSomething("Football"));
    }
}