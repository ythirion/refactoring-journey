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
        return selectedDate.isBefore(HIGH_SEASON_START_DATE) || selectedDate.isAfter(HIGH_SEASON_END_DATE);
    }

    private double calculateLowSeasonPrice(double regularPrice) {
        return regularPrice * lowSeasonRate + lowSeasonExtraCharge;
    }

    private double calculateHighSeasonPrice(double regularPrice) {
        return regularPrice * highSeasonRate;
    }
}
