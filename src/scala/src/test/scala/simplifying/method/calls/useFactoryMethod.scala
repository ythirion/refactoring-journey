package org.ythirion.refactoring.journey
package simplifying.method.calls

import org.scalatest.funsuite.AnyFunSuite

class useFactoryMethod extends AnyFunSuite {
  class notification_should extends AnyFunSuite {
    class throw_an_illegal_argument_exception extends AnyFunSuite {
      test("when channel is null") {
        assertThrows[IllegalArgumentException](new Notification(null))
      }

      test("when channel is empty") {
        assertThrows[IllegalArgumentException](new Notification(""))
      }

      test("when channel is not authorized") {
        assertThrows[IllegalArgumentException](new Notification("Unauthorized"))
      }
    }

    class instantiate extends AnyFunSuite {
      test("when channel is SMS") {
        assert(new Notification("SMS") != null)
      }

      test("when channel is EMAIL") {
        assert(new Notification("EMAIL") != null)
      }

      test("when channel is PUSH") {
        assert(new Notification("PUSH") != null)
      }
    }
  }
}
