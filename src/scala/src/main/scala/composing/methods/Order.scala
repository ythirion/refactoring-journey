package composing.methods

final case class Order(customer: Customer, products: List[Product]) {
  lazy val totalPrice: Double = {
    products
      .map(p => p.price)
      .sum
  }
}
