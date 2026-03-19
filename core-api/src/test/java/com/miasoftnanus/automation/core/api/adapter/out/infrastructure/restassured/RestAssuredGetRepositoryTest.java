package com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RestAssuredGetRepositoryTest {

    @Test
    void get_shouldReturnApiResponseWithStatusAndBody() {
        // Arrange
        final RestAssuredGetRepository repository = new RestAssuredGetRepository();
        final ApiRequest apiRequest = new ApiRequest()
                .headers(Map.of("X-Header", "value"))
                .params(Map.of("param", "1"))
                .body("payload");
        final String endpoint = "https://example.test/resource";

        final RequestSpecification requestSpecification = mock(RequestSpecification.class);
        final Response response = mock(Response.class);
        final ResponseBody<?> responseBody = mock(ResponseBody.class);

        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(apiRequest.headers())).thenReturn(requestSpecification);
        when(requestSpecification.queryParams(apiRequest.params())).thenReturn(requestSpecification);
        when(requestSpecification.body(apiRequest.body())).thenReturn(requestSpecification);
        when(requestSpecification.get(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(200);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("ok");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.get(apiRequest, endpoint);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(200);
            assertThat(apiResponse.body()).isEqualTo("ok");

            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).body(apiRequest.body());
            verify(requestSpecification).get(endpoint);
        }
    }

    @Test
    void getBasicAuthentication_shouldUseCredentialsAndReturnApiResponse() {
        // Arrange
        final RestAssuredGetRepository repository = new RestAssuredGetRepository();
        final ApiRequest apiRequest = new ApiRequest()
                .headers(Map.of("X-Header", "value"))
                .params(Map.of("param", "1"))
                .body("payload");
        final String endpoint = "https://example.test/resource";
        final BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        final RequestSpecification requestSpecification = mock(RequestSpecification.class);
        final AuthenticationSpecification authenticationSpecification = mock(AuthenticationSpecification.class);
        final PreemptiveAuthSpec preemptiveAuthSpec = mock(PreemptiveAuthSpec.class);

        final Response response = mock(Response.class);
        final ResponseBody<?> responseBody = mock(ResponseBody.class);

        when(requestSpecification.auth()).thenReturn(authenticationSpecification);
        when(authenticationSpecification.preemptive()).thenReturn(preemptiveAuthSpec);
        when(preemptiveAuthSpec.basic(basicAuthentication.username(), basicAuthentication.password()))
                .thenReturn(requestSpecification);

        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(apiRequest.headers())).thenReturn(requestSpecification);
        when(requestSpecification.queryParams(apiRequest.params())).thenReturn(requestSpecification);
        when(requestSpecification.body(apiRequest.body())).thenReturn(requestSpecification);
        when(requestSpecification.get(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(201);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("created");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.getBasicAuthentication(apiRequest, endpoint, basicAuthentication);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(201);
            assertThat(apiResponse.body()).isEqualTo("created");

            verify(preemptiveAuthSpec).basic("user", "pass");
            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).body(apiRequest.body());
            verify(requestSpecification).get(endpoint);
        }
    }

    @Test
    void get_shouldPropagateExceptionFromRestAssured() {
        // Arrange
        final RestAssuredGetRepository repository = new RestAssuredGetRepository();
        final ApiRequest apiRequest = new ApiRequest();
        final String endpoint = "https://example.test/resource";

        final RequestSpecification requestSpecification = mock(RequestSpecification.class);
        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(anyMap())).thenReturn(requestSpecification);
        when(requestSpecification.queryParams(anyMap())).thenReturn(requestSpecification);
        when(requestSpecification.body(anyString())).thenReturn(requestSpecification);
        when(requestSpecification.get(anyString())).thenThrow(new RuntimeException("boom"));

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            RuntimeException thrown = null;
            try {
                repository.get(apiRequest, endpoint);
            } catch (RuntimeException ex) {
                thrown = ex;
            }

            // Assert
            assertThat(thrown).isNotNull();
            assertThat(thrown).hasMessage("boom");
        }
    }
}

