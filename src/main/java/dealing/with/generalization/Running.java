package dealing.with.generalization;

public interface Running extends Athlete {
    default void run() {
        System.out.println(getName() + " started running");
    }
}
