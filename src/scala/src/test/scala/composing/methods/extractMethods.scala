package org.ythirion.refactoring.journey
package composing.methods

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class extractMethods extends AnyFunSuite {
  private val products: List[Product] =
    List(new Product("Blu Ray Tenet", 31.0),
      new Product("Book Fundamentals of Software Architecture", 54.22),
      new Product("T-Shirt Geek Kaamelott", 25.90))

  private val customer: Customer = new Customer("Mando", 35)
  private val order: Order = new Order(customer, products)

  test("generate statement") {
    assert(order.generateStatement ==
      """Statement for : Customer{name='Mando', age=35}
        |Product: Blu Ray Tenet Price: 31.0
        |Product: Book Fundamentals of Software Architecture Price: 54.22
        |Product: T-Shirt Geek Kaamelott Price: 25.9
        |Total: 111.12€""".stripMargin)
  }

  test("calculate price") {
    assertPrice(14.5, 16, 9.425)
    assertPrice(14.5, 12, 9.425)
    assertPrice(14.5, 30, 14.5)
    assertPrice(14.5, 60, 11.6)
    assertPrice(14.5, 80, 11.6)
  }

  private def assertPrice(amount: Double, age: Int, expectedResult: Double, applyAgeDiscount: Boolean = false) = {
    assert(AmountCalculator.calculatePrice(amount, age) == expectedResult)
  }

  test("calculatePriceForOrders") {
    assertOrderPrice(applyAgeDiscount = true, 16, 72.23)
    assertOrderPrice(applyAgeDiscount = false, 16, 111.12)
    assertOrderPrice(applyAgeDiscount = true, 40, 111.12)
    assertOrderPrice(applyAgeDiscount = true, 70, 88.90)
    assertOrderPrice(applyAgeDiscount = false, 70, 111.12)
  }

  private def assertOrderPrice(applyAgeDiscount: Boolean, age: Int, expectedResult: Double) = {
    assert(AmountCalculator.calculatePrice(order, applyAgeDiscount, age) === expectedResult +- 0.01)
  }
}