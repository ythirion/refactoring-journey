package dealing.with.generalization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class extractInterface {
    private final ByteArrayOutputStream console = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(console));
    }

    private void assertConsoleOut(String expected) {
        assertThat(console.toString()).isEqualToIgnoringNewLines(expected);
    }

    @Nested
    class TriAthlete_should {
        private final TriAthlete triAthlete = new TriAthlete("Alistair Brownlee");

        @Test
        void swim() {
            triAthlete.swim();
            assertConsoleOut("Alistair Brownlee started swimming");
        }

        @Test
        void cycle() {
            triAthlete.cycle();
            assertConsoleOut("Alistair Brownlee started cycling");
        }

        @Test
        void run() {
            triAthlete.run();
            assertConsoleOut("Alistair Brownlee started running");
        }
    }

    @Nested
    class JumpyAthlete_should {
        private final JumpyAthlete jumpyAthlete = new JumpyAthlete("A crazy guy");

        @Test
        void swim() {
            jumpyAthlete.swim();
            assertConsoleOut("A crazy guy started swimming");
        }

        @Test
        void cycle() {
            jumpyAthlete.cycle();
            assertConsoleOut("A crazy guy started cycling");
        }

        @Test
        void jump() {
            jumpyAthlete.jump();
            assertConsoleOut("A crazy guy is skydiving");
        }

        @Test
        void run() {
            jumpyAthlete.run();
            assertConsoleOut("A crazy guy started running");
        }
    }
}
