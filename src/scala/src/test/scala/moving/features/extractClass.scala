package org.ythirion.refactoring.journey
package moving.features

import org.scalatest.funsuite.AnyFunSuite

import java.time.LocalDate

class extractClass extends AnyFunSuite {
  val mane = Player(firstName = "Sadio", lastName = "Mané", birthDate = LocalDate.of(1992, 10, 4),
    height = 175, weight = 69, pace = 94, passing = 80, physicality = 76, rating = 90, shooting = 85, dribbling = 90, defending = 79)

  val pogba = Player(firstName = "Paul", lastName = "Pogba", birthDate = LocalDate.of(1994, 3, 3),
    height = 191, weight = 84, pace = 73, passing = 86, physicality = 85, rating = 86, shooting = 81, dribbling = 85, defending = 66)

  val vanDijk = Player(firstName = "Virgil", lastName = "van Dijk", birthDate = LocalDate.of(1991, 8, 7),
    height = 193, weight = 92, pace = 76, passing = 71, physicality = 86, rating = 90, shooting = 60, dribbling = 72, defending = 91)

  test("mane can dribble pogba") {
    assert(mane.canDribble(pogba))
  }

  test("pogba can dribble mane") {
    assert(pogba.canDribble(mane))
  }

  test("pogba can not dribble van Dijk") {
    assert(!pogba.canDribble(vanDijk))
  }
}