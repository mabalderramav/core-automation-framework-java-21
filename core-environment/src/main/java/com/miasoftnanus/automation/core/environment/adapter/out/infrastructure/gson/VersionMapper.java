package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.Version;

import java.util.List;
import java.util.Optional;

class VersionMapper {

    /**
     * A utility class for mapping version-related data structures.
     * This class is designed to provide methods for converting between
     * {@link VersionGsonEntity} and {@link Version} model objects.
     * <p>The constructor is private to prevent instantiation, as this class
     * only provides static utility methods.</p>
     */
    private VersionMapper() {
        // Prevent instantiation.
    }

    /**
     * Converts a {@link VersionGsonEntity} object to an {@link Optional} containing a {@link Version} model object.
     * If the input entity is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link VersionGsonEntity} object to be converted. Maybe null.
     * @return an {@link Optional} containing the converted {@link Version} model object,
     * or an empty {@link Optional} if the input entity is null.
     */
    static Optional<Version> toModel(final VersionGsonEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        Version model = new Version();
        model.name(entity.name());
        model.pathVersion(entity.version());
        return Optional.of(model);
    }

    /**
     * Converts a list of {@link VersionGsonEntity} objects to a list of {@link Version} model objects.
     * Each {@link VersionGsonEntity} is mapped to a {@link Version}, and null values are excluded.
     * Only valid {@link Version} objects are included in the resulting list.
     *
     * @param entities the list of {@link VersionGsonEntity} objects to be converted.
     *                 Each entity is processed to generate an equivalent {@link Version} model.
     * @return a list of {@link Version} model objects corresponding to the input entities.
     * The list excludes null values and ensures only valid versions are included.
     */
    static List<Version> toModel(final List<VersionGsonEntity> entities) {
        return entities.stream()
                .map(VersionMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
