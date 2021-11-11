package simplifying.method.calls

import org.scalatest.funsuite.AnyFunSuite

class renameMethod extends AnyFunSuite {
  test("john doe is a perfect employee") {
    val johnDoe =
      Employee("John Doe", "?", "Beach", List("Hunter", "Accountant"))

    assert(johnDoe.get.nonEmpty)
    assert(johnDoe.getN == "John Doe")
    assert(johnDoe.getR == "?")
    assert(johnDoe.getP == "Beach")
    assert(johnDoe.isProfessionalService)
    assert(johnDoe.isIdeal)
    assert(johnDoe.hasSomething("Accountant"))
    assert(!johnDoe.hasSomething("Football"))
  }
}
