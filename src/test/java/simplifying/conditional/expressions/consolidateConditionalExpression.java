package simplifying.conditional.expressions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class consolidateConditionalExpression {
    private final AuthorizationService authorizationService = new AuthorizationService();
    private static final String ACTION = "An Action";

    @Test
    public void authorization_service_do_not_authorize_on_null_action() {
        assertThat(authorizationService.isAuthorized(null, null)).isFalse();
    }

    @Test
    public void authorization_service_do_not_authorize_on_empty_action() {
        assertThat(authorizationService.isAuthorized(null, "")).isFalse();
    }

    @Test
    public void authorization_service_do_not_authorize_disabled_user() {
        User disabledUser = User.builder().age(23).isDisabled(true).build();
        assertThat(authorizationService.isAuthorized(disabledUser, ACTION)).isFalse();
    }

    @Test
    public void authorization_service_do_not_authorize_not_loyal_user() {
        User disabledUser = User.builder().age(23).build();
        assertThat(authorizationService.isAuthorized(disabledUser, ACTION)).isFalse();
    }

    @Test
    public void authorization_service_do_not_authorize_on_age_less_than_12() {
        User tooYoungUser = User.builder().age(4).isLoyal(true).build();
        assertThat(authorizationService.isAuthorized(tooYoungUser, ACTION)).isFalse();
    }

    @Test
    public void authorization_service_authorize_loyal_major_enabled_user() {
        User authorizedUser = User.builder().age(23).isLoyal(true).build();
        assertThat(authorizationService.isAuthorized(authorizedUser, ACTION)).isTrue();
    }
}