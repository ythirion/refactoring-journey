package dealing.with.generalization;

import java.time.LocalDate;
import java.util.List;

public abstract class Party {
    private final String name;
    private final String email;
    private final String phone;
    private final LocalDate creationDate;
    private final List<String> messages;

    public Party(String name, String email, String phone, LocalDate creationDate, List<String> messages) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.creationDate = creationDate;
        this.messages = messages;
    }
}