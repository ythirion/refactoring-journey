package simplifying.method.calls;

import java.util.List;

public class Notification {
    private static List<String> authorizedChannels = List.of("SMS", "EMAIL", "PUSH");
    private final String channel;

    public Notification(String channel) {
        if (channel == null
                || channel.isEmpty()
                || !authorizedChannels.contains(channel)) {
            throw new IllegalArgumentException("Invalid channel provided");
        }
        this.channel = channel;
    }
}