package com.miasoftnanus.automation.core.api.application.service.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostFormDataBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Service for sending POST requests with form data and basic authentication.
 * This service implements the {@link PostFormDataBasicAuthenticationUseCase} interface
 * to handle the logic of sending a POST request with form data and basic authentication.
 */
@RequiredArgsConstructor
public class PostFormDataBasicAuthenticationService implements PostFormDataBasicAuthenticationUseCase {
    private final PostRepository postRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postFormDataBasicAuthentication(final ApiRequest apiRequest,
                                                       final String endpoint,
                                                       final BasicAuthentication basicAuthentication) {
        return postRepository.postFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
