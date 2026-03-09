package com.miasoftnanus.automation.core.configuration.properties.bootstrap;

import com.miasoftnanus.automation.core.configuration.properties.adapter.in.controller.ReadPropertiesFileApiController;
import com.miasoftnanus.automation.core.configuration.properties.adapter.out.infrastructure.properties.JavaReadPropertiesFileApiRepository;
import com.miasoftnanus.automation.core.configuration.properties.application.port.in.ReadPropertiesFileApiUseCase;
import com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure.ReadPropertiesFileApiRepository;
import com.miasoftnanus.automation.core.configuration.properties.application.service.ReadPropertiesFileApiService;
import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfig;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

import static com.miasoftnanus.automation.core.configuration.properties.bootstrap.ConfigManagerWords.API_PROPERTY_FILE_PATH;

/**
 * Singleton class responsible for managing API configuration settings. This class provides a
 * centralized access point to load and retrieve the {@link ApiConfig} object, which contains
 * configuration details such as API name, version, authentication type, and user type.
 * <p>
 * The {@code ApiConfigManager} ensures that the API configuration is loaded only once during
 * the application lifecycle from a specified properties file. The configuration is loaded
 * using a layered approach, involving a repository, service, and controller to facilitate
 * abstraction and separation of concerns.
 * </p>
 * <p>
 * This class is designed to be thread-safe in terms of lazy initialization of its singleton
 * instance, ensuring that the configuration is consistently loaded and accessed across the
 * application.
 * </p>
 */
@Data
@Accessors(fluent = true)
public final class ApiConfigManager {
    private static ApiConfigManager instance;
    private final ApiConfig apiConfig;

    /**
     * Constructs a new instance of the {@code ApiConfigManager} class, initializing the API.
     */
    private ApiConfigManager() {
        ReadPropertiesFileApiRepository readPropertiesFileApiRepository = new JavaReadPropertiesFileApiRepository();
        ReadPropertiesFileApiUseCase readPropertiesFileApiUseCase =
                new ReadPropertiesFileApiService(readPropertiesFileApiRepository);
        var readPropertiesFileApiController = new ReadPropertiesFileApiController(readPropertiesFileApiUseCase);
        this.apiConfig = readPropertiesFileApiController.readPropertiesFile(API_PROPERTY_FILE_PATH.val());
    }

    /**
     * Retrieves the singleton instance of the {@code ApiConfigManager} class. If no instance
     * currently exists, a new instance is created using lazy initialization. This method
     * ensures a single, globally accessible instance of the configuration manager throughout
     * the application lifecycle.
     *
     * @return the singleton instance of {@code ApiConfigManager}, providing access to
     * the API configuration settings.
     */
    public static ApiConfigManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ApiConfigManager();
        }
        return instance;
    }
}
