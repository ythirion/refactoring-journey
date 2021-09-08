package simplifying.conditional.expressions

import java.time.LocalDate

class RoomPriceCalculator(
    val today: LocalDate,
    val regularPrice: Double,
    val highSeasonRate: Double,
    val lowSeasonRate: Double,
    val lowSeasonExtraCharge: Double
) {

  private val highSeasonStartDate =
    LocalDate.of(LocalDate.now.getYear, 6, 30)
  private val highSeasonEndDate = LocalDate.of(LocalDate.now.getYear, 10, 31)

  def calculatePriceFor(
      numberOfRooms: Int,
      selectedDate: LocalDate
  ): Option[Double] = {
    var price = .0

    if (
      selectedDate.isAfter(today) && (selectedDate.isBefore(
        highSeasonStartDate
      ) || selectedDate.isAfter(highSeasonEndDate))
    ) {
      if (numberOfRooms <= 0) return None
      price =
        numberOfRooms * regularPrice * lowSeasonRate + lowSeasonExtraCharge
    } else if (selectedDate.isAfter(today)) {
      price = numberOfRooms * regularPrice * highSeasonRate
      if (numberOfRooms <= 0) return None
    } else return None

    Some(price)
  }
}
