package dealing.`with`.generalization

import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite

class pullUpMethodsOrFields extends AnyFunSuite {
  private val concert = Concert("Therapie Taxi")
  private val piece = TheaterPiece("L'invitation", 3)

  test("retrieve concert duration") {
    val concertDuration = 500

    concert.start()
    Thread.sleep(concertDuration)
    concert.stop()

    assert(concert.getElapsedTime >= concertDuration)
  }

  test(
    "concert returns a failure when calling start on an already started concert"
  ) {
    concert.start()
    assert(
      concert
        .start()
        .failure
        .exception
        .getMessage == "Concert is already in progress"
    )
  }

  test("retrieve piece duration") {
    val pieceDuration = 200

    piece.start()
    Thread.sleep(pieceDuration)
    piece.end()

    assert(piece.calculateElapsedTime >= pieceDuration)
  }

  test(
    "theater piece returns a failure when calling start on an already started piece"
  ) {
    piece.start()
    assert(
      piece
        .start()
        .failure
        .exception
        .getMessage == "Piece is already in progress"
    )
  }
}
