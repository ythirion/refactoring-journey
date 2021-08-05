package org.ythirion.refactoring.journey
package moving.features

import java.time.LocalDate

case class Player(firstName: String,
                  lastName: String,
                  birthDate: LocalDate,
                  height: Int,
                  weight: Int,
                  attributes: Attributes) {
  def canDribble(otherPlayer: Player): Boolean =
    attributes.physicality + attributes.dribbling > otherPlayer.attributes.physicality + otherPlayer.attributes.defending
}