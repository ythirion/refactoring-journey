package composing.methods

import scala.util.Properties.lineSeparator
import scala.util.{Failure, Success, Try}

final case class Order(customer: Customer, products: List[Product]) {
  lazy val totalPrice: Double = {
    products
      .map(p => p.price)
      .sum
  }
  lazy val generateStatement: Try[String] = {
    checkState {
      val total = AmountCalculator.calculatePrice(
        this,
        applyAgeDiscount = true,
        customer.age
      )

      s"$createStatement$formatProducts$lineSeparator${formatTotal(total)}"
    }
  }
  private lazy val createStatement: String =
    s"Statement for : $customer$lineSeparator"
  private lazy val formatProducts: String =
    products
      .map(p => s"Product: ${p.name} Price: ${p.price}")
      .mkString(lineSeparator)

  private def checkState[T](dataIfSuccess: T): Try[T] = {
    if (customer.name.isEmpty || products.isEmpty) {
      Failure(new IllegalArgumentException("InvalidOrder"))
    } else
      Success(dataIfSuccess)
  }

  private def formatTotal(total: Double): String = s"Total: ${total}€"
}
