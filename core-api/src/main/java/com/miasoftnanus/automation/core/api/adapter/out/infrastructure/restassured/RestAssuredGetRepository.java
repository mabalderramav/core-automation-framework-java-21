package com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Implementation of GetRepository using RestAssured for sending GET requests.
 * This class provides methods to send GET requests to a web service endpoint,
 * with or without basic authentication.
 */
public class RestAssuredGetRepository implements GetRepository {
    private Response response;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse get(final ApiRequest apiRequest, final String endpoint) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params())
                .body(apiRequest.body())
                .get(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse getBasicAuthentication(final ApiRequest apiRequest,
                                              final String endpoint,
                                              final BasicAuthentication basicAuthentication) {
        response = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(basicAuthentication.username(), basicAuthentication.password())
                .relaxedHTTPSValidation()
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params())
                .body(apiRequest.body())
                .get(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }
}
