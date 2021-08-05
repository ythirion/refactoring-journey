package org.ythirion.refactoring.journey
package composing.methods

case class Order(customer: Customer, products: List[Product]) {
  def generateStatement: String = {
    checkState()
    val total = AmountCalculator.calculatePrice(this, applyAgeDiscount = true, customer.age)

    createStatement()
      .append(formatProducts()).append("\n")
      .append(formatTotal(total))
      .toString()
  }

  private def checkState(): Unit = {
    if (customer == null || customer.name.isEmpty || products.isEmpty) {
      throw new IllegalArgumentException("InvalidOrder")
    }
  }

  private def createStatement(): StringBuilder = new StringBuilder(s"Statement for : $customer\n")

  private def formatProducts(): String =
    products.map(p => s"Product: ${p.name} Price: ${p.price}")
      .mkString("\n")

  private def formatTotal(total: Double): String = s"Total: ${total}€"

  def totalPrice: Double = {
    products
      .map(p => p.price)
      .sum
  }
}