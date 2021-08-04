package simplifying.method.calls;

import java.util.List;

public class Notification {
    private static List<String> authorizedChannels = List.of("SMS", "EMAIL", "PUSH");
    private final String channel;

    private Notification(String channel) {
        this.channel = channel;
    }

    public static Notification createNotification(String channel) {
        if (channel == null
                || channel.isEmpty()
                || !authorizedChannels.contains(channel)) {
            throw new IllegalArgumentException("Invalid channel provided");
        }
        return new Notification(channel);
    }
}