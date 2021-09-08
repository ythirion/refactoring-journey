package simplifying.method.calls

import scala.util.Properties.lineSeparator

class Client(val orderLines: Map[String, Double]) {
  var totalAmount: Double = 0

  private def formatLine(name: String, value: Double): String = {
    totalAmount += value
    s"$name for ${value}€"
  }

  def toStatement: String =
    orderLines
      .map { case (product, price) => formatLine(product, price) }
      .mkString(lineSeparator)
      .concat(s"${lineSeparator}Total : ${totalAmount}€")
}
