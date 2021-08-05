package org.ythirion.refactoring.journey
package simplifying.method.calls

import simplifying.method.calls.Notification.{email, push, sms}

import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Try

class useFactoryMethod extends AnyFunSuite {
  private def assertFailure(notification: Try[Notification]): Unit = {
    assert(notification.failure.exception.getMessage == "Invalid channel provided")
  }

  private def assertSuccess(notification: Try[Notification]): Unit = {
    assert(notification.success.value != null)
  }

  test("return a failure when channel is null") {
    assertFailure(Notification.create(null))
  }

  test("return a failure when channel is empty") {
    assertFailure(Notification.create(""))
  }

  test("return a failure when channel is not authorized") {
    assertFailure(Notification.create("Unauthorized"))
  }

  test("instantiate when channel is SMS") {
    assertSuccess(Notification.create(sms))
  }

  test("instantiate when channel is EMAIL") {
    assertSuccess(Notification.create(email))
  }

  test("instantiate when channel is PUSH") {
    assertSuccess(Notification.create(push))
  }
}
