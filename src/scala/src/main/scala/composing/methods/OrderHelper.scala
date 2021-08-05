package org.ythirion.refactoring.journey
package composing.methods

object OrderHelper {
  private val MINIMUM_ITEMS_IN_STOCK = 10

  def deserveDiscount(order: Order): Boolean = {
    order.totalPrice > 1000
  }

  // Customer deserves a discount if customer age / number of products < 5
  def deserveDiscountBasedOnCustomer(order: Order): Boolean = {
    val nbOfProducts = order.products.size
    val customerAge = order.customer.age

    customerAge / nbOfProducts < 5
  }

  def calculateNewStock(stock: Stock, outFromStock: Int): Int = {
    val newStock = stock.nbOfItems - outFromStock
    if (newStock < MINIMUM_ITEMS_IN_STOCK) newStock + MINIMUM_ITEMS_IN_STOCK else stock.nbOfItems
  }
}