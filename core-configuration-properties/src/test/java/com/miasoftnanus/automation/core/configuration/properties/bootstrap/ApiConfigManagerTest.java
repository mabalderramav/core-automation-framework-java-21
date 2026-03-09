package com.miasoftnanus.automation.core.configuration.properties.bootstrap;

import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link ApiConfigManager}. This class contains unit tests to ensure the correct behavior of the
 * singleton instance retrieval and API configuration loading.
 */
class ApiConfigManagerTest {

    /**
     * Test to verify that the singleton instance of {@link ApiConfigManager} is correctly created
     * and is not null when requested via {@link ApiConfigManager#getInstance()}.
     */
    @Test
    void testSingletonInstanceNotNull() {
        // Act
        ApiConfigManager instance = ApiConfigManager.getInstance();

        // Assert
        assertNotNull(instance, "The singleton instance of ApiConfigManager should not be null.");
    }

    /**
     * Test to verify that {@link ApiConfigManager#getInstance()} always returns the same singleton
     * instance within a single application lifecycle.
     */
    @Test
    void testSingletonInstanceUniqueness() {
        // Act
        ApiConfigManager firstInstance = ApiConfigManager.getInstance();
        ApiConfigManager secondInstance = ApiConfigManager.getInstance();

        // Assert
        assertSame(firstInstance, secondInstance, "The getInstance method should return the same instance every time.");
    }

    /**
     * Test to verify that the {@link ApiConfigManager} correctly initializes its {@link ApiConfig}
     * property with non-null values.
     */
    @Test
    void testApiConfigInitialization() {
        // Act
        ApiConfigManager instance = ApiConfigManager.getInstance();
        ApiConfig apiConfig = instance.apiConfig();

        // Assert
        assertNotNull(apiConfig, "The apiConfig property should be initialized and not null.");
        assertTrue(apiConfig.apiName() != null && !apiConfig.apiName().isEmpty(),
                "The apiName in apiConfig should be initialized with a valid value.");
    }
}