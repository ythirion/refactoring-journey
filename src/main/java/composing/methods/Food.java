package composing.methods;

import java.time.LocalDate;

public class Food {
    private LocalDate expirationDate;
    private Boolean approvedForConsumption;
    private Integer inspectorId;

    public Food(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible() {
        if (this.expirationDate.isAfter(LocalDate.now()) && this.approvedForConsumption == true && this.inspectorId != null) {
            return true;
        } else {
            return false;
        }
    }
}
