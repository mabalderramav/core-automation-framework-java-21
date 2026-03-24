package com.miasoftnanus.automation.core.configuration.properties.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link UiConfigWords} enum.
 * This class tests the behavior of the {@code val()} method, which retrieves the string
 * representation of the reserved word associated with each enum constant.
 */
class UiConfigWordsTest {

    @Test
    void testUiBrowserVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_BROWSER;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.browser", result, "The val() method should return the correct string representation of UI_BROWSER.");
    }

    @Test
    void testUiExplicitTimeVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_EXPLICIT_TIME;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.explicitTimeWait", result, "The val() method should return the correct string representation of UI_EXPLICIT_TIME.");
    }

    @Test
    void testUiImplicitTimeVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_IMPLICIT_TIME;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.implicitTimeWait", result, "The val() method should return the correct string representation of UI_IMPLICIT_TIME.");
    }

    @Test
    void testUiPageLoadTimeVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_PAGE_LOAD_TIME;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.pageLoadTimeWait", result, "The val() method should return the correct string representation of UI_PAGE_LOAD_TIME.");
    }

    @Test
    void testUiSleepTimeVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_SLEEP_WAIT_TIME;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.sleepWaitTime", result, "The val() method should return the correct string representation of UI_SLEEP_TIME.");
    }

    @Test
    void testUiChromeDriverVersionVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_DRIVER_VERSION;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.driverVersion", result, "The val() method should return the correct string representation of UI_DRIVER_VERSION.");
    }

    @Test
    void testUiWidthVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_WIDTH;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.width", result, "The val() method should return the correct string representation of UI_WIDTH.");
    }

    @Test
    void testUiHeightVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_HEIGHT;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.height", result, "The val() method should return the correct string representation of UI_HEIGHT.");
    }

    @Test
    void testUiDownloadsVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_DOWNLOADS;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.downloads", result, "The val() method should return the correct string representation of UI_DOWNLOADS.");
    }

    @Test
    void testUiBrowserLogsVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_BROWSER_LOGS;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.browserLogs", result, "The val() method should return the correct string representation of UI_BROWSER_LOGS.");
    }

    @Test
    void testUiSeleniumHubUrlVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_SELENIUM_HUB_URL;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.seleniumHubUrl", result, "The val() method should return the correct string representation of UI_SELENIUM_HUB_URL.");
    }

    @Test
    void testUiSeleniumHubPortVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_SELENIUM_HUB_PORT;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.seleniumHubPort", result, "The val() method should return the correct string representation of UI_SELENIUM_HUB_PORT.");
    }

    @Test
    void testUiIncognitoModeVal() {
        // Arrange
        UiConfigWords uiConfigWord = UiConfigWords.UI_INCOGNITO_MODE;

        // Act
        String result = uiConfigWord.val();

        // Assert
        assertEquals("ui.incognitoMode", result, "The val() method should return the correct string representation of UI_INCOGNITO_MODE.");
    }
}