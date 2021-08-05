package org.ythirion.refactoring.journey
package dealing.`with`.generalization

trait Swim extends Athlete {
  def swim(): Unit = logger.log(s"$name started swimming")
}
