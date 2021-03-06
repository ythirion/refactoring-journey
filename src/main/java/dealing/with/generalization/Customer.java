package dealing.with.generalization;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class Customer {
    private final String name;
    private final String email;
    private final String phone;
    private final LocalDate creationDate;
    private final LocalDate conversionDate;
    private final List<String> messages;
}