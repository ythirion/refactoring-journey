package dealing.with.generalization;

public interface Jumping extends Athlete {
    default void jump() {
        System.out.println(getName() + " is skydiving");
    }
}
