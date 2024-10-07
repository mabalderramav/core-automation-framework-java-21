package com.miasoftnanus.automation.core.ui.config;

/**
 * Custom reserved words enum.
 */
enum UiConfigWords {
    BROWSER("browser"),
    ENVIRONMENT_NAME("environmentName"),
    EXPLICIT_TIME_WAIT("explicitTimeWait"),
    IMPLICIT_TIME_WAIT("implicitTimeWait"),
    PAGE_LOAD_TIME_WAIT("pageLoadTimeWait"),
    SLEEP_WAIT_TIME("sleepWaitTime"),
    CHROME_DRIVER_VERSION("chromeDriverVersion"),
    WIDTH("width"),
    HEIGHT("height"),
    HEADLESS_MODE("headlessMode");

    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    UiConfigWords(final String word) {
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
