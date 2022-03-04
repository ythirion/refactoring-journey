package simplifying.conditional.expressions

class AuthorizationService {
  private val Majority = 18

  def isAuthorized(user: Option[User], action: String): Boolean = {
    def isActionValid(action: String) = action != null && action.nonEmpty

    def canAuthorizeUser(user: Option[User]): Boolean = {
      user.exists(u => u.age > Majority && !u.isDisabled && u.isLoyal)
    }

    isActionValid(action) && canAuthorizeUser(user)
  }
}
