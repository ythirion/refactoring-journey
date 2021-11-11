package dealing.`with`.generalization

import scala.util.{Failure, Success, Try}

final case class TheaterPiece(description: String, numberOfActors: Int)
    extends Event {
  private var running: Boolean = false
  private var startTime: Long = 0
  private var stopTime: Long = 0

  def start(): Try[Boolean] = {
    if (running) {
      Failure(new IllegalStateException("Piece is already in progress"))
    } else {
      startTime = System.currentTimeMillis()
      running = true

      Success(running)
    }
  }

  def end(): Unit = {
    if (running) {
      running = false
      stopTime = System.currentTimeMillis()
    }
  }

  def calculateElapsedTime: Long = {
    if (running) System.currentTimeMillis() - startTime
    else stopTime - startTime
  }
}
