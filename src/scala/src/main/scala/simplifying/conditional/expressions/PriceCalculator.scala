package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

case class PriceCalculator(isSaleDay: Boolean) {
  private val saleDiscount = 0.5
  private val normalDayDiscount = 0.98

  def calculatePrice(price: Double): Double = {
    def discountRate: Double = if (isSaleDay) saleDiscount else normalDayDiscount

    val total = price * discountRate
    notifySales(total)
    total
  }

  private def notifySales(amount: Double): Unit = {
    println(s"Notify sales $amount")
  }
}