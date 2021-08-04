package dealing.with.generalization;

public class TheaterPiece extends Event {
    private final int numberOfActors;

    public TheaterPiece(String description, int numberOfActors) {
        super(description);
        this.numberOfActors = numberOfActors;
    }
}