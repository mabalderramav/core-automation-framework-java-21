package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.Version;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VersionMapperTest {

    /**
     * Tests for the {@code toModel} method in {@link VersionMapper}.
     * This method converts a {@link VersionGsonEntity} object into an {@link Optional<Version>} model.
     */

    @Test
    void toModel_NullEntity_ReturnsEmptyOptional() {
        // Act
        Optional<Version> result = VersionMapper.toModel((VersionGsonEntity) null);

        // Assert
        assertTrue(result.isEmpty(), "Expected Optional to be empty when input entity is null");
    }

    @Test
    void toModel_ValidEntity_ReturnsPopulatedOptional() {
        // Arrange
        VersionGsonEntity gsonEntity = new VersionGsonEntity()
                .name("TestVersion")
                .version("1.0");

        // Act
        Optional<Version> result = VersionMapper.toModel(gsonEntity);

        // Assert
        assertTrue(result.isPresent(), "Expected Optional to contain a value for a valid entity");
        Version version = result.get();
        assertEquals("TestVersion", version.name(), "Version name should match the entity name");
        assertEquals("1.0", version.pathVersion(), "Version path should match the entity version");
    }

    @Test
    void toModel_EmptyList_ReturnsEmptyList() {
        // Arrange
        List<VersionGsonEntity> emptyEntities = List.of();

        // Act
        List<Version> result = VersionMapper.toModel(emptyEntities);

        // Assert
        assertTrue(result.isEmpty(), "Expected an empty list when input list is empty");
    }

    @Test
    void toModel_ValidEntitiesList_ReturnsMappedList() {
        // Arrange
        VersionGsonEntity entity1 = new VersionGsonEntity()
                .name("VersionOne")
                .version("1.0");
        VersionGsonEntity entity2 = new VersionGsonEntity()
                .name("VersionTwo")
                .version("2.0");
        List<VersionGsonEntity> entities = List.of(entity1, entity2);

        // Act
        List<Version> result = VersionMapper.toModel(entities);

        // Assert
        assertEquals(2, result.size(), "Expected all valid entities to be converted");
        assertEquals("VersionOne", result.get(0).name(), "First version name should match");
        assertEquals("1.0", result.get(0).pathVersion(), "First version path should match");
        assertEquals("VersionTwo", result.get(1).name(), "Second version name should match");
        assertEquals("2.0", result.get(1).pathVersion(), "Second version path should match");
    }
}