package moving.features;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class Player {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final int height;
    private final int weight;
    private final Attributes attributes;

    public Player(String firstName, String lastName, LocalDate birthDate, int height, int weight,
                  int rating, int pace, int shooting, int passing, int dribbling, int defending, int physicality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.attributes = new Attributes(rating, pace, shooting, passing, dribbling, defending, physicality);
    }

    public boolean canDribble(Player otherPlayer) {
        return attributes.getPhysicality() + attributes.getDribbling() >
                otherPlayer.attributes.getPhysicality() + otherPlayer.attributes.getDefending();
    }
}