package organizing.data

import scala.util.{Failure, Success, Try}

object Utils {
  def validatePassword(password: String): Try[Boolean] = {
    password match {
      case p if p.length < 12 =>
        Failure(
          new IllegalArgumentException(
            "minimum password length is not respected"
          )
        )
      case _ => Success(true)
    }
  }

  def calculatePotentialEnergy(mass: Double, height: Double): Double =
    mass * height * 9.81
}
