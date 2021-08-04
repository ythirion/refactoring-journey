package org.ythirion.refactoring.journey
package simplifying.method.calls

import simplifying.method.calls.Notification.authorizedChannels

class Notification {
  private var channel: String = null

  def this(channel: String) {
    this

    channel match {
      case c if c == null || c.isEmpty || !authorizedChannels.contains(c) => throw new IllegalArgumentException("Invalid channel provided")
      case _ =>
    }
    this.channel = channel
  }
}

object Notification {
  val authorizedChannels = List("SMS", "EMAIL", "PUSH")
}