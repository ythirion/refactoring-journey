package organizing.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class extractConstants {
    @Test
    public void validatePassword() {
        String validPassword = "OJ°0I°09121l.";
        Assertions.assertDoesNotThrow(() -> Wizard.validatePassword(validPassword));
    }

    @Test
    public void invalidatePassword() {
        String invalidPassword = "Im invalid";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Wizard.validatePassword(invalidPassword));
    }

    @Test
    public void calculatePotentialEnergy() {
        Assertions.assertEquals(9.81, Wizard.calculatePotentialEnergy(1, 1));
        Assertions.assertEquals(156332.7, Wizard.calculatePotentialEnergy(98.9897, 160.987), 0.01);
        Assertions.assertEquals(0, Wizard.calculatePotentialEnergy(0, 1));
        Assertions.assertEquals(0, Wizard.calculatePotentialEnergy(1, 0));
    }
}
