package composing.methods

final case class Warehouse(
    id: Int,
    stock: Map[Product, Integer]
) {
  lazy val calculateStockValue: Double =
    stock.map { case (product, count) => product.price * count }.sum

  def generate(reportGenerator: Warehouse => String): String =
    reportGenerator(this)
}
