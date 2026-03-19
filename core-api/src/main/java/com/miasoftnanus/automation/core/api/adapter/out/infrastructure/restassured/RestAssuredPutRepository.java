package com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * RestAssuredPutRepository is an implementation of PutRepository that uses RestAssured
 * to perform PUT requests.
 */
public class RestAssuredPutRepository extends RestAssuredRepository implements PutRepository {
    private Response response;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse put(ApiRequest apiRequest, String endpoint) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params())
                .body(apiRequest.body())
                .put(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse putBasicAuthentication(ApiRequest apiRequest, String endpoint, BasicAuthentication basicAuthentication) {
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
                .put(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse putFormDataBasicAuthentication(ApiRequest apiRequest, String endpoint, BasicAuthentication basicAuthentication) {
        RequestSpecification reqSpec = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(basicAuthentication.username(), basicAuthentication.password())
                .relaxedHTTPSValidation()
                .when()
                .headers(apiRequest.headers())
                .queryParams(apiRequest.params());
        addMultiParts(reqSpec, apiRequest);
        response = reqSpec.put(endpoint);
        return new ApiResponse(response.statusCode(), response.body().asString());
    }
}
