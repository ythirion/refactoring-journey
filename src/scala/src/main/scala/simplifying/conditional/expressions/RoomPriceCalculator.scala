package simplifying.conditional.expressions

import java.time.{Clock, LocalDate}

class RoomPriceCalculator(
    regularPrice: Double,
    highSeasonRate: Double,
    lowSeasonRate: Double,
    lowSeasonExtraCharge: Double,
    clock: Clock = Clock.systemDefaultZone()
) {

  private val HighSeasonEndDate = LocalDate.of(LocalDate.now(clock).getYear, 10, 31)
  private val HighSeasonStartDate = LocalDate.of(LocalDate.now(clock).getYear, 6, 30)

  def calculatePriceFor(numberOfRooms: Int, selectedDate: LocalDate): Option[Double] = {
    def isLowSeason = selectedDate.isBefore(HighSeasonStartDate) || selectedDate.isAfter(HighSeasonEndDate)
    def calculatePrice(seasonPrice: Double => Double): Double = seasonPrice(numberOfRooms * regularPrice)
    def lowSeasonPrice: Double = calculatePrice(x => x * lowSeasonRate + lowSeasonExtraCharge)
    def highSeasonPrice: Double = calculatePrice(x => x * highSeasonRate)

    if (selectedDate.isBefore(LocalDate.now(clock)) || numberOfRooms <= 0) None
    else Some(if (isLowSeason) lowSeasonPrice else highSeasonPrice)
  }
}
