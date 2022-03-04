package simplifying.method.calls

import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite
import simplifying.method.calls.Notification.{email, push, sms}

import scala.util.{Success, Try}

class useFactoryMethod extends AnyFunSuite {
  private def assertFailure(notification: Try[Notification]): Unit = {
    assert(
      notification.failure.exception.getMessage == "Invalid channel provided"
    )
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
    assert(Notification.create(sms) == Success(Notification(sms)))
  }

  test("instantiate when channel is EMAIL") {
    assert(Notification.create(email) == Success(Notification(email)))
  }

  test("instantiate when channel is PUSH") {
    assert(Notification.create(push) == Success(Notification(push)))
  }
}
