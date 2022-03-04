package simplifying.conditional.expressions

import scala.util.{Failure, Success, Try}

object Calculator {
  val add = "add"
  val multiply = "multiply"
  val divide = "divide"
  val subtract = "subtract"

  private val supportedOperators = Map[String, (Int, Int) => Int](
    add -> { (a, b) => a + b },
    multiply -> { (a, b) => a * b },
    divide -> { (a, b) => a / b },
    subtract -> { (a, b) => a - b }
  )

  def calculate(a: Int, b: Int, operator: String): Try[Int] = {
    supportedOperators.get(operator) match {
      case Some(op) => Success(op(a, b))
      case None =>
        Failure(new IllegalArgumentException("Not supported operator"))
    }
  }
}
