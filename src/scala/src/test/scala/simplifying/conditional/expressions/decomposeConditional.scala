package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.OptionValues.convertOptionToValuable
import org.scalatest.funsuite.AnyFunSuite

import java.time.LocalDate

class decomposeConditional extends AnyFunSuite {
  private val highSeasonRate = 2.86
  private val lowSeasonRate = 0.89
  private val lowSeasonExtraCharge = 50
  private val regularPrice = 156.89

  private val roomPriceCalculator = new RoomPriceCalculator(
    LocalDate.of(2021, 1, 1),
    regularPrice,
    highSeasonRate,
    lowSeasonRate,
    lowSeasonExtraCharge)

  test("roomPriceCalculator should return None when selected date in the past") {
    val pastDate = LocalDate.of(1985, 10, 25)
    assert(roomPriceCalculator.calculatePriceFor(5, pastDate).isEmpty)
  }

  test("roomPriceCalculator should return None when number of rooms is 0 during high season") {
    val highSeasonDate = LocalDate.of(2021, 9, 1)
    assert(roomPriceCalculator.calculatePriceFor(0, highSeasonDate).isEmpty)
  }

  test("roomPriceCalculator should return None when number of rooms is < 0 during high season") {
    val highSeasonDate = LocalDate.of(2021, 9, 1)
    assert(roomPriceCalculator.calculatePriceFor(-1, highSeasonDate).isEmpty)
  }

  test("roomPriceCalculator should return None when number of rooms is 0 during low season") {
    val lowSeasonDate = LocalDate.of(2021, 12, 20)
    assert(roomPriceCalculator.calculatePriceFor(0, lowSeasonDate).isEmpty)
  }

  test("roomPriceCalculator should return None when number of rooms is <0 during low season") {
    val lowSeasonDate = LocalDate.of(2021, 12, 20)
    assert(roomPriceCalculator.calculatePriceFor(-1, lowSeasonDate).isEmpty)
  }

  test("roomPriceCalculator should apply high season price in August") {
    val augustDate = LocalDate.of(2021, 8, 1)
    assertPrice(5, augustDate, 2243.527)
  }

  test("roomPriceCalculator should apply low season price in February") {
    val februaryDate = LocalDate.of(2021, 2, 15)
    assertPrice(2, februaryDate, 329.264)
  }

  private def assertPrice(numberOfRoom: Int, date: LocalDate, expectedValue: Double) = {
    assert(roomPriceCalculator.calculatePriceFor(numberOfRoom, date).value === expectedValue +- 0.001)
  }
}