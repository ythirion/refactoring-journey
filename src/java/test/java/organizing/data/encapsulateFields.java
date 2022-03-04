package organizing.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class encapsulateFields {
    @Test
    void harryPotter() {
        Wizard harryPotter = new Wizard("Harry Potter");
        harryPotter.life = 100;
        harryPotter.magicStick = "Bâton de la Mort";
        harryPotter.weapon = "None";

        assertThat(harryPotter.life).isEqualTo(100);
    }
}
