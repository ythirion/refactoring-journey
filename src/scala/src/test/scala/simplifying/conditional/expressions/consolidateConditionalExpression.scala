package simplifying.conditional.expressions

import org.scalatest.flatspec.AnyFlatSpec

class consolidateConditionalExpression extends AnyFlatSpec {
  private val authorizationService = new AuthorizationService
  private val Action = "An Action"

  "Authorization service" should "not authorize when null action" in {
    assert(!authorizationService.isAuthorized(None, null))
  }

  "Authorization service" should "not authorize when None user" in {
    assert(!authorizationService.isAuthorized(None, Action))
  }

  "Authorization service" should "not authorize when empty action" in {
    assert(!authorizationService.isAuthorized(None, ""))
  }

  "Authorization service" should "not authorize when user is disabled" in {
    val disabledUser = Some(User(42, isDisabled = true, isLoyal = false))
    assert(!authorizationService.isAuthorized(disabledUser, Action))
  }

  "Authorization service" should "not authorize when user is enabled but not loyal" in {
    val notLoyalUser = Some(User(42, isDisabled = false, isLoyal = false))
    assert(!authorizationService.isAuthorized(notLoyalUser, Action))
  }

  "Authorization service" should "not authorize when user is minor" in {
    val minorUser = Some(User(17, isDisabled = false, isLoyal = true))
    assert(!authorizationService.isAuthorized(minorUser, Action))
  }

  "Authorization service" should "authorize when user is enabled, loyal and major" in {
    val loyalAndMajorUser = Some(User(42, isDisabled = false, isLoyal = true))
    assert(authorizationService.isAuthorized(loyalAndMajorUser, Action))
  }
}
