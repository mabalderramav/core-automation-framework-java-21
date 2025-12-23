package com.miasoftnanus.automation.core.ui.bootstrap.config;

/**
 * Custom reserved words enum.
 */
public enum ReservedWords {
    BROWSER("browser"),
    ENVIRONMENT_NAME("environmentName"),
    EXPLICIT_TIME("explicitTimeWait"),
    IMPLICIT_TIME("implicitTimeWait"),
    PAGE_LOAD_TIME("pageLoadTimeWait"),
    SLEEP_TIME("sleepWaitTime"),
    CHROME_DRIVER_VERSION("chromeDriverVersion"),
    WIDTH("width"),
    HEIGHT("height"),
    DOWNLOADS("downloads"),
    BROWSER_LOGS("browserLogs"),
    SELENIUM_HUB_URL("seleniumHubUrl"),
    SELENIUM_HUB_PORT("seleniumHubPort"),
    INCOGNITO_MODE("incognitoMode");


    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    ReservedWords(final String word) {
        this.word = word;
    }

    /**
     * Gets the enum word value.
     *
     * @return original word.
     */
    public String val() {
        return word;
    }
}
