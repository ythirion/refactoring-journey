package simplifying.conditional.expressions

import java.time.{Clock, LocalDate}

class RoomPriceCalculator(
    clock: Clock,
    regularPrice: Double,
    highSeasonRate: Double,
    lowSeasonRate: Double,
    lowSeasonExtraCharge: Double
) {

  private val highSeasonEndDate = LocalDate.of(LocalDate.now(clock).getYear, 10, 31)
  private val highSeasonStartDate = LocalDate.of(LocalDate.now(clock).getYear, 6, 30)

  def calculatePriceFor(
      numberOfRooms: Int,
      selectedDate: LocalDate
  ): Option[Double] = {
    var price = .0

    if (
      selectedDate.isAfter(LocalDate.now(clock)) &&
      (selectedDate.isBefore(highSeasonStartDate) ||
      selectedDate.isAfter(highSeasonEndDate))
    ) {
      if (numberOfRooms <= 0) return None
      price =
        numberOfRooms * regularPrice * lowSeasonRate + lowSeasonExtraCharge
    } else if (selectedDate.isAfter(LocalDate.now(clock))) {
      price = numberOfRooms * regularPrice * highSeasonRate
      if (numberOfRooms <= 0) return None
    } else return None

    Some(price)
  }
}
