package org.ythirion.refactoring.journey
package composing.methods

case class Warehouse(id: Int = 0,
                     stock: Map[Product, Integer],
                     reportGenerator: Warehouse => String) {

  def generateStockReport: String = reportGenerator(this)

  def calculateStockValue: Double =
    stock.map { case (product, count) => product.price * count }
      .sum
}