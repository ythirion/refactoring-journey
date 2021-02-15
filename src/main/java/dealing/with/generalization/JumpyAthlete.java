package dealing.with.generalization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JumpyAthlete {
    private final String name;

    public void swim() {
        System.out.println(name + " started swimming");
    }

    public void cycle() {
        System.out.println(name + " started cycling");
    }

    public void run() {
        System.out.println(name + " started running");
    }

    public void jump() {
        System.out.println(name + " is skydiving");
    }
}
