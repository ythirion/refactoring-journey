package org.ythirion.refactoring.journey
package organizing.data

import org.scalatest.funsuite.AnyFunSuite

class encapsulateFields extends AnyFunSuite {
  test("Harry Potter") {
    val harryPotter = new Wizard("Harry Potter")
    harryPotter.life = 100
    harryPotter.magicStick = Some("Bâton de la Mort")
    harryPotter.weapon = Some("None")

    assert(harryPotter.life == 100)
  }
}
