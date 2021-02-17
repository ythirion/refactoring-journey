package simplifying.conditional.expressions;

public class AuthorizationService {
    private static final int MAJORITY = 18;

    public boolean isAuthorized(User user, String action) {
        return isActionValid(action)
                && isUserAuthorized(user);
    }

    private static boolean isActionValid(String action) {
        return action != null && !action.equals("");
    }

    private boolean isUserAuthorized(User user) {
        return user.getAge() >= MAJORITY
                && !user.isDisabled()
                && user.isLoyal();
    }
}
