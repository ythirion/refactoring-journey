package org.ythirion.refactoring.journey
package composing.methods

case class Warehouse(id: Int = 0, stock: Map[Product, Integer]) {
  def generateStockReport: String = {
    val report: StringBuilder = new StringBuilder
    report.append(s"Report for warehouse : $id\n")

    stock.foreach {
      case (product, count) => report.append(s"Product: ${product.name} Price: ${product.price} Stock : $count units\n")
    }
    report.append(s"Total: ${stock.map { case (product, count) => product.price * count }.sum}€")
    report.toString
  }
}