package com.miasoftnanus.automation.core.api.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BasicAuthenticationTest {

    @Test
    void constructor_acceptsValidUsernameAndPassword() {
        BasicAuthentication auth = new BasicAuthentication("user", "pass");

        assertThat(auth.username()).isEqualTo("user");
        assertThat(auth.password()).isEqualTo("pass");
    }

    @Test
    void constructor_rejectsNullUsername() {
        assertThatNullPointerException()
                .isThrownBy(() -> new BasicAuthentication(null, "pass"))
                .withMessage("'username' must not be null");
    }

    @Test
    void constructor_rejectsNullPassword() {
        assertThatNullPointerException()
                .isThrownBy(() -> new BasicAuthentication("user", null))
                .withMessage("'password' must not be null");
    }

    @Test
    void constructor_rejectsEmptyUsername() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BasicAuthentication("", "pass"))
                .withMessage("'username or password' must not be empty");
    }

    @Test
    void constructor_rejectsEmptyPassword() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BasicAuthentication("user", ""))
                .withMessage("'username or password' must not be empty");
    }

    @Test
    void recordEqualityHashCodeAndToString_areConsistent() {
        BasicAuthentication a = new BasicAuthentication("user", "pass");
        BasicAuthentication b = new BasicAuthentication("user", "pass");

        assertThat(a)
                .isEqualTo(b)
                .hasSameHashCodeAs(b);

        String s = a.toString();
        assertThat(s)
                .contains("username=")
                .contains("password=");
    }
}

