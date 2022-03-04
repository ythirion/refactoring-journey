package simplifying.conditional.expressions

import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite

class replaceConditionalWithPolymorphism extends AnyFunSuite {
  test("calculator should support add") {
    assert(Calculator.calculate(1, 2, Calculator.add).success.value == 3)
  }

  test("calculator should support multiply") {
    assert(
      Calculator.calculate(90, 4, Calculator.multiply).success.value == 360
    )
  }

  test("calculator should support divide") {
    assert(Calculator.calculate(84, 4, Calculator.divide).success.value == 21)
  }

  test("calculator should support subtract") {
    assert(
      Calculator.calculate(84, 23, Calculator.subtract).success.value == 61
    )
  }

  test("calculator should throw exception on unsupported operator") {
    assert(
      Calculator
        .calculate(84, 23, "unsupported operator")
        .failure
        .exception
        .getMessage == "Not supported operator"
    )
  }
}
