package simplifying.conditional.expressions

import scala.util.{Failure, Success, Try}

object Calculator {
  def calculate(a: Int, b: Int, operator: String): Try[Int] = {
    Operator.parse(operator) match {
      case Some(op) => Success(op.calculate(a, b))
      case None =>
        Failure(new IllegalArgumentException("Not supported operator"))
    }
  }
}
