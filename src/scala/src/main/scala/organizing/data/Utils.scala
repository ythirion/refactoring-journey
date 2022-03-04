package organizing.data

import scala.util.{Failure, Success, Try}

object Utils {
  val gravitationalConstant = 9.81
  val minimumPasswordLength = 12

  def validatePassword(password: String): Try[Boolean] = {
    password match {
      case p if p.length < minimumPasswordLength =>
        Failure(
          new IllegalArgumentException(
            "minimum password length is not respected"
          )
        )
      case _ => Success(true)
    }
  }

  def calculatePotentialEnergy(mass: Double, height: Double): Double =
    mass * height * gravitationalConstant
}
