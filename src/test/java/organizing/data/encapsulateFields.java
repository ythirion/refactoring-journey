package organizing.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class encapsulateFields {
    @Test
    public void harryPotter() {
        Wizard harryPotter = new Wizard("Harry Potter", "Bâton de la Mort", "None", 100);
        assertThat(harryPotter.getLife()).isEqualTo(100);
    }
}
