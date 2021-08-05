package org.ythirion.refactoring.journey
package simplifying.method.calls

import scala.util.{Failure, Success, Try}

case class Notification private(channel: String)

object Notification {
  val sms = "SMS"
  val email = "EMAIL"
  val push = "PUSH"

  val authorizedChannels = List(sms, email, push)

  def create(channel: String): Try[Notification] = {
    if (channel == null || channel.isEmpty || !authorizedChannels.contains(channel))
      Failure(new IllegalArgumentException("Invalid channel provided"))
    else Success(Notification(channel))
  }
}