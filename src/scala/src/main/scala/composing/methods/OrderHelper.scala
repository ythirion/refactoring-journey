package org.ythirion.refactoring.journey
package composing.methods

object OrderHelper {
  private val MINIMUM_ITEMS_IN_STOCK = 10

  def deserveDiscount(order: Order): Boolean = {
    val price = order.totalPrice
    price > 1000
  }

  // Customer deserves a discount if customer age / number of products < 5
  def deserveDiscountBasedOnCustomer(order: Order): Boolean = {
    val nbOfProducts = order.products.size
    val customerAge = order.customer.age

    val result = (customerAge / nbOfProducts)
    result < 5
  }

  def calculateNewStock(stock: Stock, outFromStock: Int): Int = {
    val newStock = stock.copy(stock.nbOfItems - outFromStock)
    if (newStock.nbOfItems < MINIMUM_ITEMS_IN_STOCK) return stock.nbOfItems + MINIMUM_ITEMS_IN_STOCK
    newStock.nbOfItems
  }
}