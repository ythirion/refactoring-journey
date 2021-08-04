package org.ythirion.refactoring.journey
package organizing.data

import organizing.data.Utils.{calculatePotentialEnergy, validatePassword}

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite

class extractConstants extends AnyFunSuite {

  test("validPassword returns a success for password following pwd rules") {
    val validPassword = "OJ°0I°09121l."
    assert(validatePassword(validPassword).success.value)
  }

  test("validPassword returns a failure for password not following pwd rules") {
    val invalidPassword = "Im invalid"
    assert(validatePassword(invalidPassword).failure.exception.getMessage == "minimum password length is not respected")
  }

  test("calculate potential energy") {
    assert(calculatePotentialEnergy(1, 1) == 9.81)
    assert(calculatePotentialEnergy(98.9897, 160.987) === 156332.7 +- 0.01)
    assert(calculatePotentialEnergy(0, 1) == 0)
    assert(calculatePotentialEnergy(1, 0) == 0)
  }
}