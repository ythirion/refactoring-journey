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
        checkSelectedDate(selectedDate);
        checkNumberOfRooms(numberOfRooms);

        double price = numberOfRooms * this.regularPrice;

        return isLowSeason(selectedDate) ?
                calculateLowSeasonPrice(price) :
                calculateHighSeasonPrice(price);
    }

    private void checkNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms <= 0) {
            throw new IllegalArgumentException("Invalid Number of Rooms");
        }
    }

    private void checkSelectedDate(LocalDate selectedDate) {
        if (!selectedDate.isAfter(today)) {
            throw new IllegalArgumentException("Selected date should be in the future");
        }
    }

    private boolean isLowSeason(LocalDate selectedDate) {
        return selectedDate.isBefore(highSeasonStartDate()) || selectedDate.isAfter(highSeasonEndDate());
    }

    private double calculateLowSeasonPrice(double regularPrice) {
        return regularPrice * lowSeasonRate + lowSeasonExtraCharge;
    }

    private double calculateHighSeasonPrice(double regularPrice) {
        return regularPrice * highSeasonRate;
    }

    private LocalDate highSeasonStartDate() {
        return LocalDate.of(LocalDate.now(clock).getYear(), 6, 30);
    }

    private LocalDate highSeasonEndDate() {
        return LocalDate.of(LocalDate.now(clock).getYear(), 10, 31);
    }
}
