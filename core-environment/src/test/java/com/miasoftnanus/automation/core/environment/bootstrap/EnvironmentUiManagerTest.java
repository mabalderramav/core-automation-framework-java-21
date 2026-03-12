package com.miasoftnanus.automation.core.environment.bootstrap;

import com.miasoftnanus.automation.core.environment.model.Portal;
import com.miasoftnanus.automation.core.environment.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Test class for {@link EnvironmentUiManager}, specifically the {@code getInstance} method.
 * Validates the singleton functionality and proper initialization of environment-specific details.
 */
class EnvironmentUiManagerTest {

    @AfterEach
    void tearDown() {
        EnvironmentUiManager.resetInstance();
    }

    @Test
    void getInstance_ShouldReturnSingletonInstance_WhenCalledWithValidArguments() {
        // Arrange
        String environmentName = "QA";
        String portalWeb = "MIASOFTNANUS_UI";
        String userType = "GOOGLE";
        String environmentFilePath = "./src/test/resources/EnvironmentUi.json";

        // Act
        EnvironmentUiManager instance1 = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);
        EnvironmentUiManager instance2 = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);

        // Assert
        assertNotNull(instance1, "The instance should not be null.");
        assertNotNull(instance2, "The instance should not be null.");
        assertSame(instance1, instance2, "The singleton instances should be the same.");
        assertEquals(portalWeb, instance1.portalWeb(), "The portalWeb should match the assigned value.");
        assertEquals(userType, instance1.userType(), "The userType should match the assigned value.");
    }

    @Test
    void getInstance_ShouldInitializePortalAndUser_WhenCalledWithValidArguments() {
        // Arrange
        String environmentName = "TestEnvironment";
        String portalWeb = "TestPortal";
        String userType = "Admin";
        String environmentFilePath = "./src/test/resources/EnvironmentUi.json";

        // Act
        EnvironmentUiManager instance = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);

        // Assert
        assertNotNull(instance, "The instance should not be null.");
        assertNotNull(instance.portal(), "The portal should not be null.");
        assertNotNull(instance.user(), "The user should not be null.");
    }

    @Test
    void getInstance_ShouldFallbackToDefaults_WhenNoMatchingPortalOrUserFound() {
        // Arrange
        String environmentName = "InvalidEnvironment";
        String portalWeb = "NonExistentPortal";
        String userType = "UnknownUserType";
        String environmentFilePath = "./src/test/resources/EnvironmentUi.json";

        // Act
        EnvironmentUiManager instance = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);

        // Assert
        assertNotNull(instance, "The instance should not be null.");
        assertNotNull(instance.portal(), "The portal should not be null.");
        assertNotNull(instance.user(), "The user should not be null.");
        assertEquals(new Portal(), instance.portal(), "The portal should fall back to default.");
        assertEquals(new User(), instance.user(), "The user should fall back to a default user instance.");
    }

    @Test
    void resetInstance_ShouldClearSingletonInstance_WhenCalled() {
        // Arrange
        String environmentName = "QA";
        String portalWeb = "MIASOFTNANUS_UI";
        String userType = "GOOGLE";
        String environmentFilePath = "./src/test/resources/EnvironmentUi.json";
        EnvironmentUiManager initialInstance = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);

        // Act
        EnvironmentUiManager.resetInstance();
        EnvironmentUiManager newInstance = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);

        // Assert
        assertNotNull(initialInstance, "The initial instance should not be null.");
        assertNotNull(newInstance, "The new instance should not be null.");
        assertNotSame(initialInstance, newInstance, "A new instance should be created after resetInstance is called.");
    }

    @Test
    void getInstance_ShouldReturnSingleton_WhenCalledWithoutEnvironmentFilePath() {
        // Arrange
        String environmentName = "QA";
        String portalWeb = "MIASOFTNANUS_UI";
        String userType = "GOOGLE";

        // Act
        EnvironmentUiManager instance1 = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType);
        EnvironmentUiManager instance2 = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType);

        // Assert
        assertNotNull(instance1, "The instance should not be null.");
        assertNotNull(instance2, "The instance should not be null.");
        assertSame(instance1, instance2, "The singleton instances should be the same.");
        assertEquals(portalWeb, instance1.portalWeb(), "The portalWeb should match the assigned value.");
        assertEquals(userType, instance1.userType(), "The userType should match the assigned value.");
        assertEquals(environmentName, instance1.environmentUi().name(), "The environmentName should match the assigned value.");
    }

    @Test
    void getInstance_ShouldFallbackToDefaults_WhenInvalidArgumentsProvidedWithoutFilePath() {
        // Arrange
        String environmentName = "NonexistentEnv";
        String portalWeb = "InvalidPortal";
        String userType = "InvalidUser";

        // Act
        EnvironmentUiManager instance = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType);

        // Assert
        assertNotNull(instance, "The instance should not be null.");
        assertNotNull(instance.portal(), "The portal should not be null.");
        assertNotNull(instance.user(), "The user should not be null.");
        assertEquals(new Portal(), instance.portal(), "The portal should fall back to default.");
        assertEquals(new User(), instance.user(), "The user should fall back to a default user instance.");
    }
}