package dealing.with.generalization;

public class Concert extends Event {
    private int volume = 30;

    public Concert(String description) {
        super(description);
    }

    public void volumeUp(int increase) {
        this.volume += increase;
    }

    public void volumeDown(int decrease) {
        this.volume -= decrease;
    }
}