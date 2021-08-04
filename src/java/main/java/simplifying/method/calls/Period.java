package simplifying.method.calls;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Period {
    private final LocalDate from;
    private final LocalDate to;
}
