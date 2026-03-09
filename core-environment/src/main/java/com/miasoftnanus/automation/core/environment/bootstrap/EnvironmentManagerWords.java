package com.miasoftnanus.automation.core.environment.bootstrap;

/**
 * Represents configuration file paths used for managing environment settings.
 * This enumeration defines constants for specifying file paths to JSON configuration
 * files for API and UI environments.
 *
 * Each constant is associated with a specific file path string, which can be retrieved
 * using the {@code val()} method. These constants are used to locate the respective
 * environment configuration files during the initialization process.
 */
public enum EnvironmentManagerWords {
    API_ENVIRONMENT_JSON_FILE_PATH("./src/test/resources/EnvironmentApi.json"),
    UI_ENVIRONMENT_JSON_FILE_PATH("./src/test/resources/EnvironmentUi.json");

    private final String word;

    /**
     * Constructs an instance of {@code EnvironmentManagerWords} with a specific word value.
     *
     * @param word the string value representing the environment configuration identifier or file path.
     */
    private EnvironmentManagerWords(String word) {
        this.word = word;
    }

    /**
     * Retrieves the string value associated with the current enumeration constant.
     *
     * @return the string value representing the environment configuration identifier or file path.
     */
    public String val() {
        return word;
    }
}
