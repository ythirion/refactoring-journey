package simplifying.conditional.expressions

object PriceCalculator {
  private val SaleDiscount = 0.5
  private val NormalDayDiscount = 0.98

  def calculatePrice(price: Double, isSaleDay: Boolean): Double = {
    val total = price * discountRate(isSaleDay)
    notifySales(total)
    total
  }

  private def discountRate(isSaleDay: Boolean): Double =
    if (isSaleDay) SaleDiscount else NormalDayDiscount

  private def notifySales(amount: Double): Unit = {
    println(s"Notify sales $amount")
  }
}
