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

class RestAssuredPostRepositoryTest {

    @Test
    void post_shouldReturnApiResponseWithStatusAndBody() {
        // Arrange
        final RestAssuredPostRepository repository = new RestAssuredPostRepository();
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
        when(requestSpecification.post(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(200);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("ok");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.post(apiRequest, endpoint);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(200);
            assertThat(apiResponse.body()).isEqualTo("ok");

            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).body(apiRequest.body());
            verify(requestSpecification).post(endpoint);
        }
    }

    @Test
    void postBasicAuthentication_shouldUseCredentialsAndReturnApiResponse() {
        // Arrange
        final RestAssuredPostRepository repository = new RestAssuredPostRepository();
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

        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.auth()).thenReturn(authenticationSpecification);
        when(authenticationSpecification.preemptive()).thenReturn(preemptiveAuthSpec);
        when(preemptiveAuthSpec.basic(basicAuthentication.username(), basicAuthentication.password()))
                .thenReturn(requestSpecification);

        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(apiRequest.headers())).thenReturn(requestSpecification);
        when(requestSpecification.queryParams(apiRequest.params())).thenReturn(requestSpecification);
        when(requestSpecification.body(apiRequest.body())).thenReturn(requestSpecification);
        when(requestSpecification.post(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(201);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("created");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.postBasicAuthentication(apiRequest, endpoint, basicAuthentication);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(201);
            assertThat(apiResponse.body()).isEqualTo("created");

            verify(preemptiveAuthSpec).basic("user", "pass");
            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).body(apiRequest.body());
            verify(requestSpecification).post(endpoint);
        }
    }

    @Test
    void postFormParamsBasicAuthentication_shouldUseFormParamsAndReturnApiResponse() {
        // Arrange
        final RestAssuredPostRepository repository = new RestAssuredPostRepository();
        final ApiRequest apiRequest = new ApiRequest()
                .headers(Map.of("X-Header", "value"))
                .params(Map.of("p", "1"));
        final String endpoint = "https://example.test/resource";
        final BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        final RequestSpecification requestSpecification = mock(RequestSpecification.class);
        final AuthenticationSpecification authenticationSpecification = mock(AuthenticationSpecification.class);
        final PreemptiveAuthSpec preemptiveAuthSpec = mock(PreemptiveAuthSpec.class);

        final Response response = mock(Response.class);
        final ResponseBody<?> responseBody = mock(ResponseBody.class);

        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.auth()).thenReturn(authenticationSpecification);
        when(authenticationSpecification.preemptive()).thenReturn(preemptiveAuthSpec);
        when(preemptiveAuthSpec.basic(basicAuthentication.username(), basicAuthentication.password()))
                .thenReturn(requestSpecification);

        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(apiRequest.headers())).thenReturn(requestSpecification);
        when(requestSpecification.formParams(apiRequest.params())).thenReturn(requestSpecification);
        when(requestSpecification.post(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(200);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("ok");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(200);
            assertThat(apiResponse.body()).isEqualTo("ok");

            verify(preemptiveAuthSpec).basic("user", "pass");
            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).formParams(apiRequest.params());
            verify(requestSpecification).post(endpoint);
        }
    }

    @Test
    void postFormDataBasicAuthentication_shouldAddMultiPartsAndReturnApiResponse() {
        // Arrange
        final RestAssuredPostRepository repository = new RestAssuredPostRepository();
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

        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.auth()).thenReturn(authenticationSpecification);
        when(authenticationSpecification.preemptive()).thenReturn(preemptiveAuthSpec);
        when(preemptiveAuthSpec.basic(basicAuthentication.username(), basicAuthentication.password()))
                .thenReturn(requestSpecification);

        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(apiRequest.headers())).thenReturn(requestSpecification);
        when(requestSpecification.queryParams(apiRequest.params())).thenReturn(requestSpecification);

        // addMultiParts(...) calls reqSpec.multiPart(...)
        when(requestSpecification.multiPart(anyString(), anyString(), anyString())).thenReturn(requestSpecification);
        when(requestSpecification.post(endpoint)).thenReturn(response);

        when(response.statusCode()).thenReturn(202);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.asString()).thenReturn("accepted");

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            final ApiResponse apiResponse = repository.postFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);

            // Assert
            assertThat(apiResponse.statusCode()).isEqualTo(202);
            assertThat(apiResponse.body()).isEqualTo("accepted");

            verify(preemptiveAuthSpec).basic("user", "pass");
            verify(requestSpecification).headers(apiRequest.headers());
            verify(requestSpecification).queryParams(apiRequest.params());
            verify(requestSpecification).multiPart("field", "value", "text/plain");
            verify(requestSpecification).post(endpoint);
        }
    }

    @Test
    void post_shouldPropagateExceptionFromRestAssured() {
        // Arrange
        final RestAssuredPostRepository repository = new RestAssuredPostRepository();
        final ApiRequest apiRequest = new ApiRequest();
        final String endpoint = "https://example.test/resource";

        final RequestSpecification requestSpecification = mock(RequestSpecification.class);
        when(requestSpecification.relaxedHTTPSValidation()).thenReturn(requestSpecification);
        when(requestSpecification.when()).thenReturn(requestSpecification);
        when(requestSpecification.headers(anyMap())).thenReturn(requestSpecification);
        when(requestSpecification.queryParams(anyMap())).thenReturn(requestSpecification);
        when(requestSpecification.body(anyString())).thenReturn(requestSpecification);
        when(requestSpecification.post(anyString())).thenThrow(new RuntimeException("boom"));

        try (MockedStatic<RestAssured> restAssured = org.mockito.Mockito.mockStatic(RestAssured.class)) {
            restAssured.when(RestAssured::given).thenReturn(requestSpecification);

            // Act
            RuntimeException thrown = null;
            try {
                repository.post(apiRequest, endpoint);
            } catch (RuntimeException ex) {
                thrown = ex;
            }

            // Assert
            assertThat(thrown).isNotNull();
            assertThat(thrown).hasMessage("boom");
        }
    }
}

