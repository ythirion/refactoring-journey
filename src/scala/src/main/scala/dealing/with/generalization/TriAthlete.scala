package org.ythirion.refactoring.journey
package dealing.`with`.generalization

case class TriAthlete(name: String,
                      logger: BusinessLogger)
  extends Cycle with Run with Swim