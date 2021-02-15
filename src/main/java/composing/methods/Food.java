package composing.methods;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
public class Food {
    private final LocalDate expirationDate;
    private final Boolean approvedForConsumption;
    private final Integer inspectorId;

    public boolean isEdible() {
        boolean isFresh = this.expirationDate.isAfter(LocalDate.now());
        boolean hasBeenInspected = this.inspectorId != null;

        return isFresh && approvedForConsumption && hasBeenInspected;
    }
}
