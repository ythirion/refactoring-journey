package organizing.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class extractConstants {
    @Test
    public void validatePassword() {
        String validPassword = "OJ°0I°09121l.";
        assertDoesNotThrow(() -> Utils.validatePassword(validPassword));
    }

    @Test
    public void invalidatePassword() {
        String invalidPassword = "Im invalid";
        assertThrows(IllegalArgumentException.class, () -> Utils.validatePassword(invalidPassword));
    }

    @Test
    public void calculatePotentialEnergy() {
        assertEquals(9.81, Utils.calculatePotentialEnergy(1, 1));
        assertEquals(156332.7, Utils.calculatePotentialEnergy(98.9897, 160.987), 0.01);
        assertEquals(0, Utils.calculatePotentialEnergy(0, 1));
        assertEquals(0, Utils.calculatePotentialEnergy(1, 0));
    }
}
