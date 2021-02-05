package simplifying.conditional.expressions;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class RoomPriceCalculator {
    private static final LocalDate HIGH_SEASON_START_DATE = LocalDate.of(LocalDate.now().getYear(), 6, 30);
    private static final LocalDate HIGH_SEASON_END_DATE = LocalDate.of(LocalDate.now().getYear(), 10, 31);

    private final LocalDate today;
    private final double regularPrice;
    private final double highSeasonRate;
    private final double lowSeasonRate;
    private final double lowSeasonExtraCharge;

    public double calculatePriceFor(int numberOfRooms,
                                    LocalDate selectedDate) {
        double price;

        if (selectedDate.isAfter(today) && (selectedDate.isBefore(HIGH_SEASON_START_DATE) || selectedDate.isAfter(HIGH_SEASON_END_DATE))) {
            if (numberOfRooms <= 0) {
                throw new IllegalArgumentException("Invalid Number of Rooms");
            }
            price = numberOfRooms * regularPrice * lowSeasonRate + lowSeasonExtraCharge;
        } else if (selectedDate.isAfter(today)) {
            price = numberOfRooms * regularPrice * highSeasonRate;

            if (numberOfRooms <= 0) {
                throw new IllegalArgumentException("Invalid Number of Rooms");
            }
        } else {
            throw new IllegalArgumentException("Selected date should be in the future");
        }
        return price;
    }
}
