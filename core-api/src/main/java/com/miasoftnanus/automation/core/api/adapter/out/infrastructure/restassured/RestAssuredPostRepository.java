package com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Implementation of PostRepository using RestAssured for sending POST requests.
 * This class provides methods to send POST requests to a web service endpoint,
 * with or without basic authentication, and supports form parameters and form data.
 */
public class RestAssuredPostRepository extends RestAssuredRepository implements PostRepository {
    private Response response;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse post(final ApiRequest apiRequest, final String endpoint) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params())
                .body(apiRequest.body())
                .post(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postBasicAuthentication(final ApiRequest apiRequest,
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
                .body(apiRequest.body())
                .post(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postFormParamsBasicAuthentication(final ApiRequest apiRequest,
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
                .formParams(apiRequest.params())
                .post(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postFormDataBasicAuthentication(ApiRequest apiRequest, String endpoint, BasicAuthentication basicAuthentication) {
        RequestSpecification reqSpec = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .auth()
                .preemptive()
                .basic(basicAuthentication.username(), basicAuthentication.password())
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params());
        addMultiParts(reqSpec, apiRequest);
        response = reqSpec.post(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }
}
