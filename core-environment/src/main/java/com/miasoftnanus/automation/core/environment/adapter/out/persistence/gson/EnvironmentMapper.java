package com.miasoftnanus.automation.core.environment.adapter.out.persistence.gson;

import com.miasoftnanus.automation.core.environment.model.Environment;

import java.util.List;
import java.util.Optional;

/**
 * A utility class for mapping between environment-related entity and model objects.
 * This class provides static methods to transform data from {@link EnvironmentGsonEntity}
 * objects into {@link Environment} model objects and vice versa, supporting both single object
 * and list transformations.
 *
 * <p>
 * This class is not meant to be instantiated and serves solely as a utility. The constructor is private to enforce this restriction.
 * </p>
 */
class EnvironmentMapper {

    /**
     * A utility class for mapping between different environment-related data
     * structures, typically used for converting entities to models or vice versa.
     * <p>
     * This class is not meant to be instantiated. The constructor is private to
     * enforce its utility nature.
     * </p>
     */
    private EnvironmentMapper() {
        // Private constructor.
    }

    /**
     * Converts an {@link EnvironmentGsonEntity} object into an {@link Optional} containing an {@link Environment} model object.
     * If the input entity is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link EnvironmentGsonEntity} object to be converted. Can be null.
     * @return an {@link Optional} containing the converted {@link Environment} model object,
     * or an empty {@link Optional} if the input entity is null.
     */
    static Optional<Environment> toModel(final EnvironmentGsonEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        final Environment model = new Environment();
        model.name(entity.name());
        model.portals(PortalMapper.tolModel(entity.portals()));
        model.apis(ApiMapper.toApiModel(entity.apis()));

        return Optional.of(model);
    }

    /**
     * Converts a list of {@link EnvironmentGsonEntity} objects to a list of {@link Environment} model objects.
     * Each {@link EnvironmentGsonEntity} is mapped to an {@link Environment}, and null or invalid mappings are excluded.
     * Only valid {@link Environment} objects are included in the resulting list.
     *
     * @param entities the list of {@link EnvironmentGsonEntity} objects to be converted.
     *                 Each entity is processed to generate an equivalent {@link Environment} model.
     *                 The list must not be null, but it may contain null elements.
     * @return a list of {@link Environment} model objects corresponding to the input entities.
     * The resulting list excludes null or invalid environments.
     */
    static List<Environment> toModel(final List<EnvironmentGsonEntity> entities) {
        return entities.stream()
                .map(EnvironmentMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
