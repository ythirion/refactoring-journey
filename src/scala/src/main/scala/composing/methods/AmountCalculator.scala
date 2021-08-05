package org.ythirion.refactoring.journey
package composing.methods

object AmountCalculator {
  private val youngDiscount = 0.35
  private val oldDiscount = 0.2

  def calculatePrice(amount: Double,
                     age: Int): Double = {
    calculatePrice(amount, applyAgeDiscount = true, age)
  }

  def calculatePrice(order: Order,
                     applyAgeDiscount: Boolean,
                     age: Int): Double = {
    calculatePrice(order.totalPrice, applyAgeDiscount, age)
  }

  private def calculatePrice(amount: Double,
                             applyAgeDiscount: Boolean = true,
                             age: Int): Double = {
    val discount = if (applyAgeDiscount) calculateDiscountBasedOnAge(amount, age) else 0
    amount - discount
  }

  private def calculateDiscountBasedOnAge(amount: Double,
                                          age: Int): Double = {
    age match {
      case young if young <= 16 => youngDiscount * amount
      case old if old >= 60 => oldDiscount * amount
      case _ => 0
    }
  }
}