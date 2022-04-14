package simplifying.conditional.expressions

class AuthorizationService {
  private val Majority = 18

  def isAuthorized(user: Option[User], action: Option[String]): Boolean = {
    isActionValid(action) && canAuthorizeUser(user)
  }

  private def isActionValid(action: Option[String]) = action.exists(_.nonEmpty)

  private def canAuthorizeUser(user: Option[User]): Boolean = user.exists(u => u.age > Majority && !u.isDisabled && u.isLoyal)
}
