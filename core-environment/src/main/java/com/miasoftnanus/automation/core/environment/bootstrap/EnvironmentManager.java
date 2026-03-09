package com.miasoftnanus.automation.core.environment.bootstrap;

import com.miasoftnanus.automation.core.environment.adapter.in.rest.ReadEnvironmentJsonFileController;
import com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson.GsonReadEnvironmentJsonFileRepository;
import com.miasoftnanus.automation.core.environment.application.port.in.ReadEnvironmentJsonFileUseCase;
import com.miasoftnanus.automation.core.environment.application.port.out.infrastructure.ReadEnvironmentJsonFileRepository;
import com.miasoftnanus.automation.core.environment.application.service.ReadEnvironmentJsonFileService;
import com.miasoftnanus.automation.core.environment.model.Environment;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Abstract class for managing environment configurations.
 * Provides an initialization mechanism for parsing and loading environments from a JSON file.
 * This class facilitates the integration of repository, service, and controller layers to handle
 * environment configuration data in a structured and extensible manner.
 *
 * <p>
 * Subclasses of EnvironmentManager can build upon the base functionality to extend configuration
 * management for specific use cases.
 * </p>
 */
@Data
@Accessors(fluent = true)
public abstract class EnvironmentManager {
    protected List<Environment> environments;
    protected final Environment environment;
    protected final String environmentFilePath;

    /**
     * Constructs a new instance of the {@code EnvironmentManager} class, initializing the environment
     * configuration based on the provided environment name and file path.
     * <p>
     * This constructor initializes the environment data by orchestrating the repository, service, and
     * controller layers for reading and parsing the environment configuration JSON file.
     *
     * @param environmentName     the name of the environment to be managed.
     * @param environmentFilePath the file path to the JSON file containing environment configuration.
     */
    protected EnvironmentManager(final String environmentName, final String environmentFilePath) {
        ReadEnvironmentJsonFileRepository readEnvironmentJsonFileRepository =
                new GsonReadEnvironmentJsonFileRepository();
        ReadEnvironmentJsonFileUseCase readEnvironmentJsonFileUseCase =
                new ReadEnvironmentJsonFileService(readEnvironmentJsonFileRepository);
        ReadEnvironmentJsonFileController readEnvironmentJsonFileController =
                new ReadEnvironmentJsonFileController(readEnvironmentJsonFileUseCase);
        this.environments = readEnvironmentJsonFileController.readJsonFile(environmentFilePath);
        this.environmentFilePath = environmentFilePath;
        this.environment = environments.stream()
                .filter(env -> env.name().equalsIgnoreCase(environmentName))
                .findFirst()
                .orElse(new Environment());
    }
}
