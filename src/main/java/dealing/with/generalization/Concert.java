package dealing.with.generalization;

public class Concert extends Event {
    private boolean running;
    private long startTime = 0;
    private long stopTime = 0;
    private int volume = 30;

    private final String description;

    public Concert(String description) {
        this.description = description;
    }

    public void start() {
        if (running) {
            throw new IllegalStateException("Concert is already in progress");
        }
        this.startTime = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        if (running) {
            running = false;
            stopTime = System.currentTimeMillis();
        }
    }

    public long getElapsedTime() {
        return running ? (System.currentTimeMillis() - startTime) : (stopTime - startTime);
    }

    public void volumeUp(int increase) {
        this.volume += increase;
    }

    public void volumeDown(int decrease) {
        this.volume -= decrease;
    }
}