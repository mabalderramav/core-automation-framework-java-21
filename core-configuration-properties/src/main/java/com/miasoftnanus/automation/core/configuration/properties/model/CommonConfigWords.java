package com.miasoftnanus.automation.core.configuration.properties.model;

/**
 * Enum representing commonly reserved words used in the application's configuration.
 * This is used to centralize and manage common word constants to avoid duplication
 * or hardcoding across the application.
 */
public enum CommonConfigWords {
    ENVIRONMENT_FILE_PATH("environment.filePath"),
    ENVIRONMENT_NAME("environment.name");

    private final String word;

    /**
     * Initializes a reserved word in the CommonWords enum.
     *
     * @param word the string representation of the reserved word.
     */
    CommonConfigWords(String word) {
        this.word = word;
    }

    /**
     * Retrieves the string representation of the reserved word associated with the enum.
     *
     * @return the string representation of the reserved word.
     */
    public String val() {
        return word;
    }
}
