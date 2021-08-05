package org.ythirion.refactoring.journey
package simplifying.method.calls

class Client(val orderLines: Map[String, Double]) {
  def toStatement: String =
    orderLines.map { case (product, price) => formatLine(product, price) }
      .mkString("\n")
      .concat(s"\nTotal : ${calculateTotal}€")

  private def formatLine(name: String, value: Double): String = s"$name for ${value}€"
  private def calculateTotal: Double = orderLines.values.sum
}