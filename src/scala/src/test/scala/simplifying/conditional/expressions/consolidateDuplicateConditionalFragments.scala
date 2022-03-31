package simplifying.conditional.expressions

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class consolidateDuplicateConditionalFragments extends AnyFunSuite {
  test("priceCalculator should return half price on sale day") {
    assert(PriceCalculator.calculatePrice(90.65, isSaleDay = true) === 45.32 +- 0.01)
  }

  test("priceCalculator should return a full price on normal day") {
    assert(PriceCalculator.calculatePrice(90.65, isSaleDay = false) === 88.83 +- 0.01)
  }
}
