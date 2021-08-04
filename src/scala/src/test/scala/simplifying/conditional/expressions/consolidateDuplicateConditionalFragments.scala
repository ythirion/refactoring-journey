package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class consolidateDuplicateConditionalFragments extends AnyFunSuite {
  test("priceCalculator should return half price on sale day") {
    assert(PriceCalculator(true).calculatePrice(90.65) === 45.32 +- 0.01)
  }

  test("priceCalculator should return a full price on normal day") {
    assert(PriceCalculator(false).calculatePrice(90.65) === 88.83 +- 0.01)
  }
}