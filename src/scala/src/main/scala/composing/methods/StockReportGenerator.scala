package org.ythirion.refactoring.journey
package composing.methods

object StockReportGenerator {
  def generate(warehouse: Warehouse): String = {
    createReport(warehouse)
      .append(formatStock(warehouse))
      .append(s"Total: ${warehouse.calculateStockValue}€")
      .toString()
  }

  private def createReport(warehouse: Warehouse) =
    new StringBuilder(s"Report for warehouse : ${warehouse.id}\n")

  private def formatStock(warehouse: Warehouse) = {
    warehouse.stock
      .map { case (product, count) => s"Product: ${product.name} Price: ${product.price} Stock : $count units\n" }
      .mkString
  }
}