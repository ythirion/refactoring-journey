package simplifying.conditional.expressions

class AuthorizationService {
  def isAuthorized(user: Option[User], action: String): Boolean = {
    if (action == null) return false
    if (action == "") return false
    if (user.isEmpty) return false
    if (user.get.age < 18) return false
    if (user.get.isDisabled) return false
    if (!user.get.isLoyal) return false
    true
  }
}
