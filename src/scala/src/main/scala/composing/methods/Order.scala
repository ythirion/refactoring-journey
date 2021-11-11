package composing.methods

import scala.util.Properties.lineSeparator
import scala.util.{Failure, Success, Try}

final case class Order(customer: Customer, products: List[Product]) {
  def generateStatement: Try[String] = {
    if (customer.name.nonEmpty && products.nonEmpty) {
      //Add banner
      val statement: String = s"Statement for : $customer$lineSeparator"
      // Add details
      val statementWithProduct: String =
        products.foldLeft(statement)((acc, p) =>
          acc + s"Product: ${p.name} Price: ${p.price}$lineSeparator"
        )
      // Add total
      val total: Double = AmountCalculator.calculatePrice(
        this,
        applyAgeDiscount = true,
        customer.age
      )
      val statementWithProductAndTotal: String =
        statementWithProduct + "Total: " + total + "€"

      Success(statementWithProductAndTotal)
    } else Failure(new IllegalArgumentException("InvalidOrder"))
  }

  def totalPrice: Double = {
    products
      .map(p => p.price)
      .sum
  }
}
