package com.miasoftnanus.automation.core.ui.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WebDriverTypesTest {

    @Test
    void values_containsExpectedWebDriverTypesInOrder() {
        assertThat(WebDriverTypes.values())
                .containsExactly(
                        WebDriverTypes.LOCALLY,
                        WebDriverTypes.DOCKER,
                        WebDriverTypes.REMOTE
                );
    }

    @Test
    void locally_returnsExpectedValue() {
        assertThat(WebDriverTypes.LOCALLY.val()).isEqualTo("LOCALLY");
    }

    @Test
    void docker_returnsExpectedValue() {
        assertThat(WebDriverTypes.DOCKER.val()).isEqualTo("DOCKER");
    }

    @Test
    void remote_returnsExpectedValue() {
        assertThat(WebDriverTypes.REMOTE.val()).isEqualTo("REMOTE");
    }

    @Test
    void valueOf_roundTripsEnumNamesUsedByConsumers() {
        assertThat(WebDriverTypes.valueOf(WebDriverTypes.LOCALLY.name())).isSameAs(WebDriverTypes.LOCALLY);
        assertThat(WebDriverTypes.valueOf(WebDriverTypes.DOCKER.name())).isSameAs(WebDriverTypes.DOCKER);
        assertThat(WebDriverTypes.valueOf(WebDriverTypes.REMOTE.name())).isSameAs(WebDriverTypes.REMOTE);
    }
}

