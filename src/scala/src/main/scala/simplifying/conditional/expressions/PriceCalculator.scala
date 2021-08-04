package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

case class PriceCalculator(isSaleDay: Boolean) {
  def calculatePrice(price: Double): Double = {
    var total = .0
    if (isSaleDay) {
      total = price * 0.5
      notifySales(total)
    } else {
      total = price * 0.98
      notifySales(total)
    }
    total
  }

  private def notifySales(amount: Double): Unit = {
    println("Notify sales")
  }
}