package composing.methods

object AmountCalculator {
  def calculatePrice(amount: Double, age: Int): Double = {
    var discountBasedOnAge = .0
    if (age <= 16) discountBasedOnAge = 0.35 * amount
    else if (age >= 60) discountBasedOnAge = 0.2 * amount

    amount - discountBasedOnAge
  }

  def calculatePrice(
      order: Order,
      applyAgeDiscount: Boolean,
      age: Int
  ): Double = {
    var result = .0
    var discount = .0
    var resultWithDiscount = .0
    for (product <- order.products) {
      result += product.price
    }
    if (applyAgeDiscount) {
      var discountBasedOnAge = 0d

      if (age <= 16) discountBasedOnAge = 0.35 * result
      else if (age >= 60) discountBasedOnAge = 0.2 * result

      discount = discountBasedOnAge
    }
    resultWithDiscount = result - discount
    resultWithDiscount
  }
}
