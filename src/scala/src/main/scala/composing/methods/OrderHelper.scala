package composing.methods

object OrderHelper {
  private val MinimumItemsInStock = 10

  def deserveDiscount(order: Order): Boolean = {
    val price = order.totalPrice
    price > 1000
  }

  // Customer deserves a discount if customer age / number of products < 5
  def deserveDiscountBasedOnCustomer(order: Order): Boolean = {
    val nbOfProducts = order.products.size
    val customerAge = order.customer.age

    val result = customerAge / nbOfProducts
    result < 5
  }

  def calculateNewStock(stock: Stock, outFromStock: Int): Int = {
    stock.nbOfItems = stock.nbOfItems - outFromStock
    if (stock.nbOfItems < MinimumItemsInStock)
      return stock.nbOfItems + MinimumItemsInStock
    stock.nbOfItems
  }
}
