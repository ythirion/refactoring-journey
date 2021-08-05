package org.ythirion.refactoring.journey
package dealing.`with`.generalization

case class Concert(description: String) extends Event {
  private var volume: Int = 0

  def volumeUp(increase: Int): Unit = {
    volume += increase
  }

  def volumeDown(decrease: Int): Unit = {
    volume -= decrease
  }
}