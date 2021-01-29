package organizing.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class encapsulateFields {
    @Test
    public void harryPotter() {
        Wizard harryPotter = new Wizard("Harry Potter");
        harryPotter.life = 100;
        harryPotter.magicStick = "Bâton de la Mort";
        harryPotter.weapon = "None";

        Assertions.assertEquals(100, harryPotter.life);
    }
}
