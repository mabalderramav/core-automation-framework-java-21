package com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.DeleteRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Implementation of DeleteRepository using RestAssured for sending DELETE requests.
 */
public class RestAssuredDeleteRepository implements DeleteRepository {
    private Response response;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse delete(final ApiRequest apiRequest, final String endpoint) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params())
                .delete(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse deleteBasicAuthentication(final ApiRequest apiRequest,
                                                 final String endpoint,
                                                 final BasicAuthentication basicAuthentication) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .auth()
                .preemptive()
                .basic(basicAuthentication.username(), basicAuthentication.password())
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params())
                .delete(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }
}
