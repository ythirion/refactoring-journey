package simplifying.method.calls

import org.scalatest.funsuite.AnyFunSuite

class renameMethod extends AnyFunSuite {
  test("john doe is a perfect employee") {
    val johnDoe =
      Employee("John Doe", "?", "Beach", List("Hunter", "Accountant"))

    assert(johnDoe.getId.nonEmpty)
    assert(johnDoe.name == "John Doe")
    assert(johnDoe.role == "?")
    assert(johnDoe.currentProject == "Beach")
    assert(johnDoe.isWorking)
    assert(johnDoe.hasIdealJob)
    assert(johnDoe.isSkilledAt("Accountant"))
    assert(!johnDoe.isSkilledAt("Football"))
  }
}
