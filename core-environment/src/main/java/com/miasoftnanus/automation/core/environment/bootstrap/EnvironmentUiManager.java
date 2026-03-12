package com.miasoftnanus.automation.core.environment.bootstrap;

import com.miasoftnanus.automation.core.environment.adapter.in.controller.ReadEnvironmentUiJsonFileController;
import com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson.GsonReadEnvironmentUiJsonFileRepository;
import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentUiJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.application.port.out.infrastructure.ReadEnvironmentUiJsonFileRepository;
import com.miasoftnanus.automation.core.environment.application.service.ReadEnvironmentUiJsonFileService;
import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;
import com.miasoftnanus.automation.core.environment.model.Portal;
import com.miasoftnanus.automation.core.environment.model.User;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Objects;

import static com.miasoftnanus.automation.core.environment.bootstrap.EnvironmentManagerWords.UI_ENVIRONMENT_JSON_FILE_PATH;

/**
 * Manages the UI environment configuration and provides access to details such as the portal,
 * user, and environment-specific settings.
 *
 * <p>
 * This class extends {@code EnvironmentManager} to specialize environment management for
 * UI-related configurations. It facilitates the initialization and retrieval of a
 * singleton instance of {@code UiEnvironmentManager}, ensuring a single point of access
 * throughout the application.
 * </p>
 */
@Data
@Accessors(fluent = true)
public class EnvironmentUiManager {
    private static EnvironmentUiManager instance;
    private List<EnvironmentUi> environmentUis;
    private EnvironmentUi environmentUi;
    private User user;
    private Portal portal;
    private String portalWeb;
    private String userType;

    /**
     * Constructs a new instance of the {@code UiEnvironmentManager} class, initializing the
     * UI environment configuration with the specified portal, user type, and environment file path.
     *
     * <p>
     * This constructor retrieves and sets the associated environment, portal, and user objects
     * based on their respective names and types provided as parameters. Fallback objects
     * are created with default values if no matching entities are found.
     * </p>
     *
     * @param environmentName     the name of the environment to be managed.
     * @param portalWeb           the name of the portal within the environment.
     * @param userType            the type of user to be associated with the environment.
     * @param environmentFilePath the file path to the JSON file containing environment configuration.
     */
    private EnvironmentUiManager(final String environmentName,
                                 final String portalWeb,
                                 final String userType,
                                 final String environmentFilePath) {
        init(environmentName, portalWeb, userType, environmentFilePath);
    }

    /**
     * Constructs a new instance of the {@code EnvironmentUiManager} class, initializing the
     * UI environment with the specified portal, user type, and environment name.
     * <p>
     * This constructor retrieves and assigns the associated portal and user objects
     * based on the provided portal name and user type. It initializes the base
     * environment configuration using the file path for UI environments.
     * </p>
     *
     * @param environmentName the name of the environment to be managed.
     * @param portalWeb       the name of the portal within the environment.
     * @param userType        the type of user to be associated with the environment.
     */
    private EnvironmentUiManager(final String environmentName,
                                 final String portalWeb,
                                 final String userType) {
        init(environmentName, portalWeb, userType, UI_ENVIRONMENT_JSON_FILE_PATH.val());
    }

    private void init(final String environmentName,
                      final String portalWeb,
                      final String userType,
                      final String environmentFilePath) {
        ReadEnvironmentUiJsonFileRepository readEnvironmentUiJsonFileRepository =
                new GsonReadEnvironmentUiJsonFileRepository();
        ReadEnvironmentUiJsonFileUseCase readEnvironmentUiJsonFileUseCase =
                new ReadEnvironmentUiJsonFileService(readEnvironmentUiJsonFileRepository);
        ReadEnvironmentUiJsonFileController readEnvironmentUiJsonFileController =
                new ReadEnvironmentUiJsonFileController(readEnvironmentUiJsonFileUseCase);
        this.environmentUis = readEnvironmentUiJsonFileController.readJsonFile(environmentFilePath);
        this.environmentUi = environmentUis.stream()
                .filter(env -> env.name().equalsIgnoreCase(environmentName))
                .findFirst()
                .orElse(new EnvironmentUi());
        this.portalWeb = portalWeb;
        this.userType = userType;
        this.portal = getPortal(portalWeb);
        this.user = getUser(userType);
    }

    /**
     * Resets the singleton instance of the {@code EnvironmentUiManager} class.
     * <p>
     * This method sets the static instance variable to {@code null}, allowing the {@link #getInstance(String, String, String, String)}
     * method to create and return a new instance when invoked again. It is typically used in test scenarios or when a fresh
     * instance is required.
     * </p>
     */
    public static void resetInstance() {
        instance = null;
    }

    private User getUser(String userType) {
        return portal.users().stream()
                .filter(userEnv -> userEnv.type().equalsIgnoreCase(userType))
                .findFirst()
                .orElse(new User());
    }

    private Portal getPortal(String portalWeb) {
        return environmentUi.portals().stream()
                .filter(portalEnv -> portalEnv.name().equalsIgnoreCase(portalWeb))
                .findFirst()
                .orElse(new Portal());
    }

    /**
     * Retrieves the singleton instance of the {@code UiEnvironmentManager} class. If an instance does not already exist,
     * a new instance is created using the provided parameters.
     *
     * @param environmentName     the name of the environment to be managed.
     * @param portalWeb           the name of the portal within the environment.
     * @param userType            the type of user to be associated with the environment.
     * @param environmentFilePath the file path to the JSON file containing environment configuration.
     * @return the singleton instance of {@code UiEnvironmentManager}.
     */
    public static synchronized EnvironmentUiManager getInstance(final String environmentName,
                                                                final String portalWeb,
                                                                final String userType,
                                                                final String environmentFilePath) {
        if (Objects.isNull(instance)) {
            instance = new EnvironmentUiManager(environmentName, portalWeb, userType, environmentFilePath);
        }

        return instance;
    }

    /**
     * Retrieves the singleton instance of the {@code EnvironmentUiManager} class.
     * If an instance does not already exist, a new instance is created using
     * the provided parameters.
     *
     * @param environmentName the name of the environment to be managed.
     * @param portalWeb       the name of the portal within the environment.
     * @param userType        the type of user to be associated with the environment.
     * @return the singleton instance of {@code EnvironmentUiManager}.
     */
    public static synchronized EnvironmentUiManager getInstance(final String environmentName,
                                                                final String portalWeb,
                                                                final String userType) {
        if (Objects.isNull(instance)) {
            instance = new EnvironmentUiManager(environmentName, portalWeb, userType);
        }

        return instance;
    }
}
