package com.miasoftnanus.automation.core.api.application.port.in.post;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

/**
 * Interface for sending POST requests with form parameters and basic authentication.
 * This interface extends the basic functionality of sending POST requests with form parameters
 * while ensuring that the request is authenticated using basic authentication.
 */
public interface PostFormParamsBasicAuthenticationUseCase {
    /**
     * Sends POST request with form parameters and basic authentication.
     *
     * @param apiRequest          request object.
     * @param endpoint            webservice endpoint.
     * @param basicAuthentication basic authentication.
     * @return response data.
     */
    ApiResponse postFormParamsBasicAuthentication(final ApiRequest apiRequest,
                                                  final String endpoint,
                                                  final BasicAuthentication basicAuthentication);
}
