package composing.methods

import scala.util.Properties.lineSeparator
import scala.util.{Failure, Success, Try}

object OrderService {

  def generateStatement(order: Order): Try[String] = {
    checkState(order) {
      printStatement(order, getTotal(order))
    }
  }

  private def getTotal(order: Order): Double = {
    AmountCalculator.calculatePrice(
      order,
      applyAgeDiscount = true,
      order.customer.age
    )
  }

  private def printStatement(order: Order, total: Double): String = {
    s"${createStatement(order.customer)}${formatProducts(order)}$lineSeparator${formatTotal(total)}"
  }

  private def createStatement(customer: Customer): String =
    s"Statement for : $customer$lineSeparator"

  private def formatProducts(order: Order): String =
    order.products
      .map(p => s"Product: ${p.name} Price: ${p.price}")
      .mkString(lineSeparator)

  private def formatTotal(total: Double): String = s"Total: ${total}€"

  // => T : Pour avoir le bon ordre d'execution
  private def checkState[T](order: Order)(dataIfSuccess: => T): Try[T] = {
    if (order.customer.name.isEmpty || order.products.isEmpty) {
      Failure(new IllegalArgumentException("InvalidOrder"))
    } else
      Success(dataIfSuccess)
  }

}
