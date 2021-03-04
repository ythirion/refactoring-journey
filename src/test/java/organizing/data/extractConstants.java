package organizing.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class extractConstants {
    @Test
    void validatePassword() {
        String validPassword = "OJ°0I°09121l.";
        assertThatCode(() -> Utils.validatePassword(validPassword)).doesNotThrowAnyException();
    }

    @Test
    void invalidatePassword() {
        String invalidPassword = "Im invalid";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Utils.validatePassword(invalidPassword));
    }

    @Test
    void calculatePotentialEnergy() {
        assertThat(Utils.calculatePotentialEnergy(1, 1)).isEqualTo(9.81);
        assertThat(Utils.calculatePotentialEnergy(98.9897, 160.987)).isEqualTo(156332.7, offset(0.01));
        assertThat(Utils.calculatePotentialEnergy(0, 1)).isEqualTo(0);
        assertThat(Utils.calculatePotentialEnergy(1, 0)).isEqualTo(0);
    }
}
