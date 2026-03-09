package com.miasoftnanus.automation.core.configuration.properties.bootstrap;

import com.miasoftnanus.automation.core.configuration.properties.adapter.in.controller.ReadPropertiesFileUiController;
import com.miasoftnanus.automation.core.configuration.properties.adapter.out.infrastructure.properties.JavaReadPropertiesFileUiRepository;
import com.miasoftnanus.automation.core.configuration.properties.application.port.in.ReadPropertiesFileUiUseCase;
import com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure.ReadPropertiesFileUiRepository;
import com.miasoftnanus.automation.core.configuration.properties.application.service.ReadPropertiesFileUiService;
import com.miasoftnanus.automation.core.configuration.properties.model.UiConfig;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * Manages the user interface (UI) configuration by loading and providing access to
 * a singleton instance of {@link UiConfig}.
 * <p>
 * This class uses the singleton design pattern to ensure that only one instance of
 * {@code UiConfigManager} exists during the application's lifecycle. It initializes
 * the {@link UiConfig} by leveraging a repository and service layer to read the
 * configuration file specified by the application.
 * </p>
 * <p>
 * The initialization process includes:
 * - Reading the UI configuration properties file using a repository implementation.
 * - Transforming the properties into a {@link UiConfig} object via a use case and controller.
 * </p>
 * <p>
 * Usage of this class ensures consistent access to UI-related configuration throughout
 * the application. It is particularly useful in scenarios where UI settings, such as
 * browser type, timeouts, or resolution, are required.
 * </p>
 */
@Data
@Accessors(fluent = true)
public final class UiConfigManager {
    private static UiConfigManager instance;
    private final UiConfig uiConfig;

    /**
     * Constructs a new instance of the {@code UiConfigManager} class, initializing the UI.
     */
    private UiConfigManager() {
        ReadPropertiesFileUiRepository readPropertiesFileUiRepository = new JavaReadPropertiesFileUiRepository();
        ReadPropertiesFileUiUseCase readPropertiesFileUiUseCase =
                new ReadPropertiesFileUiService(readPropertiesFileUiRepository);
        var readPropertiesFileUiController = new ReadPropertiesFileUiController(readPropertiesFileUiUseCase);
        this.uiConfig = readPropertiesFileUiController.readPropertiesFile(ConfigManagerWords.UI_PROPERTY_FILE_PATH.val());
    }

    /**
     * Retrieves the singleton instance of the {@code UiConfigManager} class. If no instance
     * currently exists, a new instance is created using lazy initialization. This method
     * ensures a single, globally accessible instance of the configuration manager throughout
     * the application lifecycle.
     *
     * @return the singleton instance of {@code UiConfigManager}, providing access to
     * the UI configuration settings.
     */
    public static UiConfigManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UiConfigManager();
        }
        return instance;
    }
}
