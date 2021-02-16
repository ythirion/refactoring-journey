package moving.features;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Attributes {
    private final int rating;
    private final int pace;
    private final int shooting;
    private final int passing;
    private final int dribbling;
    private final int defending;
    private final int physicality;
}