package composing.methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class extractVariables {
    private final Integer IDENTIFIED_INSPECTOR = 1;

    private final Food edible1 = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().plusDays(1)).inspectorId(IDENTIFIED_INSPECTOR).build();
    private final Food edible2 = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().plusDays(20)).inspectorId(IDENTIFIED_INSPECTOR).build();

    private final Food notInspectedFood = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().plusDays(20)).build();
    private final Food notApprovedForConsumptionFood = Food.builder().approvedForConsumption(false).expirationDate(LocalDate.now().plusDays(20)).inspectorId(IDENTIFIED_INSPECTOR).build();
    private final Food expiredFood = Food.builder().approvedForConsumption(true).expirationDate(LocalDate.now().minusDays(20)).inspectorId(IDENTIFIED_INSPECTOR).build();

    @Test
    public void edibleFood() {
        Assertions.assertTrue(edible1.isEdible());
        Assertions.assertTrue(edible2.isEdible());
    }

    @Test
    public void notEdibleFood() {
        Assertions.assertFalse(notInspectedFood.isEdible());
        Assertions.assertFalse(notApprovedForConsumptionFood.isEdible());
        Assertions.assertFalse(expiredFood.isEdible());
    }
}
