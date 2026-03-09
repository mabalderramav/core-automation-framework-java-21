package com.miasoftnanus.automation.core.configuration.properties.bootstrap;

/**
 * Enum representing the file paths for configuration properties used within the application.
 * This enum encapsulates the paths to the property files containing settings for different
 * application components, such as UI and API configurations.
 * <p>
 * Each constant in this enum represents a specific predefined file path:
 * - UI_PROPERTY_FILE_PATH: Path to the UI configuration properties file.
 * - API_PROPERTY_FILE_PATH: Path to the API configuration properties file.
 * </p>
 * <p>
 * The primary goal of this enum is to provide a single source of truth for the
 * file paths used to load configuration settings in the application.
 * </p>
 */
public enum ConfigManagerWords {
    UI_PROPERTY_FILE_PATH("./src/test/resources/ui.properties"),
    API_PROPERTY_FILE_PATH("./src/test/resources/api.properties");
    private final String word;

    /**
     * Constructs a new instance of {@code ConfigManagerWords} with the specified word.
     * This private constructor initializes the enum constant with the associated
     * string value representing the configuration file path.
     *
     * @param word the string value associated with the enum constant, typically
     *             representing the file path of a configuration properties file.
     */
    ConfigManagerWords(String word) {
        this.word = word;
    }

    /**
     * Retrieves the string value associated with the enum constant.
     * This value typically represents a predefined file path to a
     * configuration properties file that is used within the application.
     *
     * @return the string value corresponding to the enum constant,
     * which represents a specific configuration file path.
     */
    public String val() {
        return word;
    }
}
