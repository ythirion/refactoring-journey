package dealing.with.generalization;

import java.time.LocalDate;
import java.util.List;

public class Prospect extends Party {
    public Prospect(String name, String email, String phone, LocalDate creationDate, List<String> messages) {
        super(name, email, phone, creationDate, messages);
    }
}