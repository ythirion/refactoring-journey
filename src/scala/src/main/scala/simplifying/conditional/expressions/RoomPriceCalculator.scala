package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

import java.time.LocalDate

class RoomPriceCalculator(val today: LocalDate,
                          val regularPrice: Double,
                          val highSeasonRate: Double,
                          val lowSeasonRate: Double,
                          val lowSeasonExtraCharge: Double) {

  private val HIGH_SEASON_START_DATE = LocalDate.of(LocalDate.now.getYear, 6, 30)
  private val HIGH_SEASON_END_DATE = LocalDate.of(LocalDate.now.getYear, 10, 31)

  def calculatePriceFor(numberOfRooms: Int,
                        selectedDate: LocalDate): Option[Double] = {
    var price = .0

    if (selectedDate.isAfter(today) && (selectedDate.isBefore(HIGH_SEASON_START_DATE) || selectedDate.isAfter(HIGH_SEASON_END_DATE))) {
      if (numberOfRooms <= 0) return None
      price = numberOfRooms * regularPrice * lowSeasonRate + lowSeasonExtraCharge
    }
    else if (selectedDate.isAfter(today)) {
      price = numberOfRooms * regularPrice * highSeasonRate
      if (numberOfRooms <= 0) return None
    }
    else return None

    Some(price)
  }
}
