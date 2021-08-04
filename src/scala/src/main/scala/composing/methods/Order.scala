package org.ythirion.refactoring.journey
package composing.methods

case class Order(customer: Customer, products: List[Product]) {
  def generateStatement: String = {
    if (customer != null && customer.name.nonEmpty && products.nonEmpty) {

      val statement = new StringBuilder
      //Add banner
      statement.append(s"Statement for : $customer\n")

      for (p <- products) {
        // Add details.
        statement.append(s"Product: ${p.name} Price: ${p.price}\n")
      }
      val total = AmountCalculator.calculatePrice(this, true, customer.age)
      statement.append("Total: " + total + "€")
      statement.toString
    }
    else throw new IllegalArgumentException("InvalidOrder")
  }

  def totalPrice: Double = {
    products
      .map(p => p.price)
      .sum
  }
}