package moving.features;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class ChampionsLeague {
    private final List<Team> teams;

    public String nextStageTable() {
        return teams.stream()
                .map(team -> team.getName() + " - " + team.getCountry())
                .collect(Collectors.joining("\n"));
    }
}