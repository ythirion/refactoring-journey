package org.ythirion.refactoring.journey
package organizing.data

import scala.util.Try

object Utils {
  def validatePassword(password: String): Try[Boolean] = {
    Try {
      if (password.length < 12) throw new IllegalArgumentException("minimum password length is not respected")
      true
    }
  }

  def calculatePotentialEnergy(mass: Double, height: Double): Double = mass * height * 9.81
}
