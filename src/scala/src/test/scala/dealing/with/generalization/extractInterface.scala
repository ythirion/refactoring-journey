package dealing.`with`.generalization

import org.scalamock.scalatest.MockFactory
import org.scalatest.funsuite.AnyFunSuite

class extractInterface extends AnyFunSuite with MockFactory {
  private val console = mock[BusinessLogger]
  private val triAthlete = TriAthlete("Alistair Brownlee", console)
  private val jumpyAthlete = JumpyAthlete("A crazy guy", console)

  test("triAthlete can swim") {
    expectCall("Alistair Brownlee started swimming")
    triAthlete.swim()
  }

  test("triAthlete can cycle") {
    expectCall("Alistair Brownlee started cycling")
    triAthlete.cycle()
  }

  test("triAthlete can run") {
    expectCall("Alistair Brownlee started running")
    triAthlete.run()
  }

  test("jumpyAthlete can swim") {
    expectCall("A crazy guy started swimming")
    jumpyAthlete.swim()
  }

  test("jumpyAthlete can cycle") {
    expectCall("A crazy guy started cycling")
    jumpyAthlete.cycle()
  }

  test("jumpyAthlete can run") {
    expectCall("A crazy guy started running")
    jumpyAthlete.run()
  }

  test("jumpyAthlete can skydive") {
    expectCall("A crazy guy is skydiving")
    jumpyAthlete.jump()
  }

  private def expectCall(expected: String): Unit = {
    (console.log _).expects(expected).once()

  }
}
