package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

import org.scalatest.flatspec.AnyFlatSpec

class consolidateConditionalExpression extends AnyFlatSpec {
  private val authorizationService = new AuthorizationService
  private val ACTION = "An Action"

  "Authorization service" should "not authorize when null action" in {
    assert(!authorizationService.isAuthorized(None, null))
  }

  "Authorization service" should "not authorize when None user" in {
    assert(!authorizationService.isAuthorized(None, ACTION))
  }

  "Authorization service" should "not authorize when empty action" in {
    assert(!authorizationService.isAuthorized(None, ""))
  }

  "Authorization service" should "not authorize when user is disabled" in {
    val disabledUser = Some(new User(42, true, false))
    assert(!authorizationService.isAuthorized(disabledUser, ACTION))
  }

  "Authorization service" should "not authorize when user is enabled but not loyal" in {
    val notLoyalUser = Some(new User(42, false, false))
    assert(!authorizationService.isAuthorized(notLoyalUser, ACTION))
  }

  "Authorization service" should "authorize when user is enabled, loyal and major" in {
    val loyalAndMajorUser = Some(new User(42, false, true))
    assert(authorizationService.isAuthorized(loyalAndMajorUser, ACTION))
  }
}
