package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.application.port.out.infrastructure.ReadEnvironmentApiJsonFileRepository;
import com.miasoftnanus.automation.core.environment.model.EnvironmentApi;

import java.util.List;

import static com.miasoftnanus.automation.core.utils.json.JsonFileReader.loadJsonStringFromFile;
import static com.miasoftnanus.automation.core.utils.json.JsonParser.fromJsonStringToList;

/**
 * Implementation of the {@link ReadEnvironmentApiJsonFileRepository} interface that uses Gson
 * for JSON deserialization to read and parse environment API configurations from a JSON file.
 * <p>
 * This class provides functionality for loading a JSON file containing environment API configurations,
 * deserializing it into a list of {@link EnvironmentApiGsonEntity} objects using Gson, and mapping these
 * entities to domain model objects of type {@link EnvironmentApi}.
 * </p>
 * <p>
 * The implementation leverages the static methods {@code loadJsonStringFromFile}, {@code fromJsonStringToList},
 * and {@link EnvironmentApiMapper} to perform the following steps:
 * </p>
 * <ul>
 * - Read and load the JSON content as a string from the specified file path.
 * - Deserialize the JSON string into a list of {@link EnvironmentApiGsonEntity} objects.
 * - Map the deserialized entities to domain model objects of type {@link EnvironmentApi}.
 * </ul>
 */
public class GsonReadEnvironmentApiJsonFileRepository implements ReadEnvironmentApiJsonFileRepository {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<EnvironmentApi> readJsonFile(String environmentFilePath) {
        String environmentUiJsonAsString = loadJsonStringFromFile(environmentFilePath);
        List<EnvironmentApiGsonEntity> environmentUiGsonEntities =
                fromJsonStringToList(environmentUiJsonAsString, EnvironmentApiGsonEntity.class);
        return EnvironmentApiMapper.toModel(environmentUiGsonEntities);
    }
}
