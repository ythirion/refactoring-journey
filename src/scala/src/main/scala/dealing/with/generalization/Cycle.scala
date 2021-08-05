package org.ythirion.refactoring.journey
package dealing.`with`.generalization

trait Cycle extends Athlete {
  def cycle(): Unit = logger.log(s"$name started cycling")
}