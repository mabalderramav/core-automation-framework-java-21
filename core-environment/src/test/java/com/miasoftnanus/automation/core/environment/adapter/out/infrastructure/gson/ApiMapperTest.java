package com.miasoftnanus.automation.core.environment.adapter.out.infrastructure.gson;

import com.miasoftnanus.automation.core.environment.model.Api;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ApiMapperTest {

    @Test
    void toApiModel_NullEntity_ReturnsEmptyOptional() {
        // Act
        Optional<Api> result = ApiMapper.toApiModel((ApiGsonEntity) null);

        // Assert
        assertTrue(result.isEmpty(), "Expected Optional to be empty when input entity is null");
    }

    @Test
    void toApiModel_ValidEntity_ReturnsPopulatedOptionalAndMapsFields() {
        // Arrange
        VersionGsonEntity version = new VersionGsonEntity()
                .name("VersionOne")
                .version("v1");

        UserGsonEntity user = new UserGsonEntity()
                .type("DEFAULT")
                .username("john")
                .password("secret");

        AuthenticationGsonEntity authentication = new AuthenticationGsonEntity()
                .type("BASIC")
                .users(List.of(user));

        ApiGsonEntity entity = new ApiGsonEntity()
                .name("MyApi")
                .baseUrl("https://example.test")
                .versions(List.of(version))
                .authentications(List.of(authentication));

        // Act
        Optional<Api> result = ApiMapper.toApiModel(entity);

        // Assert
        assertTrue(result.isPresent(), "Expected Optional to contain a value for a valid entity");
        Api api = result.get();
        assertEquals("MyApi", api.name(), "API name should match the entity name");
        assertEquals("https://example.test", api.baseUrl(), "API baseUrl should match the entity baseUrl");

        assertNotNull(api.versions(), "Versions list should not be null");
        assertEquals(1, api.versions().size(), "Versions list size should match");
        assertEquals("VersionOne", api.versions().getFirst().name(), "Version name should match");
        assertEquals("v1", api.versions().getFirst().pathVersion(), "Version path should match");

        assertNotNull(api.authentications(), "Authentications list should not be null");
        assertEquals(1, api.authentications().size(), "Authentications list size should match");
        assertEquals("BASIC", api.authentications().getFirst().type(), "Authentication type should match");
        assertNotNull(api.authentications().getFirst().users(), "Authentication users list should not be null");
        assertEquals(1, api.authentications().getFirst().users().size(), "Authentication users list size should match");
        assertEquals("DEFAULT", api.authentications().getFirst().users().getFirst().type(), "User type should match");
        assertEquals("john", api.authentications().getFirst().users().getFirst().username(), "Username should match");
    }

    @Test
    void toApiModel_NullList_ReturnsEmptyList() {
        // Act
        List<Api> result = ApiMapper.toApiModel((List<ApiGsonEntity>) null);

        // Assert
        assertNotNull(result, "Expected a non-null list when input list is null");
        assertTrue(result.isEmpty(), "Expected an empty list when input list is null");
    }

    @Test
    void toApiModel_EmptyList_ReturnsEmptyList() {
        // Act
        List<Api> result = ApiMapper.toApiModel(List.of());

        // Assert
        assertNotNull(result, "Expected a non-null list when input list is empty");
        assertTrue(result.isEmpty(), "Expected an empty list when input list is empty");
    }

    @Test
    void toApiModel_ListWithNullElements_FiltersNulls() {
        // Arrange
        ApiGsonEntity valid = new ApiGsonEntity()
                .name("Valid")
                .baseUrl("http://localhost")
                .versions(List.of())
                .authentications(List.of());

        List<ApiGsonEntity> entities = Arrays.asList(null, valid, null);

        // Act
        List<Api> result = ApiMapper.toApiModel(entities);

        // Assert
        assertEquals(1, result.size(), "Expected only non-null entities to be mapped");
        assertEquals("Valid", result.getFirst().name(), "Mapped API should come from the valid entity");
    }
}


