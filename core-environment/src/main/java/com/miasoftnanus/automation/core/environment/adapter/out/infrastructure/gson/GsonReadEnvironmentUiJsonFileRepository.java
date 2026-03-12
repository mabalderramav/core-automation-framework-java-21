package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.application.port.out.infrastructure.ReadEnvironmentUiJsonFileRepository;
import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;

import java.util.List;

import static com.miasoftnanus.automation.core.utils.json.JsonFileReader.loadJsonStringFromFile;
import static com.miasoftnanus.automation.core.utils.json.JsonParser.fromJsonStringToList;

/**
 * Implementation of the {@link ReadEnvironmentUiJsonFileRepository} interface that reads
 * environment UI configuration data from a JSON file using the Gson library.
 *
 * <p>
 * This class facilitates loading a JSON file from a given path, parsing its content into
 * a list of {@link EnvironmentUiGsonEntity} objects, and mapping them to the domain model
 * representation {@link EnvironmentUi}.
 * </p>
 *
 * <p>
 * The class uses utility methods for JSON file reading and mapping:
 * - {@code loadJsonStringFromFile(String)}: Converts the content of the JSON file into a string.
 * - {@code fromJsonStringToList(String, Class)}: Parses a JSON string into a list of deserialized
 *   objects.
 * - {@code EnvironmentUiMapper.toModel(List)}: Maps the parsed objects to environment model objects.
 * </p>
 *
 * <p>
 * This implementation is designed to ensure proper extraction and conversion of the
 * JSON file's content while adhering to the contract defined by the repository interface.
 * </p>
 */
public class GsonReadEnvironmentUiJsonFileRepository implements ReadEnvironmentUiJsonFileRepository {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<EnvironmentUi> readJsonFile(String environmentFilePath) {
        String environmentUiJsonAsString = loadJsonStringFromFile(environmentFilePath);
        List<EnvironmentUiGsonEntity> environmentUiGsonEntities =
                fromJsonStringToList(environmentUiJsonAsString, EnvironmentUiGsonEntity.class);
        return EnvironmentUiMapper.toModel(environmentUiGsonEntities);
    }
}
