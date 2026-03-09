package com.miasoftnanus.automation.core.configuration.properties.model;

/**
 * Enum representing reserved words used for API configuration.
 * This is used to centralize and manage key constants specific to API-related configurations
 * such as API names, versions, and authentication properties. It helps ensure consistency
 * and eliminates hardcoding of these values across the application.
 */
public enum ApiConfigWords {
    API_NAME("api.name"),
    API_VERSION_NAME("api.versionName"),
    API_AUTHENTICATION_TYPE("api.authenticationType"),
    API_AUTHENTICATION_USER_TYPE("api.authenticationUserType");

    private final String word;

    /**
     * Initializes an instance of the ApiConfigWords enum with the specified reserved word.
     *
     * @param word the string representation of the reserved word associated with the API configuration.
     */
    ApiConfigWords(final String word) {
        this.word = word;
    }

    /**
     * Retrieves the string representation of the reserved word associated with this enum instance.
     *
     * @return the string value of the reserved word.
     */
    public String val() {
        return word;
    }
}
