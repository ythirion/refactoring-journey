package dealing.with.generalization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TriAthlete implements Running, Swimming, Cycling {
    private final String name;

    @Override
    public String getName() {
        return this.name;
    }
}