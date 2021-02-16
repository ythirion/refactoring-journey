package moving.features;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Team {
    @Getter
    private final String name;
    private final League league;

    public String getCountry() {
        return league.getCountry();
    }
}
