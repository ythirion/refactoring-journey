package dealing.with.generalization;

public abstract class Event {

    protected final String description;
    private boolean running;
    private long startTime = 0;
    private long stopTime = 0;

    protected Event(String description) {
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
}