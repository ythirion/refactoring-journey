package composing.methods

final case class Warehouse(
    id: Int = 0,
    stock: Map[Product, Integer],
    reportGenerator: Warehouse => String
) {

  lazy val generateStockReport: String = reportGenerator(this)

  lazy val calculateStockValue: Double =
    stock.map { case (product, count) => product.price * count }.sum
}
