package org.ythirion.refactoring.journey
package composing.methods

import org.scalatest.funsuite.AnyFunSuite

class removeAssignmentsToParameters extends AnyFunSuite {
  test("Update stock") {
    val stock = new Stock(5)
    val newStock = OrderHelper.calculateNewStock(stock, 3)
    assert(stock.nbOfItems == 2)
    assert(newStock == 12)
  }
}
