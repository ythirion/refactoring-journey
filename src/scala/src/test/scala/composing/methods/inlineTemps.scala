package org.ythirion.refactoring.journey
package composing.methods

import com.github.javafaker.Faker
import org.scalatest.funsuite.AnyFunSuite

class inlineTemps extends AnyFunSuite {
  private val faker = new Faker
  private val customer = Customer("Robert Pires", 47)

  test("deserve discount") {
    val orderDeservingDiscount = Order(customer, List(Product("Something expensive", 1000.01)))
    val orderNotDeservingDiscount = Order(customer, List(Product("Something less expensive", 1000)))

    assert(OrderHelper.deserveDiscount(orderDeservingDiscount))
    assert(!OrderHelper.deserveDiscount(orderNotDeservingDiscount))
  }

  test("deserveDiscountBasedOnCustomer") {
    val orderDeservingDiscount: Order = Order(customer, generateFakeProducts(12))
    val orderNotDeservingDiscount: Order = Order(customer, generateFakeProducts(9))

    assert(OrderHelper.deserveDiscountBasedOnCustomer(orderDeservingDiscount))
    assert(!OrderHelper.deserveDiscountBasedOnCustomer(orderNotDeservingDiscount))
  }

  private def generateFakeProducts(times: Int): List[Product] = {
    (0 until times).map(_ => Product(faker.commerce().productName(), faker.commerce().price().toDouble)).toList
  }
}