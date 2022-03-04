package simplifying.method.calls

import org.scalatest.funsuite.AnyFunSuite

class separateQueryFromModifier extends AnyFunSuite {
  val client = new Client(
    Map(
      "Tenet Deluxe Edition" -> 45.99,
      "Inception" -> 30.50,
      "The Dark Knight" -> 30.50,
      "Interstellar" -> 23.98
    )
  )

  test("client should generate a statement") {
    val statement = client.toStatement

    assert(
      statement ==
        """Tenet Deluxe Edition for 45.99€
        |Inception for 30.5€
        |The Dark Knight for 30.5€
        |Interstellar for 23.98€
        |Total : 130.97€""".stripMargin
    )
  }
}
