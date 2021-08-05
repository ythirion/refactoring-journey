package org.ythirion.refactoring.journey
package dealing.`with`.generalization

trait Jump extends Athlete {
  def jump(): Unit = logger.log(s"$name is skydiving")
}