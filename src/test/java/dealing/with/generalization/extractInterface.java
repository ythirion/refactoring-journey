package dealing.with.generalization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class extractInterface {
    private final ByteArrayOutputStream console = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(console));
    }

    private void assertConsoleOut(String expected) {
        assertThat(console.toString()).isEqualTo(expected + "\n");
    }

    @Nested
    public class TriAthlete_should {
        private final TriAthlete triAthlete = new TriAthlete("Alistair Brownlee");

        @Test
        public void swim() {
            triAthlete.swim();
            assertConsoleOut("Alistair Brownlee started swimming");
        }

        @Test
        public void cycle() {
            triAthlete.cycle();
            assertConsoleOut("Alistair Brownlee started cycling");
        }

        @Test
        public void run() {
            triAthlete.run();
            assertConsoleOut("Alistair Brownlee started running");
        }
    }

    @Nested
    public class JumpyAthlete_should {
        private final JumpyAthlete jumpyAthlete = new JumpyAthlete("A crazy guy");

        @Test
        public void swim() {
            jumpyAthlete.swim();
            assertConsoleOut("A crazy guy started swimming");
        }

        @Test
        public void cycle() {
            jumpyAthlete.cycle();
            assertConsoleOut("A crazy guy started cycling");
        }

        @Test
        public void jump() {
            jumpyAthlete.jump();
            assertConsoleOut("A crazy guy is skydiving");
        }

        @Test
        public void run() {
            jumpyAthlete.run();
            assertConsoleOut("A crazy guy started running");
        }
    }
}
