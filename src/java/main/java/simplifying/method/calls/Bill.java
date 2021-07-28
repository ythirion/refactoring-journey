package simplifying.method.calls;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Bill {
    private final double amount;
    private final LocalDate invoicedDate;
    private final LocalDate paymentDate;
    private final LocalDate dueDate;
}