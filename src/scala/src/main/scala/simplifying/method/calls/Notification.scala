package simplifying.method.calls

import scala.util.{Failure, Success, Try}

final case class Notification private (channel: String)

object Notification {
  final val Sms = "SMS"
  final val Email = "EMAIL"
  final val Push = "PUSH"

  val authorizedChannels = List(Sms, Email, Push)

  def create(channel: String): Try[Notification] = {
    if (channel.isEmpty || !authorizedChannels.contains(channel))
      Failure(new IllegalArgumentException("Invalid channel provided"))
    else Success(Notification(channel))
  }
}
