package com.miasoftnanus.automation.core.ui.model;

/**
 * Driver types enum.
 */
public enum WebDriverTypes {
    LOCALLY("LOCALLY"),
    DOCKER("DOCKER"),
    REMOTE("REMOTE");

    private final String word;

    /**
     * Initializes WebDriver types enum.
     *
     * @param word original word.
     */
    WebDriverTypes(final String word) {
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
