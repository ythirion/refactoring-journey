package simplifying.method.calls;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class LotteryTicket {
    private final String number;
    private final UUID customerId;
}