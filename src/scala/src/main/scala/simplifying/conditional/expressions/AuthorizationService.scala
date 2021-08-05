package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

class AuthorizationService {
  private val majority = 18

  def isAuthorized(user: Option[User], action: String): Boolean = {
    def isActionValid(action: String) = action != null && action.nonEmpty

    def canAuthorizeUser(user: Option[User]): Boolean = {
      user match {
        case Some(u) => u.age > majority && !u.isDisabled && u.isLoyal
        case None => false
      }
    }

    isActionValid(action) && canAuthorizeUser(user)
  }
}