package composing.methods

object AmountCalculator {
  private val YoungDiscount = 0.35
  private val OldDiscount = 0.2

  def calculatePrice(amount: Double, age: Int): Double = {
    calculatePrice(amount, applyAgeDiscount = true, age)
  }

  def calculatePrice(
      order: Order,
      applyAgeDiscount: Boolean,
      age: Int
  ): Double = {
    calculatePrice(order.totalPrice, applyAgeDiscount, age)
  }

  private def calculatePrice(
      amount: Double,
      applyAgeDiscount: Boolean = true,
      age: Int
  ): Double = {
    val discount =
      if (applyAgeDiscount) calculateDiscountBasedOnAge(amount, age) else 0
    amount - discount
  }

  private def calculateDiscountBasedOnAge(amount: Double, age: Int): Double = {
    age match {
      case young if young <= 16 => YoungDiscount * amount
      case old if old >= 60     => OldDiscount * amount
      case _                    => 0
    }
  }
}
