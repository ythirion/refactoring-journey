package simplifying.conditional.expressions

class AuthorizationService {
  def isAuthorized(user: Option[User], action: Option[String]): Boolean = {
    if (action.exists(_.isEmpty)) return false
    if (user.isEmpty) return false
    if (user.get.age < 18) return false
    if (user.get.isDisabled) return false
    if (!user.get.isLoyal) return false
    true
  }
}
