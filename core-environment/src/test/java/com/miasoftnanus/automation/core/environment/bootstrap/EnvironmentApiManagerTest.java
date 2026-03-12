package com.miasoftnanus.automation.core.environment.bootstrap;

import com.miasoftnanus.automation.core.environment.model.Api;
import com.miasoftnanus.automation.core.environment.model.Authentication;
import com.miasoftnanus.automation.core.environment.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class EnvironmentApiManagerTest {
    @AfterEach
    void tearDown() {
        EnvironmentApiManager.resetInstance();
    }

    @Test
    void testGetInstanceReturnsSingletonV2() {
        String environmentName = "DEV";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "API-AUTO";

        EnvironmentApiManager instance1 = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType);

        EnvironmentApiManager instance2 = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType);

        Assertions.assertSame(instance1, instance2, "The two instances should be the same (singleton).");
    }

    @Test
    void testGetInstanceWithDefaultEnvironmentFilePath() {
        String environmentName = "DEV";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "API-AUTO";

        EnvironmentApiManager instance = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType
        );

        Assertions.assertNotNull(instance, "The instance should not be null.");
        Assertions.assertEquals(environmentName, instance.environmentApi().name(),
                "Environment name should match the expected default environment.");
    }

    @Test
    void testOverloadedGetInstanceWithoutFilePathInitializesCorrectly() {
        String environmentName = "DEV";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "DEFAULT_USER";

        EnvironmentApiManager instance = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType
        );

        Assertions.assertEquals(apiName, instance.apiName(), "API name should match the expected value.");
        Assertions.assertEquals(versionName, instance.versionName(), "Version name should match the expected value.");
        Assertions.assertEquals(authenticationType, instance.authenticationType(), "Authentication type should match the expected value.");
        Assertions.assertEquals(authenticationUserType, instance.authenticationUserType(), "Authentication user type should match the expected value.");
    }

    @Test
    void testGetInstanceReturnsSingleton() {
        String environmentName = "DEV";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "API-AUTO";
        String environmentFilePath = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance1 = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        EnvironmentApiManager instance2 = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        Assertions.assertSame(instance1, instance2, "The two instances should be the same (singleton).");
    }

    @Test
    void testInstanceInitializationWithValidData() {
        String environmentName = "DEV";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "API-AUTO";
        String environmentFilePath = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        Assertions.assertEquals(apiName, instance.apiName(), "API name should match the expected value.");
        Assertions.assertEquals(versionName, instance.versionName(), "Version name should match the expected value.");
        Assertions.assertEquals(authenticationType, instance.authenticationType(), "Authentication type should match the expected value.");
        Assertions.assertEquals(authenticationUserType, instance.authenticationUserType(), "Authentication user type should match the expected value.");
        Assertions.assertNotNull(instance.api(), "The API object should not be null.");
        Assertions.assertNotNull(instance.authentication(), "The Authentication object should not be null.");
        Assertions.assertNotNull(instance.user(), "The User object should not be null.");
        Assertions.assertNotNull(instance.version(), "The Version object should not be null.");
    }

    @Test
    void testGetInstanceReturnsDefaultUserWhenNoMatch() {
        String environmentName = "QA";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "NON_EXISTENT_USER_TYPE";
        String environmentFilePath = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        User user = instance.user();
        Assertions.assertNotNull(user, "User should not be null.");
        Assertions.assertEquals("", user.type(), "Default User type should be an empty string.");
        Assertions.assertEquals("", user.username(), "Default User username should be an empty string.");
        Assertions.assertEquals("", user.password(), "Default User password should be an empty string.");
    }

    @Test
    void testGetInstanceReturnsDefaultAuthenticationWhenNoMatch() {
        String environmentName = "QA";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "NON_EXISTENT_AUTH_TYPE";
        String authenticationUserType = "API-AUTO";
        String environmentFilePath = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        Authentication authentication = instance.authentication();
        Assertions.assertNotNull(authentication, "Authentication should not be null.");
        Assertions.assertEquals("", authentication.type(), "Default Authentication type should be an empty string.");
    }

    @Test
    void testGetInstanceReturnsDefaultApiWhenNoMatch() {
        String environmentName = "QA";
        String apiName = "NON_EXISTENT_API_NAME";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "API-AUTO";
        String environmentFilePath = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        Api api = instance.api();
        Assertions.assertNotNull(api, "API should not be null.");
        Assertions.assertEquals("", api.name(), "Default API name should be an empty string.");
    }

    @Test
    void testResetInstanceClearsSingletonInstance() {
        String environmentName = "DEV";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "API-AUTO";
        String environmentFilePath = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance1 = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        EnvironmentApiManager.resetInstance();

        EnvironmentApiManager instance2 = EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, environmentFilePath
        );

        Assertions.assertNotSame(instance1, instance2, "After resetInstance, a new instance should be created.");
    }

    @Test
    void testResetInstanceAllowsReinitializationWithNewParameters() {
        String environmentName1 = "DEV";
        String apiName1 = "MIASOFTNANUS_CONF";
        String versionName1 = "V1";
        String authenticationType1 = "BASIC";
        String authenticationUserType1 = "API-AUTO";
        String environmentFilePath1 = "./src/test/resources/EnvironmentApi.json";

        String environmentName2 = "QA";
        String apiName2 = "DIFFERENT_API";
        String versionName2 = "V2";
        String authenticationType2 = "TOKEN";
        String authenticationUserType2 = "DIFFERENT_USER_TYPE";
        String environmentFilePath2 = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance1 = EnvironmentApiManager.getInstance(
                environmentName1, apiName1, versionName1, authenticationType1, authenticationUserType1, environmentFilePath1
        );

        EnvironmentApiManager.resetInstance();

        EnvironmentApiManager instance2 = EnvironmentApiManager.getInstance(
                environmentName2, apiName2, versionName2, authenticationType2, authenticationUserType2, environmentFilePath2
        );

        Assertions.assertNotSame(instance1, instance2, "After resetInstance, a new instance should be created.");

        Assertions.assertEquals(apiName2, instance2.apiName(), "API name should match the new parameters.");
        Assertions.assertEquals(versionName2, instance2.versionName(), "Version name should match the new parameters.");
        Assertions.assertEquals(authenticationType2, instance2.authenticationType(), "Authentication type should match the new parameters.");
        Assertions.assertEquals(authenticationUserType2, instance2.authenticationUserType(), "Authentication user type should match the new parameters.");
    }

    @Test
    void testGetInstanceWithFilePathDoesNotReinitializeWhenInstanceAlreadyExists() {
        String environmentName1 = "DEV";
        String apiName1 = "MIASOFTNANUS_CONF";
        String versionName1 = "V1";
        String authenticationType1 = "BASIC";
        String authenticationUserType1 = "API-AUTO";
        String environmentFilePath1 = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance1 = EnvironmentApiManager.getInstance(
                environmentName1, apiName1, versionName1, authenticationType1, authenticationUserType1, environmentFilePath1
        );

        // Call again with different params — singleton should still return the original instance
        String environmentName2 = "QA";
        String apiName2 = "DIFFERENT_API";
        String versionName2 = "V2";
        String authenticationType2 = "TOKEN";
        String authenticationUserType2 = "DIFFERENT_USER_TYPE";
        String environmentFilePath2 = "./src/test/resources/EnvironmentApi.json";

        EnvironmentApiManager instance2 = EnvironmentApiManager.getInstance(
                environmentName2, apiName2, versionName2, authenticationType2, authenticationUserType2, environmentFilePath2
        );

        Assertions.assertSame(instance1, instance2, "Should return the same singleton instance.");
        // Ensure it kept the first initialization values
        Assertions.assertEquals(apiName1, instance2.apiName(), "API name should remain the one from the first initialization.");
        Assertions.assertEquals(versionName1, instance2.versionName(), "Version name should remain the one from the first initialization.");
        Assertions.assertEquals(authenticationType1, instance2.authenticationType(), "Authentication type should remain the one from the first initialization.");
        Assertions.assertEquals(authenticationUserType1, instance2.authenticationUserType(), "Authentication user type should remain the one from the first initialization.");
    }

    @Test
    void testGetInstanceWithInvalidFilePathThrowsException() {
        String environmentName = "DEV";
        String apiName = "MIASOFTNANUS_CONF";
        String versionName = "V1";
        String authenticationType = "BASIC";
        String authenticationUserType = "API-AUTO";
        String invalidEnvironmentFilePath = "./src/test/resources/does-not-exist.json";

        Executable call = () -> EnvironmentApiManager.getInstance(
                environmentName, apiName, versionName, authenticationType, authenticationUserType, invalidEnvironmentFilePath
        );

        Assertions.assertThrows(RuntimeException.class, call,
                "An invalid environment file path should cause initialization to fail.");
    }
}