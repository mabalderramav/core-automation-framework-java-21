package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;


import com.miasoftnanus.automation.core.environment.model.EnvironmentApi;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Utility class for mapping {@link EnvironmentApiGsonEntity} objects to {@link EnvironmentApi} model objects.
 * <p>
 * This class provides static methods for converting instances of {@link EnvironmentApiGsonEntity},
 * or lists of these instances, into equivalent {@link EnvironmentApi} model objects. It centralizes
 * the mapping logic to ensure consistency and reusability.
 * </p>
 * <p>
 * The constructor is private to emphasize that this class is a utility class and is not meant to be instantiated.
 * </p>
 */
class EnvironmentApiMapper {
    /**
     * Private constructor to prevent instantiation of the {@code EnvironmentApiMapper} utility class.
     */
    private EnvironmentApiMapper() {
        // Private constructor.
    }

    /**
     * Converts an {@link EnvironmentApiGsonEntity} object to an {@link Optional} containing an {@link EnvironmentApi} model object.
     * The method maps fields from the given {@link EnvironmentApiGsonEntity} to their equivalent fields in the {@link EnvironmentApi} object.
     * If the input {@link EnvironmentApiGsonEntity} is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link EnvironmentApiGsonEntity} object to be converted. May be null.
     * @return an {@link Optional} containing the converted {@link EnvironmentApi} model object,
     * or an empty {@link Optional} if the input entity is null.
     */
    static Optional<EnvironmentApi> toModel(final EnvironmentApiGsonEntity entity) {
        if (Objects.isNull(entity)) {
            return Optional.empty();
        }

        final EnvironmentApi model = new EnvironmentApi();
        model.name(entity.name());
        model.apis(ApiMapper.toApiModel(entity.apis()));
        return Optional.of(model);
    }

    /**
     * Converts a list of {@link EnvironmentApiGsonEntity} objects to a list of {@link EnvironmentApi} model objects.
     * The method maps each {@link EnvironmentApiGsonEntity} in the input list to its corresponding {@link EnvironmentApi} object,
     * while filtering out any null or invalid mappings.
     *
     * @param entities the list of {@link EnvironmentApiGsonEntity} objects to be converted. Must not be null.
     * @return a list of {@link EnvironmentApi} model objects corresponding to the input entities.
     * The returned list does not include any null or invalid mappings.
     */
    static List<EnvironmentApi> toModel(final List<EnvironmentApiGsonEntity> entities) {
        return entities.stream()
                .map(EnvironmentApiMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
