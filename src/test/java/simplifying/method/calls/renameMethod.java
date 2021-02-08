package simplifying.method.calls;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class renameMethod {
    @Test
    public void john_doe_is_a_model_employee() {
        Employee johnDoe = new Employee("John Doe", "?", "Beach", List.of("Hunter", "Accountant"));

        assertNotNull(johnDoe.get());
        assertEquals("John Doe", johnDoe.getN());
        assertEquals("?", johnDoe.getR());
        assertEquals("Beach", johnDoe.getP());
        assertTrue(johnDoe.isProfessionalService());
        assertTrue(johnDoe.isIdeal());
        assertTrue(johnDoe.hasSomething("Accountant"));
        assertFalse(johnDoe.hasSomething("Football"));
    }
}