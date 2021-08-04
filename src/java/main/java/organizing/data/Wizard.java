package organizing.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Wizard {
    private final String name;
    private final String magicStick;
    private final String weapon;
    private final int life;
}