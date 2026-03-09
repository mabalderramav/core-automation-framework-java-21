package com.miasoftnanus.automation.core.configuration.properties.model;

import com.miasoftnanus.automation.core.configuration.properties.bootstrap.ApiConfigManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiConfigTest {

    @Test
    void testApiConfigIfGetsByApiConfigManager() {
        // Act
        var apiConfig = ApiConfigManager.getInstance().apiConfig();
        var environmentExpected = "QA";
        var environmentFilePathExpected = "";
        var apiNameExpected = "MTU-CONF";
        var versionNameExpected = "V1";
        var authenticationTypeExpected = "BASIC";
        var authenticationUserTypeExpected = "API-AUTO";

        // Assertions
        assertThat(apiConfig.environmentName())
                .as("Environment name should be QA.")
                .isEqualTo(environmentExpected);
        assertThat(apiConfig.environmentFilePath())
                .as("Environment file path should be empty.")
                .isEqualTo(environmentFilePathExpected);
        assertThat(apiConfig.apiName())
                .as("API name should be MTU-CONF.")
                .isEqualTo(apiNameExpected);
        assertThat(apiConfig.versionName())
                .as("Version name should be V1.")
                .isEqualTo(versionNameExpected);
        assertThat(apiConfig.authenticationType())
                .as("Authentication type should be BASIC.")
                .isEqualTo(authenticationTypeExpected);
        assertThat(apiConfig.authenticationUserType())
                .as("Authentication user type should be API-AUTO.")
                .isEqualTo(authenticationUserTypeExpected);
    }
}
