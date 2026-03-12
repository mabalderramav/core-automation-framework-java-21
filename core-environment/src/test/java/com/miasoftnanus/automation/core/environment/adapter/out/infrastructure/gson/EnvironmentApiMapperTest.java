package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.EnvironmentApi;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentApiMapperTest {

    @Test
    void toModel_NullEntity_ReturnsEmptyOptional() {
        // Act
        Optional<EnvironmentApi> result = EnvironmentApiMapper.toModel((EnvironmentApiGsonEntity) null);

        // Assert
        assertTrue(result.isEmpty(), "Expected Optional to be empty when input entity is null");
    }

    @Test
    void toModel_ValidEntity_ReturnsPopulatedOptionalAndMapsFields() {
        // Arrange
        ApiGsonEntity api = new ApiGsonEntity()
                .name("MyApi")
                .baseUrl("https://example.test")
                .versions(List.of())
                .authentications(List.of());

        EnvironmentApiGsonEntity entity = new EnvironmentApiGsonEntity()
                .name("QA")
                .apis(List.of(api));

        // Act
        Optional<EnvironmentApi> result = EnvironmentApiMapper.toModel(entity);

        // Assert
        assertTrue(result.isPresent(), "Expected Optional to contain a value for a valid entity");
        EnvironmentApi env = result.get();
        assertEquals("QA", env.name(), "Environment name should match the entity name");

        assertNotNull(env.apis(), "Apis list should not be null");
        assertEquals(1, env.apis().size(), "Apis list size should match");
        assertEquals("MyApi", env.apis().getFirst().name(), "Nested API name should be mapped");
        assertEquals("https://example.test", env.apis().getFirst().baseUrl(), "Nested API baseUrl should be mapped");
    }

    @Test
    @SuppressWarnings("DataFlowIssue")
    void toModel_NullList_ThrowsNullPointerException() {

        // Act + Assert
        assertThrows(NullPointerException.class,
                () -> EnvironmentApiMapper.toModel((List<EnvironmentApiGsonEntity>) null),
                "Expected NullPointerException because the contract states the input list must not be null");
    }

    @Test
    void toModel_EmptyList_ReturnsEmptyList() {
        // Act
        List<EnvironmentApi> result = EnvironmentApiMapper.toModel(List.of());

        // Assert
        assertNotNull(result, "Expected a non-null list when input list is empty");
        assertTrue(result.isEmpty(), "Expected an empty list when input list is empty");
    }

    @Test
    void toModel_ListWithNullElements_FiltersNulls() {
        // Arrange
        EnvironmentApiGsonEntity valid = new EnvironmentApiGsonEntity()
                .name("Valid")
                .apis(List.of());

        List<EnvironmentApiGsonEntity> entities = Arrays.asList(null, valid, null);

        // Act
        List<EnvironmentApi> result = EnvironmentApiMapper.toModel(entities);

        // Assert
        assertEquals(1, result.size(), "Expected only non-null entities to be mapped");
        assertEquals("Valid", result.getFirst().name(), "Mapped EnvironmentApi should come from the valid entity");
    }
}

