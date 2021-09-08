package dealing.`with`.generalization

import scala.util.{Failure, Success, Try}

final case class Concert(description: String) extends Event {
  private var running: Boolean = false
  private var startTime: Long = 0
  private var stopTime: Long = 0
  private var volume: Int = 0

  def start(): Try[Boolean] = {
    if (running) {
      Failure(new IllegalStateException("Concert is already in progress"))
    } else {
      startTime = System.currentTimeMillis()
      running = true

      Success(running)
    }
  }

  def stop(): Unit = {
    if (running) {
      running = false
      stopTime = System.currentTimeMillis()
    }
  }

  def getElapsedTime: Long = {
    if (running) System.currentTimeMillis() - startTime
    else stopTime - startTime
  }

  def volumeUp(increase: Int): Unit = {
    volume += increase
  }

  def volumeDown(decrease: Int): Unit = {
    volume -= decrease
  }
}
