package dealing.with.generalization;

public interface Cycling extends Athlete {
    default void cycle() {
        System.out.println(getName() + " started cycling");
    }
}
