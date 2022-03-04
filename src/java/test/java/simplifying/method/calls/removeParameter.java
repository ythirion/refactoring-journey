package simplifying.method.calls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class removeParameter {
    private Lottery lottery;

    @BeforeEach
    void init() {
        lottery = new Lottery();
    }

    @Test
    void lottery_allows_customer_to_purchase_a_ticket() {
        UUID customerId = UUID.randomUUID();
        String ticketNumber = lottery.purchaseTicketForCustomer(customerId);

        assertThat(ticketNumber.length()).isEqualTo(6);
        assertThat(ticketNumber.matches("\\d+")).isTrue();
    }

    @Test
    void lottery_throws_an_exception_on_draw_without_tickets() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> lottery.drawWinner());
    }

    @Test
    void lottery_draws_a_winning_ticket() {
        List<String> purchasedTickets = List.of(
                lottery.purchaseTicketForCustomer(UUID.randomUUID()),
                lottery.purchaseTicketForCustomer(UUID.randomUUID()),
                lottery.purchaseTicketForCustomer(UUID.randomUUID()));

        LotteryTicket winningTicket = lottery.drawWinner();

        assertThat(winningTicket).isNotNull();
        assertThat(purchasedTickets).contains(winningTicket.getNumber());
    }
}