package org.ythirion.refactoring.journey
package dealing.`with`.generalization

case class JumpyAthlete(name: String,
                        logger: BusinessLogger)
  extends Swim with Run with Cycle with Jump