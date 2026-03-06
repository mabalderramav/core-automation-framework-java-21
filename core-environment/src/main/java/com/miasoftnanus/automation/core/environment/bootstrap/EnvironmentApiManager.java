package com.miasoftnanus.automation.core.environment.bootstrap;

import com.miasoftnanus.automation.core.environment.model.Api;
import com.miasoftnanus.automation.core.environment.model.Authentication;
import com.miasoftnanus.automation.core.environment.model.User;
import com.miasoftnanus.automation.core.environment.model.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * Manages the configuration and initialization of an API within a specific environment.
 * This class extends the functionality of the {@code EnvironmentManager} class to
 * include API-specific details such as API name, version, authentication type, and user type.
 * <p>
 * The {@code EnvironmentApiManager} class is designed to provide a centralized mechanism
 * for getting API-related configurations, authentication methods, and a user associated
 * with the specified authentication type. This ensures a structured approach to managing
 * API integrations within various environments.
 * </p>
 * <p>
 * Features of the {@code EnvironmentApiManager} include:
 * - Retrieving and initializing an API based on its name.
 * - Fetching the relevant authentication mechanism for the specified type.
 * - Associating a user with the corresponding authentication type.
 * </p>
 * <p>
 * This class enforces a singleton design pattern to ensure only one instance
 * of the {@code EnvironmentApiManager} is created per configuration.
 * </p>
 */
@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class EnvironmentApiManager extends EnvironmentManager {
    private static EnvironmentApiManager instance;
    private final String apiName;
    private final String versionName;
    private final String authenticationType;
    private final String authenticationUserType;
    private final Api api;
    private final Authentication authentication;
    private final User user;
    private final Version version;

    /**
     * Initializes a new instance of the {@code EnvironmentApiManager} class, which manages
     * API-specific configurations within a specified environment.
     *
     * @param environmentName        the name of the environment to be managed.
     * @param apiName                the name of the API to be retrieved and managed within the environment.
     * @param versionName            the version of the API to be managed.
     * @param authenticationType     the type of authentication to be used for API access.
     * @param authenticationUserType the specific user type associated with the authentication mechanism.
     * @param environmentFilePath    the file path to the JSON file containing the environment configurations.
     */
    private EnvironmentApiManager(final String environmentName,
                                  final String apiName,
                                  final String versionName,
                                  final String authenticationType,
                                  final String authenticationUserType,
                                  final String environmentFilePath) {
        super(environmentName, environmentFilePath);
        this.apiName = apiName;
        this.versionName = versionName;
        this.authenticationType = authenticationType;
        this.authenticationUserType = authenticationUserType;
        this.api = getApi(apiName);
        this.authentication = getAuthentication(authenticationType);
        this.user = getUser(authenticationUserType);
        this.version = getVersion(versionName);
    }

    /**
     * Retrieves a {@code Version} object based on the specified version name.
     * This method filters the list of available versions and returns the first version
     * that matches the provided name (case-insensitive). If no match is found, a
     * default {@code Version} instance is returned.
     *
     * @param versionName the name of the version to retrieve, used for filtering
     *                    the list of available versions.
     * @return the {@code Version} instance matching the specified name, or a
     *         default {@code Version} instance if no match is found.
     */
    private Version getVersion(final String versionName) {
        return api.versions().stream()
                .filter(versionEnv -> versionEnv.name().equalsIgnoreCase(versionName))
                .findFirst()
                .orElse(new Version());
    }

    /**
     * Retrieves a {@code User} object based on the specified authentication user type.
     * This method filters the list of users and returns the first user that matches
     * the given type. If no match is found, a default {@code User} instance is returned.
     *
     * @param authenticationUserType the type of the user to retrieve, used for filtering the list of users.
     * @return the {@code User} instance matching the specified type, or a default {@code User} instance if no match is found.
     */
    private User getUser(final String authenticationUserType) {
        return authentication.users().stream()
                .filter(userEnv -> userEnv.type().equalsIgnoreCase(authenticationUserType))
                .findFirst()
                .orElse(new User());
    }

    /**
     * Retrieves an {@code Authentication} object based on the specified authentication type.
     * This method filters the list of available authentications and returns the first one
     * that matches the provided type. If no match is found, a default {@code Authentication}
     * instance is returned.
     *
     * @param authenticationType the type of authentication to retrieve, used for filtering
     *                           the list of available authentications.
     * @return the {@code Authentication} instance matching the specified type, or a default
     * {@code Authentication} instance if no match is found.
     */
    private Authentication getAuthentication(final String authenticationType) {
        return api.authentications().stream()
                .filter(authEnv -> authEnv.type().equalsIgnoreCase(authenticationType))
                .findFirst()
                .orElse(new Authentication());
    }

    /**
     * Retrieves an {@code Api} instance based on the specified API name from the list of available APIs
     * in the current environment. If no API with the given name is found, a default {@code Api} instance
     * is returned.
     *
     * @param apiName the name of the API to retrieve, used for filtering the list of available APIs.
     * @return the {@code Api} instance matching the specified name, or a default {@code Api} instance
     * if no match is found.
     */
    private Api getApi(final String apiName) {
        return environment.apis().stream()
                .filter(apiEnv -> apiEnv.name().equalsIgnoreCase(apiName))
                .findFirst()
                .orElse(new Api());
    }

    /**
     * Resets the singleton instance of the {@code EnvironmentApiManager} to {@code null}.
     * This method is typically used to allow the reinitialization of the singleton instance
     * with new configuration parameters or to release the current instance for cleanup purposes.
     *
     * Note: Calling this method without reinitializing the instance using {@code getInstance}
     * may result in {@code NullPointerException} if other methods depending on the instance
     * are invoked afterward.
     */
    public static void resetInstance() {
        instance = null;
    }

    /**
     * Provides a singleton instance of the {@code EnvironmentApiManager} class.
     * This method ensures that only one instance of the class is created and reused
     * throughout the application, managing API-specific configurations within a specified
     * environment.
     *
     * @param environmentName        the name of the environment to be managed.
     * @param apiName                the name of the API to be retrieved and managed within the environment.
     * @param versionName            the version of the API to be managed.
     * @param authenticationType     the type of authentication to be used for API access.
     * @param authenticationUserType the specific user type associated with the authentication mechanism.
     * @param environmentFilePath    the file path to the JSON file containing the environment configurations.
     * @return the singleton instance of {@code EnvironmentApiManager}.
     */
    public static EnvironmentApiManager getInstance(final String environmentName,
                                                    final String apiName,
                                                    final String versionName,
                                                    final String authenticationType,
                                                    final String authenticationUserType,
                                                    final String environmentFilePath) {
        if (Objects.isNull(instance)) {
            instance = new EnvironmentApiManager(environmentName, apiName, versionName, authenticationType,
                    authenticationUserType, environmentFilePath);
        }

        return instance;
    }
}
