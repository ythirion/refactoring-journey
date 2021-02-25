package moving.features;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class hideDelegate {
    private final League liga = new League("Spain");
    private final League premierLeague = new League("England");
    private final League ligue1 = new League("France");
    private final League bundesliga = new League("German");
    private final League ligaNos = new League("Portugal");
    private final League serieA = new League("Italy");

    private final ChampionsLeague championsLeague2020 = new ChampionsLeague(List.of(new Team("FC Barcelone", liga),
            new Team("PSG", ligue1),
            new Team("RB Leipzig", bundesliga),
            new Team("FC Liverpool", premierLeague),
            new Team("Seville FC", liga),
            new Team("Borussia Dortmund", bundesliga),
            new Team("FC Porto", ligaNos),
            new Team("Juventus Turin", serieA),
            new Team("Lazio Rome", serieA),
            new Team("Bayern Münich", bundesliga),
            new Team("Atletic de Madrid", liga),
            new Team("Chelsea", premierLeague),
            new Team("Atalanta Bergame", serieA),
            new Team("Real Madrid", liga),
            new Team("Borussia M'Gladbach", bundesliga),
            new Team("Manchester City", premierLeague)));

    @Test
    public void nextStageTable() {
        assertThat(championsLeague2020.nextStageTable())
                .isEqualTo("FC Barcelone - Spain%n" +
                        "PSG - France%n" +
                        "RB Leipzig - German%n" +
                        "FC Liverpool - England%n" +
                        "Seville FC - Spain%n" +
                        "Borussia Dortmund - German%n" +
                        "FC Porto - Portugal%n" +
                        "Juventus Turin - Italy%n" +
                        "Lazio Rome - Italy%n" +
                        "Bayern Münich - German%n" +
                        "Atletic de Madrid - Spain%n" +
                        "Chelsea - England%n" +
                        "Atalanta Bergame - Italy%n" +
                        "Real Madrid - Spain%n" +
                        "Borussia M'Gladbach - German%n" +
                        "Manchester City - England");
    }
}