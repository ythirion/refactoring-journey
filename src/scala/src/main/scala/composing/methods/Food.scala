package org.ythirion.refactoring.journey
package composing.methods

import java.time.LocalDate

case class Food(expirationDate: LocalDate,
                approvedForConsumption: Boolean,
                inspectorId: Option[Int]) {
  def isEdible: Boolean = {
    val isFresh = expirationDate.isAfter(LocalDate.now)
    val hasBeenInspected = inspectorId.isDefined

    isFresh && approvedForConsumption && hasBeenInspected
  }
}