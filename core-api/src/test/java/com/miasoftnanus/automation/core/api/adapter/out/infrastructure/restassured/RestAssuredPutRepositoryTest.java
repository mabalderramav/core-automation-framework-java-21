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

class RestAssuredPutRepositoryTest {

    @Test
    void put_shouldReturnApiResponseWithStatusAndBody() {
        // Arrange
        final RestAssuredPutRepository repository = new RestAssuredPutRepository();
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
        when(requestSpecification.put(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(200);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("updated");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.put(apiRequest, endpoint);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(200);
            assertThat(apiResponse.body()).isEqualTo("updated");

            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).body(apiRequest.body());
            verify(requestSpecification).put(endpoint);
        }
    }

    @Test
    void putBasicAuthentication_shouldUseCredentialsAndReturnApiResponse() {
        // Arrange
        final RestAssuredPutRepository repository = new RestAssuredPutRepository();
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
        when(requestSpecification.put(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(201);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("saved");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.putBasicAuthentication(apiRequest, endpoint, basicAuthentication);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(201);
            assertThat(apiResponse.body()).isEqualTo("saved");

            verify(preemptiveAuthSpec).basic("user", "pass");
            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).body(apiRequest.body());
            verify(requestSpecification).put(endpoint);
        }
    }

    @Test
    void putFormDataBasicAuthentication_shouldAddMultiPartsAndReturnApiResponse() {
        // Arrange
        final RestAssuredPutRepository repository = new RestAssuredPutRepository();
        final ApiRequest apiRequest = new ApiRequest()
                .headers(Map.of("X-Header", "value"))
                .params(Map.of("param", "1"))
                .formData(Map.of("field", "value"));
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
        when(requestSpecification.multiPart(anyString(), anyString(), anyString())).thenReturn(requestSpecification);
        when(requestSpecification.put(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(202);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("accepted");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(202);
            assertThat(apiResponse.body()).isEqualTo("accepted");

            verify(preemptiveAuthSpec).basic("user", "pass");
            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).multiPart("field", "value", "text/plain");
            verify(requestSpecification).put(endpoint);
        }
    }

    @Test
    void put_shouldPropagateExceptionFromRestAssured() {
        // Arrange
        final RestAssuredPutRepository repository = new RestAssuredPutRepository();
        final ApiRequest apiRequest = new ApiRequest();
        final String endpoint = "https://example.test/resource";

        final RequestSpecification requestSpecification = mock(RequestSpecification.class);
        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(anyMap())).thenReturn(requestSpecification);
        when(requestSpecification.queryParams(anyMap())).thenReturn(requestSpecification);
        when(requestSpecification.body(anyString())).thenReturn(requestSpecification);
        when(requestSpecification.put(anyString())).thenThrow(new RuntimeException("boom"));

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            RuntimeException thrown = null;
            try {
                repository.put(apiRequest, endpoint);
            } catch (RuntimeException ex) {
                thrown = ex;
            }

            // Assert
            assertThat(thrown).isNotNull();
            assertThat(thrown).hasMessage("boom");
        }
    }
}

