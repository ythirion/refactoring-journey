package dealing.with.generalization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JumpyAthlete implements Running, Swimming, Cycling, Jumping {
    private final String name;

    @Override
    public String getName() {
        return this.name;
    }
}