package com.miasoftnanus.automation.core.environment.adapter.out.persistence.gson;

import com.miasoftnanus.automation.core.environment.application.port.out.persistence.ReadEnvironmentJsonFileRepository;
import com.miasoftnanus.automation.core.environment.model.Environment;

import java.util.List;

import static com.miasoftnanus.automation.core.utils.json.JsonFileReader.loadJsonStringFromFile;
import static com.miasoftnanus.automation.core.utils.json.JsonParser.fromJsonStringToList;

/**
 * A concrete implementation of the {@link ReadEnvironmentJsonFileRepository} interface that uses Gson to read, parse,
 * and map environment configuration data from a JSON file into {@link Environment} model objects.
 *
 * <p>
 * This class provides functionality to:
 * - Load the contents of a JSON file as a string.
 * - Deserialize the JSON string into a list of {@link EnvironmentGsonEntity} objects.
 * - Map the entities into {@link Environment} model objects using {@link EnvironmentMapper}.
 * </p>
 *
 * <p>
 * Gson is used for JSON deserialization operations, configured to handle entities annotated with
 * Gson-specific annotations like {@link com.google.gson.annotations.SerializedName}.
 * This implementation is designed to process a JSON file where environments are serialized as a list of such entities.
 * </p>
 */
public class GsonReadEnvironmentJsonFileRepository implements ReadEnvironmentJsonFileRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Environment> readEnvironmentJsonFile(String environmentFilePath) {
        String environmentJsonAsString = loadJsonStringFromFile(environmentFilePath);
        List<EnvironmentGsonEntity> environmentGsonEntities =
                fromJsonStringToList(environmentJsonAsString, EnvironmentGsonEntity.class);
        return EnvironmentMapper.toModel(environmentGsonEntities);
    }
}
