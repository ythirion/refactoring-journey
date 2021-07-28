package simplifying.method.calls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class removeParameter {
    private Lottery lottery;
    private static final int TICKET_PRICE = 20;
    private static final int PRIZE_AMOUNT = 109_908_786;

    @BeforeEach
    public void init() {
        lottery = new Lottery();
    }

    @Test
    public void lottery_allows_customer_to_purchase_a_ticket() {
        UUID customerId = UUID.randomUUID();
        String customerName = "Mando";
        String ticketNumber = lottery.purchaseTicketForCustomer(customerId, customerName);

        assertThat(ticketNumber.length()).isEqualTo(6);
        assertThat(ticketNumber.matches("\\d+")).isTrue();
    }

    @Test
    public void lottery_throws_an_exception_on_draw_without_tickets() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> lottery.drawWinner(TICKET_PRICE, PRIZE_AMOUNT));
    }

    @Test
    public void lottery_draws_a_winning_ticket() {
        List<String> purchasedTickets = List.of(
                lottery.purchaseTicketForCustomer(UUID.randomUUID(), "Customer 1"),
                lottery.purchaseTicketForCustomer(UUID.randomUUID(), "Customer 2"),
                lottery.purchaseTicketForCustomer(UUID.randomUUID(), "Customer 3"));

        LotteryTicket winningTicket = lottery.drawWinner(TICKET_PRICE, PRIZE_AMOUNT);

        assertThat(winningTicket).isNotNull();
        assertThat(purchasedTickets).contains(winningTicket.getNumber());
    }
}