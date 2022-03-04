package simplifying.conditional.expressions

import java.time.LocalDate

class RoomPriceCalculator(
    val today: LocalDate,
    val regularPrice: Double,
    val highSeasonRate: Double,
    val lowSeasonRate: Double,
    val lowSeasonExtraCharge: Double
) {

  private val highSeasonStartDate = LocalDate.of(LocalDate.now.getYear, 6, 30)
  private val highSeasonEndDate = LocalDate.of(LocalDate.now.getYear, 10, 31)

  def calculatePriceFor(
      numberOfRooms: Int,
      selectedDate: LocalDate
  ): Option[Double] = {

    def isLowSeason =
      selectedDate.isBefore(highSeasonStartDate) || selectedDate.isAfter(
        highSeasonEndDate
      )
    def calculatePrice(seasonPrice: Double => Double): Double =
      seasonPrice(numberOfRooms * regularPrice)
    def lowSeasonPrice: Double =
      calculatePrice({ x => x * lowSeasonRate + lowSeasonExtraCharge })
    def highSeasonPrice: Double = calculatePrice({ x => x * highSeasonRate })

    if (selectedDate.isBefore(today) || numberOfRooms <= 0)
      None
    else
      Some(if (isLowSeason) lowSeasonPrice else highSeasonPrice)
  }
}
