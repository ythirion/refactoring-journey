package org.ythirion.refactoring.journey
package composing.methods

import java.time.LocalDate

case class Food(expirationDate: LocalDate, approvedForConsumption: Boolean, inspectorId: Option[Int]) {
  def isEdible: Boolean = {
    if (expirationDate.isAfter(LocalDate.now) && (approvedForConsumption == true) && inspectorId.isEmpty != true) true
    else false
  }
}