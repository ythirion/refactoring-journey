package organizing.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class encapsulateFields {
    @Test
    public void harryPotter() {
        Wizard harryPotter = new Wizard("Harry Potter");
        harryPotter.life = 100;
        harryPotter.magicStick = "Bâton de la Mort";
        harryPotter.weapon = "None";

        assertEquals(100, harryPotter.life);
    }
}
