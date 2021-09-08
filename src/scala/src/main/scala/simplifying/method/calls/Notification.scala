package simplifying.method.calls

import scala.util.{Failure, Success, Try}

final case class Notification private (channel: String)

object Notification {
  final val sms = "SMS"
  final val email = "EMAIL"
  final val push = "PUSH"

  val authorizedChannels = List(sms, email, push)

  def create(channel: String): Try[Notification] = {
    if (
      channel == null || channel.isEmpty || !authorizedChannels.contains(
        channel
      )
    )
      Failure(new IllegalArgumentException("Invalid channel provided"))
    else Success(Notification(channel))
  }
}
