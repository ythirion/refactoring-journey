package simplifying.conditional.expressions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class consolidateConditionalExpression {
    private final AuthorizationService authorizationService = new AuthorizationService();
    private static final String ACTION = "An Action";

    @Test
    public void authorization_service_do_not_authorize_on_null_action() {
        Assertions.assertFalse(authorizationService.isAuthorized(null, null));
    }

    @Test
    public void authorization_service_do_not_authorize_on_empty_action() {
        Assertions.assertFalse(authorizationService.isAuthorized(null, ""));
    }

    @Test
    public void authorization_service_do_not_authorize_disabled_user() {
        User disabledUser = User.builder().age(23).isDisabled(true).build();
        Assertions.assertFalse(authorizationService.isAuthorized(disabledUser, ACTION));
    }

    @Test
    public void authorization_service_do_not_authorize_not_loyal_user() {
        User disabledUser = User.builder().age(23).build();
        Assertions.assertFalse(authorizationService.isAuthorized(disabledUser, ACTION));
    }

    @Test
    public void authorization_service_authorize_loyal_major_enabled_user() {
        User authorizedUser = User.builder().age(23).isLoyal(true).build();
        authorizationService.isAuthorized(authorizedUser, ACTION);
    }
}