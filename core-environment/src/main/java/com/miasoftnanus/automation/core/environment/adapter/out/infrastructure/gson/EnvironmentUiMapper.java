package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.EnvironmentUi;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Utility class for mapping environment-related UI data structures between different representations.
 * This class is designed to handle conversions between {@link EnvironmentUiGsonEntity} and {@link EnvironmentUi}.
 *
 * <p>
 * The mapping operations provided facilitate seamless transformation of data received or sent in JSON format
 * to internal model representations or vice versa, ensuring consistent handling of environment UI configurations.
 * </p>
 *
 * <p>
 * This class is not meant to be instantiated and contains only static methods. The constructor is private
 * to enforce its utility-focused design.
 * </p>
 */
class EnvironmentUiMapper {

    /**
     * Private constructor to prevent instantiation of the {@code EnvironmentUiMapper} utility class.
     */
    private EnvironmentUiMapper() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Converts an {@link EnvironmentUiGsonEntity} object to an {@link Optional} containing an {@link EnvironmentUi} model object.
     * If the input entity is null, an empty {@link Optional} is returned.
     *
     * @param entity the {@link EnvironmentUiGsonEntity} object to be converted. Maybe null.
     * @return an {@link Optional} containing the converted {@link EnvironmentUi} model object,
     *         or an empty {@link Optional} if the input entity is null.
     */
    static Optional<EnvironmentUi> toModel(final EnvironmentUiGsonEntity entity) {
        if (Objects.isNull(entity)) {
            return Optional.empty();
        }

        final EnvironmentUi uiModel = new EnvironmentUi();
        uiModel.name(entity.name());
        uiModel.portals(PortalMapper.tolModel(entity.portals()));

        return Optional.of(uiModel);
    }

    /**
     * Converts a list of {@link EnvironmentUiGsonEntity} objects into a list of {@link EnvironmentUi} model objects.
     * Only non-empty {@link EnvironmentUi} objects resulting from the conversion are included in the resulting list.
     *
     * @param entities a list of {@link EnvironmentUiGsonEntity} objects to be converted. Must not be null but may be empty.
     * @return a list of {@link EnvironmentUi} model objects derived from the input entities. The list is empty if
     *         none of the entities successfully convert to a {@link EnvironmentUi} object.
     */
    static List<EnvironmentUi> toModel(final List<EnvironmentUiGsonEntity> entities) {
        return entities.stream()
                .map(EnvironmentUiMapper::toModel)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
