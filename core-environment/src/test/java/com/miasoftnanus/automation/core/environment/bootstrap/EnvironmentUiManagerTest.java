package com.miasoftnanus.automation.core.environment.bootstrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit tests for the {@link EnvironmentUiManager} class.
 * <p>
 * The tests focus on validating the behavior of the singleton method {@code getInstance},
 * covering scenarios such as instance creation, reusability, and initialization with valid or fallback entities.
 */
class EnvironmentUiManagerTest {

    @Test
    @DisplayName("Should create a new instance of UiEnvironmentManager with valid parameters")
    void testGetInstanceWithValidParameters() {
        // Arrange
        String environmentName = "QA";
        String portalWeb = "MainPortal";
        String userType = "Admin";
        String environmentFilePath = "test-environment.json";

        // Act
        EnvironmentUiManager manager = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);

        // Assert
        assertNotNull(manager, "Manager instance should not be null.");
        assertNotNull(manager.portal(), "Portal should not be null.");
        assertNotNull(manager.user(), "User should not be null.");
        assertNotNull(manager.environment(), "Environment should not be null.");
        assertEquals(environmentName, manager.environment().name(), "Environment name should match.");
        assertEquals(portalWeb, manager.portalWeb(), "Portal web name should match.");
        assertEquals(userType, manager.userType(), "User type should match.");
    }

    @Test
    @DisplayName("Should return the same instance on multiple calls to getInstance")
    void testGetInstanceReturnsSameInstance() {
        // Arrange
        String environmentName = "QA";
        String portalWeb = "MainPortal";
        String userType = "Admin";
        String environmentFilePath = "test-environment.json";

        // Act
        EnvironmentUiManager instance1 = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);
        EnvironmentUiManager instance2 = EnvironmentUiManager.getInstance(environmentName, portalWeb, userType, environmentFilePath);

        // Assert
        assertSame(instance1, instance2, "The same instance should be returned for multiple calls to getInstance.");
    }

    @Test
    @DisplayName("Should return fallback objects if environment, portal, or user is not found")
    void testGetInstanceWithFallbackObjects() {
        // Arrange
        String invalidEnvironmentName = "NonExistentEnvironment";
        String invalidPortalWeb = "NonExistentPortal";
        String invalidUserType = "NonExistentUser";
        String environmentFilePath = "test-environment.json";

        // Act
        EnvironmentUiManager manager = EnvironmentUiManager.getInstance(invalidEnvironmentName, invalidPortalWeb, invalidUserType, environmentFilePath);

        // Assert
        assertNotNull(manager, "Manager instance should not be null.");
        assertNotNull(manager.portal(), "Portal should not be null even when not found.");
        assertNotNull(manager.user(), "User should not be null even when not found.");
        assertNotNull(manager.environment(), "Environment should not be null even when not found.");
        assertEquals("NonExistentEnvironment", manager.environment().name(), "Invalid environment name should match input.");
    }

    @Test
    @DisplayName("Should not create a new instance if one already exists")
    void testSingletonBehavior() {
        // Arrange
        String environmentName1 = "QA";
        String portalWeb1 = "MainPortal";
        String userType1 = "Admin";
        String environmentFilePath1 = "test-environment1.json";

        String environmentName2 = "Prod";
        String portalWeb2 = "SecondaryPortal";
        String userType2 = "Viewer";
        String environmentFilePath2 = "test-environment2.json";

        // Act
        EnvironmentUiManager firstInstance = EnvironmentUiManager.getInstance(environmentName1, portalWeb1, userType1, environmentFilePath1);
        EnvironmentUiManager secondInstance = EnvironmentUiManager.getInstance(environmentName2, portalWeb2, userType2, environmentFilePath2);

        // Assert
        assertSame(firstInstance, secondInstance, "A new instance should not be created if one already exists.");
        assertEquals(environmentName1, firstInstance.environment().name(), "Environment name should match the first instance's initialization.");
        assertEquals(portalWeb1, firstInstance.portalWeb(), "Portal name should match the first instance's initialization.");
        assertEquals(userType1, firstInstance.userType(), "User type should match the first instance's initialization.");
    }
}