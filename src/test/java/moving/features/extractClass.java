package moving.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class extractClass {
    private final Player mane = Player.builder()
            .birthDate(LocalDate.of(1992, 10, 4))
            .defending(79).dribbling(90)
            .firstName("Sadio").lastName("Mané")
            .height(175).weight(69)
            .pace(94).passing(80)
            .physicality(76).rating(90)
            .shooting(85)
            .build();

    private final Player pogba = Player.builder()
            .birthDate(LocalDate.of(1994, 3, 3))
            .defending(66).dribbling(85)
            .firstName("Paul").lastName("Pogba")
            .height(191).weight(84)
            .pace(73).passing(86)
            .physicality(85).rating(86)
            .shooting(81)
            .build();

    private final Player vanDijk = Player.builder()
            .birthDate(LocalDate.of(1991, 8, 7))
            .defending(91).dribbling(72)
            .firstName("Virgil").lastName("van Dijk")
            .height(193).weight(92)
            .pace(76).passing(71)
            .physicality(86).rating(90)
            .shooting(60)
            .build();

    @Test
    public void mane_can_dribble_pogba() {
        Assertions.assertTrue(mane.canDribble(pogba));
    }

    @Test
    public void pogba_can_dribble_mane() {
        Assertions.assertTrue(pogba.canDribble(mane));
    }

    @Test
    public void pogba_cannot_dribble_vanDijk() {
        Assertions.assertFalse(pogba.canDribble(vanDijk));
    }
}