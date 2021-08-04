package composing.methods;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class extractVariables {
    private final Integer IDENTIFIED_INSPECTOR = 1;

    private final Food edible1 = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().plusDays(1)).inspectorId(IDENTIFIED_INSPECTOR).build();
    private final Food edible2 = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().plusDays(20)).inspectorId(IDENTIFIED_INSPECTOR).build();

    private final Food notInspectedFood = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().plusDays(20)).build();
    private final Food notApprovedForConsumptionFood = Food.builder().approvedForConsumption(false).expirationDate(LocalDate.now().plusDays(20)).inspectorId(IDENTIFIED_INSPECTOR).build();
    private final Food expiredFood = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().minusDays(20)).inspectorId(IDENTIFIED_INSPECTOR).build();

    @Test
    void edibleFood() {
        assertThat(edible1.isEdible()).isTrue();
        assertThat(edible2.isEdible()).isTrue();
    }

    @Test
    void notEdibleFood() {
        assertThat(notInspectedFood.isEdible()).isFalse();
        assertThat(notApprovedForConsumptionFood.isEdible()).isFalse();
        assertThat(expiredFood.isEdible()).isFalse();
    }
}
