package simplifying.conditional.expressions

sealed abstract class Operator(private val operationName: String) {
  def calculate(a: Int, b: Int): Int
}

object Operator {
  private lazy val values = List(Add, Subtract, Multiply, Divide)

  def parse(operationName: String): Option[Operator] =
    values.find(_.operationName == operationName)

  final case object Add extends Operator("add") {
    override def calculate(a: Int, b: Int): Int = a + b
  }

  final case object Subtract extends Operator("subtract") {
    override def calculate(a: Int, b: Int): Int = a - b
  }

  final case object Multiply extends Operator("multiply") {
    override def calculate(a: Int, b: Int): Int = a * b
  }

  final case object Divide extends Operator("divide") {
    override def calculate(a: Int, b: Int): Int = a / b
  }
}
