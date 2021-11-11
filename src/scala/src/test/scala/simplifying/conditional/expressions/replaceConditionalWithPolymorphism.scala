package simplifying.conditional.expressions

import org.scalatest.funsuite.AnyFunSuite

class replaceConditionalWithPolymorphism extends AnyFunSuite {
  test("calculator should support add") {
    assert(Calculator.calculate(1, 2, "add") == 3)
  }

  test("calculator should support multiply") {
    assert(Calculator.calculate(90, 4, "multiply") == 360)
  }

  test("calculator should support divide") {
    assert(Calculator.calculate(84, 4, "divide") == 21)
  }

  test("calculator should support subtract") {
    assert(Calculator.calculate(84, 23, "subtract") == 61)
  }

  test("calculator should throw exception on unsupported operator") {
    assertThrows[IllegalArgumentException](
      Calculator.calculate(84, 23, "unsupported operator")
    )
  }
}
