package simplifying.conditional.expressions;

public class AuthorizationService {
    public boolean isAuthorized(User user, String action) {
        if (action == null) {
            return false;
        }
        if (action.equals("")) {
            return false;
        }
        if (user.getAge() < 18) {
            return false;
        }
        if (user.isDisabled()) {
            return false;
        }
        if (!user.isLoyal()) {
            return false;
        }
        return true;
    }
}
