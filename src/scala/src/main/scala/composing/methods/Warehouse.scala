package composing.methods

import scala.util.Properties.lineSeparator

final case class Warehouse(id: Int = 0, stock: Map[Product, Integer]) {
  def generateStockReport: String = {
    val report: String = s"Report for warehouse : $id$lineSeparator"
    // Add detail
    val reportWithDetail = stock.foldLeft(report) { case (acc, (product, count)) =>
      acc + s"Product: ${product.name} Price: ${product.price} Stock : $count units$lineSeparator"
    }
    // Add total
    val reportWithDetailAndTotal = reportWithDetail + s"Total: ${stock.map { case (product, count) => product.price * count }.sum}€"
    reportWithDetailAndTotal
  }
}
