package com.miasoftnanus.automation.core.configuration.properties.model;

/**
 * Enum representing reserved words used for UI configuration.
 * This is used to centralize and manage key constants specific to UI-related configurations
 * such as browser settings, timeouts, and dimensions to ensure consistency across the application.
 */
public enum UiConfigWords {
    UI_BROWSER("ui.browser"),
    UI_EXPLICIT_TIME("ui.explicitTimeWait"),
    UI_IMPLICIT_TIME("ui.implicitTimeWait"),
    UI_PAGE_LOAD_TIME("ui.pageLoadTimeWait"),
    UI_SLEEP_WAIT_TIME("ui.sleepWaitTime"),
    UI_DRIVER_VERSION("ui.driverVersion"),
    UI_WIDTH("ui.width"),
    UI_HEIGHT("ui.height"),
    UI_DOWNLOADS("ui.downloads"),
    UI_BROWSER_LOGS("ui.browserLogs"),
    UI_SELENIUM_HUB_URL("ui.seleniumHubUrl"),
    UI_SELENIUM_HUB_PORT("ui.seleniumHubPort"),
    UI_INCOGNITO_MODE("ui.incognitoMode");


    private final String word;

    /**
     * Initializes the UiConfigWords enum with a specific reserved word.
     *
     * @param word the string representation of the reserved word associated with the UI configuration.
     */
    UiConfigWords(final String word) {
        this.word = word;
    }

    /**
     * Retrieves the string representation of the reserved word associated with the enum instance.
     *
     * @return the string value of the reserved word.
     */
    public String val() {
        return word;
    }
}
