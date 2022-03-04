package composing.methods

import scala.util.Properties.lineSeparator

object StockReportGenerator {
  def generate: Warehouse => String =
    (warehouse: Warehouse) => {
      createReport(warehouse) +
        formatStock(warehouse) +
        s"Total: ${warehouse.calculateStockValue}€"
    }

  private def createReport(warehouse: Warehouse): String =
    s"Report for warehouse : ${warehouse.id}$lineSeparator"

  private def formatStock(warehouse: Warehouse): String = {
    warehouse.stock.map {
      case (product, count) =>
        s"Product: ${product.name} Price: ${product.price} Stock : $count units$lineSeparator"
    }.mkString
  }
}
