package simplifying.method.calls;

import java.util.*;

public class Lottery {
    private static final Random RANDOM = new Random(42);
    private final HashMap<UUID, LotteryTicket> tickets = new HashMap<>();

    public String purchaseTicketForCustomer(UUID id) {
        String ticketNumber = generateTicketNumber();
        tickets.put(id, new LotteryTicket(ticketNumber, id));

        return ticketNumber;
    }

    public LotteryTicket drawWinner() {
        if (tickets.isEmpty()) {
            throw new IllegalStateException("No tickets");
        }

        List<LotteryTicket> randomizedTickets = new ArrayList<>(tickets.values());
        Collections.shuffle(randomizedTickets);

        return randomizedTickets.get(0);
    }

    private String generateTicketNumber() {
        return String.format("%06d", RANDOM.nextInt(1000000));
    }
}