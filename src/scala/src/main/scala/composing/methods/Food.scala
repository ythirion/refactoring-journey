package composing.methods

import java.time.LocalDate

final case class Food(
    expirationDate: LocalDate,
    approvedForConsumption: Boolean,
    inspectorId: Option[Int]
) {
  val hasBeenInspected: Boolean = inspectorId.isDefined

  def isFresh: Boolean = expirationDate.isAfter(LocalDate.now)

  def isEdible: Boolean =
    isFresh && approvedForConsumption && hasBeenInspected
}
