package org.ythirion.refactoring.journey
package simplifying.method.calls

import org.scalatest.funsuite.AnyFunSuite

class useFactoryMethod extends AnyFunSuite {
  test("throw an illegal argument exception when channel is null") {
    assertThrows[IllegalArgumentException](new Notification(null))
  }

  test("throw an illegal argument exception when channel is empty") {
    assertThrows[IllegalArgumentException](new Notification(""))
  }

  test("throw an illegal argument exception when channel is not authorized") {
    assertThrows[IllegalArgumentException](new Notification("Unauthorized"))
  }

  test("instantiate when channel is SMS") {
    assert(new Notification("SMS") != null)
  }

  test("instantiate when channel is EMAIL") {
    assert(new Notification("EMAIL") != null)
  }

  test("instantiate when channel is PUSH") {
    assert(new Notification("PUSH") != null)
  }
}
