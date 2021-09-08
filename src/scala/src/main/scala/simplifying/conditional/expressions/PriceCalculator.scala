package simplifying.conditional.expressions

final case class PriceCalculator(isSaleDay: Boolean) {
  private val SaleDiscount = 0.5
  private val NormalDayDiscount = 0.98
  private val discountRate: Double =
    if (isSaleDay) SaleDiscount else NormalDayDiscount

  def calculatePrice(price: Double): Double = {
    val total = price * discountRate
    notifySales(total)
    total
  }

  private def notifySales(amount: Double): Unit = {
    println(s"Notify sales $amount")
  }
}
