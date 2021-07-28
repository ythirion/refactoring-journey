package moving.features;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
public class Player {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final int height;
    private final int weight;
    private final int rating;
    private final int pace;
    private final int shooting;
    private final int passing;
    private final int dribbling;
    private final int defending;
    private final int physicality;

    public boolean canDribble(Player otherPlayer) {
        return physicality + dribbling > otherPlayer.physicality + otherPlayer.defending;
    }
}