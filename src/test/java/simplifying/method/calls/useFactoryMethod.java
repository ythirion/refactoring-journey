package simplifying.method.calls;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class useFactoryMethod {
    @Nested
    public class notification_should {
        @Nested
        public class throw_an_illegal_argument_exception {
            private void assertExceptionThrown(ThrowableAssert.ThrowingCallable throwingCallable) {
                assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(throwingCallable);
            }

            @Test
            public void when_channel_is_null() {
                assertExceptionThrown(() -> new Notification(null));
            }

            @Test
            public void when_channel_is_empty() {
                assertExceptionThrown(() -> new Notification(""));
            }

            @Test
            public void when_channel_is_not_authorized() {
                assertExceptionThrown(() -> new Notification("Unauthorized"));
            }
        }

        @Nested
        public class instantiate {
            private void assertNotificationNotNull(String channel) {
                Notification notification = new Notification(channel);
                assertThat(notification).isNotNull();
            }

            @Test
            public void when_channel_is_SMS() {
                assertNotificationNotNull("SMS");
            }

            @Test
            public void when_channel_is_EMAIL() {
                assertNotificationNotNull("EMAIL");

            }

            @Test
            public void when_channel_is_PUSH() {
                assertNotificationNotNull("PUSH");
            }
        }
    }
}
