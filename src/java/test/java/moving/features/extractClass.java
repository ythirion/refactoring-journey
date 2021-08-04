package moving.features;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class extractClass {
    private final Player mane = Player.builder()
            .birthDate(LocalDate.of(1992, 10, 4))
            .firstName("Sadio").lastName("Mané")
            .height(175).weight(69)
            .attributes(Attributes.builder()
                    .defending(79).dribbling(90)
                    .pace(94).passing(80)
                    .physicality(76).rating(90)
                    .shooting(85)
                    .build())
            .build();

    private final Player pogba = Player.builder()
            .birthDate(LocalDate.of(1994, 3, 3))
            .firstName("Paul").lastName("Pogba")
            .height(191).weight(84)
            .attributes(Attributes.builder()
                    .defending(66).dribbling(85)
                    .pace(73).passing(86)
                    .physicality(85).rating(86)
                    .shooting(81)
                    .build())
            .build();

    private final Player vanDijk = Player.builder()
            .birthDate(LocalDate.of(1991, 8, 7))
            .firstName("Virgil").lastName("van Dijk")
            .height(193).weight(92)
            .attributes(Attributes.builder()
                    .defending(91).dribbling(72)
                    .pace(76).passing(71)
                    .physicality(86).rating(90)
                    .shooting(60)
                    .build())
            .build();

    @Test
    void mane_can_dribble_pogba() {
        assertThat(mane.canDribble(pogba)).isTrue();
    }

    @Test
    void pogba_can_dribble_mane() {
        assertThat(pogba.canDribble(mane)).isTrue();
    }

    @Test
    void pogba_cannot_dribble_vanDijk() {
        assertThat(pogba.canDribble(vanDijk)).isFalse();
    }
}