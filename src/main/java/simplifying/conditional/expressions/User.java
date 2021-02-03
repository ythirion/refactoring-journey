package simplifying.conditional.expressions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class User {
    private final int age;
    private final boolean isDisabled;
    private final boolean isLoyal;
}