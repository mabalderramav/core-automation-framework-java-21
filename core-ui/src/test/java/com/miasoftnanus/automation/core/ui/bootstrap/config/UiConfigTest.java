package com.miasoftnanus.automation.core.ui.bootstrap.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * A test class for UiConfig's getInstance() method.
 * This class ensures that the singleton instance of UiConfig
 * is properly initialized and remains consistent across calls.
 */
class UiConfigTest {

    /**
     * Test to ensure getInstance() returns a non-null instance.
     */
    @Test
    @DisplayName( "Should return a non-null instance")
    void testGetInstance_NotNull() {
        // Act
        UiConfig instance = UiConfig.getInstance();

        // Assert
        assertNotNull(instance, "UiConfig.getInstance() should not return null.");
    }

    /**
     * Test to ensure getInstance() returns the same instance on multiple calls.
     */
    @Test
    @DisplayName( "Should return the same instance on multiple calls")
    void testGetInstance_SingletonBehavior() {
        // Act
        UiConfig firstInstance = UiConfig.getInstance();
        UiConfig secondInstance = UiConfig.getInstance();

        // Assert
        assertSame(firstInstance, secondInstance, "UiConfig.getInstance() should return the same instance.");
    }

    /**
     * Test to ensure times (implicitTime, explicitTime, sleepTime) are loaded correctly.
     */
    @Test
    @DisplayName("Should verify times (implicit, explicit, sleep) are loaded correctly")
    void testTimesInitialization() {
        // Arrange
        UiConfig config = UiConfig.getInstance();

        // Assert
        assertNotNull(config, "Config instance should not be null.");
        assertEquals(15, config.getImplicitTime(), "Implicit time should match the configuration.");
        assertEquals(15, config.getExplicitTime(), "Explicit time should match the configuration.");
        assertEquals(2, config.getSleepTime(), "Sleep time should match the configuration.");
    }

    /**
     * Test to ensure browser-related properties are loaded correctly.
     */
    @Test
    @DisplayName("Should verify browser properties are loaded correctly")
    void testBrowserPropertiesInitialization() {
        // Arrange
        UiConfig config = UiConfig.getInstance();

        // Assert
        assertNotNull(config, "Config instance should not be null.");
        assertEquals("CHROME", config.getBrowser(), "Browser should match the configuration.");
        assertEquals("114.0", config.getChromeDriverVersion(), "Chrome driver version should match the configuration.");
        assertEquals("src/test/resources/downloads/", config.getDownloadsFolder(), "Downloads folder should match the configuration.");
        assertEquals(1920, config.getWidthOfBrowser(), "Browser width should match the configuration.");
        assertEquals(1200, config.getHeightOfBrowser(), "Browser height should match the configuration.");
    }

    /**
     * Test to ensure Selenium server properties (url, port) are loaded correctly.
     */
    @Test
    @DisplayName("Should verify Selenium hub properties are loaded correctly")
    void testSeleniumHubPropertiesInitialization() {
        // Arrange
        UiConfig config = UiConfig.getInstance();

        // Assert
        assertNotNull(config, "Config instance should not be null.");
        assertEquals("http://selenium-hub", config.getSeleniumHubUrl(), "Selenium Hub URL should match the configuration.");
        assertEquals("4444", config.getSeleniumHubPort(), "Selenium Hub port should match the configuration.");
    }

    /**
     * Test to ensure environment property is loaded correctly.
     */
    @Test
    @DisplayName("Should verify environment property is loaded correctly")
    void testEnvironmentInitialization() {
        // Arrange
        UiConfig config = UiConfig.getInstance();

        // Assert
        assertNotNull(config, "Config instance should not be null.");
        assertEquals("QA", config.getEnvironment(), "Environment should match the configuration.");
    }

    /**
     * Test to ensure isBrowserLogEnable returns true when browserLogsEnabled is set to true.
     */
    @Test
    @DisplayName( "Should return true when browserLogsEnabled is set to true")
    void testIsBrowserLogEnable_ReturnsTrue() {
        // Arrange
        UiConfig config = UiConfig.getInstance();
        config.setBrowserLogsEnabled(true);

        // Act
        boolean result = config.isBrowserLogEnable();

        // Assert
        assertSame(true, result, "isBrowserLogEnable should return true when browser logs are enabled.");
    }

    /**
     * Test to ensure isBrowserLogEnable returns false when browserLogsEnabled is set to false.
     */
    @Test
    @DisplayName( "Should return false when browserLogsEnabled is set to false")
    void testIsBrowserLogEnable_ReturnsFalse() {
        // Arrange
        UiConfig config = UiConfig.getInstance();
        config.setBrowserLogsEnabled(false);

        // Act
        boolean result = config.isBrowserLogEnable();

        // Assert
        assertSame(false, result, "isBrowserLogEnable should return false when browser logs are disabled.");
    }
}