package moving.features

import java.time.LocalDate

final case class Player(
    firstName: String,
    lastName: String,
    birthDate: LocalDate,
    height: Int,
    weight: Int,
    rating: Int,
    pace: Int,
    shooting: Int,
    passing: Int,
    dribbling: Int,
    defending: Int,
    physicality: Int
) {
  def canDribble(otherPlayer: Player): Boolean =
    physicality + dribbling > otherPlayer.physicality + otherPlayer.defending
}
