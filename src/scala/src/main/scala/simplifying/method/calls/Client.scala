package simplifying.method.calls

import scala.util.Properties.lineSeparator

// Too easy ? Change it with a foldLeft or reduceLeft
class Client(val orderLines: Map[String, Double]) {
  def toStatement: String =
    orderLines
      .map { case (product, price) => formatLine(product, price) }
      .mkString(s"$lineSeparator")
      .concat(s"${lineSeparator}Total : ${calculateTotal}€")

  private def formatLine(name: String, value: Double): String =
    s"$name for ${value}€"
  private def calculateTotal: Double = orderLines.values.sum
}
