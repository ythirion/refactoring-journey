package simplifying.method.calls;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class useFactoryMethod {
    @Nested
    public class notification_should {
        @Nested
        public class throw_an_illegal_argument_exception {
            @Test
            public void when_channel_is_null() {
                assertThrows(IllegalArgumentException.class, () -> new Notification(null));
            }

            @Test
            public void when_channel_is_empty() {
                assertThrows(IllegalArgumentException.class, () -> new Notification(""));
            }

            @Test
            public void when_channel_is_not_authorized() {
                assertThrows(IllegalArgumentException.class, () -> new Notification("Unauthorized"));
            }
        }

        @Nested
        public class instantiate {
            @Test
            public void when_channel_is_SMS() {
                Notification notification = new Notification("SMS");
                assertNotNull(notification);
            }

            @Test
            public void when_channel_is_EMAIL() {
                Notification notification = new Notification("PUSH");
                assertNotNull(notification);
            }

            @Test
            public void when_channel_is_PUSH() {
                Notification notification = new Notification("PUSH");
                assertNotNull(notification);
            }
        }
    }
}
