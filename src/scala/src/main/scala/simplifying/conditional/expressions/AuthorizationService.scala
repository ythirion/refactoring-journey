package simplifying.conditional.expressions

class AuthorizationService {
  private val Majority = 18

  def isAuthorized(user: Option[User], action: Option[String]): Boolean = {
    isActionValid(action) && canAuthorizeUser(user)
  }

  def isActionValid(action: Option[String]) = action.exists(_.nonEmpty)

  def canAuthorizeUser(user: Option[User]): Boolean = user.exists(u => u.age > Majority && !u.isDisabled && u.isLoyal)
}
