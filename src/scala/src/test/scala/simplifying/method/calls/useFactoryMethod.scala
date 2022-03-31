package simplifying.method.calls

import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite
import simplifying.method.calls.Notification.{Email, Push, Sms}

import scala.util.{Success, Try}

class useFactoryMethod extends AnyFunSuite {
  private def assertFailure(notification: Try[Notification]): Unit = {
    assert(
      notification.failure.exception.getMessage == "Invalid channel provided"
    )
  }

  test("return a failure when channel is empty") {
    assertFailure(Notification.create(""))
  }

  test("return a failure when channel is not authorized") {
    assertFailure(Notification.create("Unauthorized"))
  }

  test("instantiate when channel is SMS") {
    assert(Notification.create(Sms) == Success(Notification(Sms)))
  }

  test("instantiate when channel is EMAIL") {
    assert(Notification.create(Email) == Success(Notification(Email)))
  }

  test("instantiate when channel is PUSH") {
    assert(Notification.create(Push) == Success(Notification(Push)))
  }
}
