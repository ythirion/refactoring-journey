package dealing.with.generalization;

import java.time.LocalDate;
import java.util.List;

public class Customer extends Party {
    private final LocalDate conversionDate;

    public Customer(String name, String email, String phone, LocalDate creationDate, List<String> messages, LocalDate conversionDate) {
        super(name, email, phone, creationDate, messages);
        this.conversionDate = conversionDate;
    }
}