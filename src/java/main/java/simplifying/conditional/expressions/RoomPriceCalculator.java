package simplifying.conditional.expressions;

import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;

@AllArgsConstructor
public class RoomPriceCalculator {
    private final LocalDate today;
    private final double regularPrice;
    private final double highSeasonRate;
    private final double lowSeasonRate;
    private final double lowSeasonExtraCharge;
    private final Clock clock;

    public double calculatePriceFor(int numberOfRooms,
                                    LocalDate selectedDate) {
        double price;

        if (selectedDate.isAfter(today) && (selectedDate.isBefore(highSeasonStartDate()) || selectedDate.isAfter(highSeasonEndDate()))) {
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

    private LocalDate highSeasonStartDate() {
        return LocalDate.of(LocalDate.now(clock).getYear(), 6, 30);
    }

    private LocalDate highSeasonEndDate() {
        return LocalDate.of(LocalDate.now(clock).getYear(), 10, 31);
    }
}
