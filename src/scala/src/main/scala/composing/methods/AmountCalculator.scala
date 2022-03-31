package composing.methods

object AmountCalculator {
  private val YoungMaximumAge = 16
  private val YoungDiscount = 0.35
  private val OldMinimumAge = 60
  private val OldDiscount = 0.2

  def calculatePrice(amount: Double, age: Int): Double = {
    calculate(amount, age)
  }

  def calculatePrice(
      order: Order,
      applyAgeDiscount: Boolean,
      age: Int
  ): Double = {
    calculate(order.totalPrice, age, applyAgeDiscount)
  }

  private def calculate(
      amount: Double,
      age: Int,
      applyAgeDiscount: Boolean = true
  ): Double = {
    val discount = if (applyAgeDiscount) calculateDiscountBasedOnAge(amount, age) else 0
    amount - discount
  }

  private def calculateDiscountBasedOnAge(amount: Double, age: Int): Double = {
    age match {
      case young if young <= YoungMaximumAge => YoungDiscount * amount
      case old if old >= OldMinimumAge       => OldDiscount * amount
      case _                                 => 0
    }
  }
}
