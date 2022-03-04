package composing.methods

import scala.util.Properties.lineSeparator
import scala.util.{Failure, Success, Try}

object OrderService {

  def generateStatement(order: Order): Try[String] = {
    if (order.customer.name.nonEmpty && order.products.nonEmpty) {
      //Add banner
      val statement: String = s"Statement for : ${order.customer}$lineSeparator"
      // Add details
      val statementWithProduct: String =
        order.products.foldLeft(statement)((acc, p) => acc + s"Product: ${p.name} Price: ${p.price}$lineSeparator")
      // Add total
      val total: Double = AmountCalculator.calculatePrice(
        order,
        applyAgeDiscount = true,
        order.customer.age
      )
      val statementWithProductAndTotal: String =
        statementWithProduct + "Total: " + total + "€"

      Success(statementWithProductAndTotal)
    } else Failure(new IllegalArgumentException("InvalidOrder"))
  }
}
