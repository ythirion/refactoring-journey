package org.ythirion.refactoring.journey
package composing.methods

import org.scalatest.funsuite.AnyFunSuite

import java.time.LocalDate

class extractVariables extends AnyFunSuite {
  private val IDENTIFIED_INSPECTOR = Some(1)

  private val edible1 = Food(LocalDate.now.plusDays(1), approvedForConsumption = true, IDENTIFIED_INSPECTOR)
  private val edible2 = Food(LocalDate.now.plusDays(20), approvedForConsumption = true, IDENTIFIED_INSPECTOR)

  private val notInspectedFood = Food(LocalDate.now.plusDays(20), approvedForConsumption = true, None)
  private val notApprovedForConsumptionFood = Food(LocalDate.now.plusDays(20), approvedForConsumption = false, IDENTIFIED_INSPECTOR)
  private val expiredFood = Food(LocalDate.now.minusDays(20), approvedForConsumption = false, IDENTIFIED_INSPECTOR)

  test("edible Food") {
    assert(edible1.isEdible)
    assert(edible2.isEdible)
  }

  test("not edible Food") {
    assert(!notInspectedFood.isEdible)
    assert(!notApprovedForConsumptionFood.isEdible)
    assert(!expiredFood.isEdible)
  }
}
