package org.ythirion.refactoring.journey
package organizing.data

import org.scalatest.funsuite.AnyFunSuite

class encapsulateFields extends AnyFunSuite {
  test("Harry Potter") {
    val harryPotter = Wizard("Harry Potter",
      Some("Bâton de la Mort"),
      Some("None"),
      100)

    assert(harryPotter.life == 100)
  }
}
