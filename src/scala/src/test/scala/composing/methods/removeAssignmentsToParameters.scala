package org.ythirion.refactoring.journey
package composing.methods

import org.scalatest.funsuite.AnyFunSuite

class removeAssignmentsToParameters extends AnyFunSuite {
  test("Update stock") {
    val stock = Stock(5)
    val newStock = OrderHelper.calculateNewStock(stock, 3)
    // Stock stays untouched
    assert(stock.nbOfItems == 5)
    assert(newStock == 12)
  }
}
