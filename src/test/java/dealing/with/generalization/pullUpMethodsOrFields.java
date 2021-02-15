package dealing.with.generalization;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class pullUpMethodsOrFields {
    @Nested
    public class concert_should {
        private Concert concert;

        @BeforeEach
        public void init() {
            concert = new Concert("Therapie Taxi");
        }

        @SneakyThrows
        @Test
        public void retrieve_concert_duration() {
            int concertDuration = 500;

            concert.start();
            Thread.sleep(concertDuration);
            concert.stop();

            assertThat(concert.getElapsedTime()).isGreaterThanOrEqualTo(concertDuration);
        }

        @Nested
        public class throw_an_illegal_state_exception {
            @Test
            public void when_calling_start_on_an_already_started_concert() {
                concert.start();
                assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> concert.start());
            }
        }
    }

    @Nested
    public class theater_piece_should {
        private TheaterPiece piece;

        @BeforeEach
        public void init() {
            piece = new TheaterPiece("L'invitation", 3);
        }

        @SneakyThrows
        @Test
        public void retrieve_piece_duration() {
            int pieceDuration = 500;

            piece.start();
            Thread.sleep(pieceDuration);
            piece.stop();

            assertThat(piece.getElapsedTime()).isGreaterThanOrEqualTo(pieceDuration);
        }

        @Nested
        public class throw_an_illegal_state_exception {
            @Test
            public void when_calling_start_on_an_already_started_piece() {
                piece.start();
                assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> piece.start());
            }
        }
    }
}