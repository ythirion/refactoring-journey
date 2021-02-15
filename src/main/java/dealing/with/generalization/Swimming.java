package dealing.with.generalization;

public interface Swimming extends Athlete {
    default void swim() {
        System.out.println(getName() + " started swimming");
    }
}