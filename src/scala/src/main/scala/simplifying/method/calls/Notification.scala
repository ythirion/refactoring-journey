package simplifying.method.calls

import simplifying.method.calls.Notification.authorizedChannels

class Notification {
  private var channel: Option[String] = None

  def this(c: String) {
    this
    if (c.isEmpty || !authorizedChannels.contains(c)) {
      throw new IllegalArgumentException("Invalid channel provided")
    }
    channel = Some(c)
  }
}

object Notification {
  val authorizedChannels = List("SMS", "EMAIL", "PUSH")
}
