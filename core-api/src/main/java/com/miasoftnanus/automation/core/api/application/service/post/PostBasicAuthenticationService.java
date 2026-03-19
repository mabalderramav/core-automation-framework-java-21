package com.miasoftnanus.automation.core.api.application.service.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Service for sending POST requests with basic authentication.
 * This service implements the {@link PostBasicAuthenticationUseCase} interface
 * to handle the logic of sending a POST request with basic authentication.
 */
@RequiredArgsConstructor
public class PostBasicAuthenticationService implements PostBasicAuthenticationUseCase {
    private final PostRepository postRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postBasicAuthentication(final ApiRequest apiRequest,
                                               final String endpoint,
                                               final BasicAuthentication basicAuthentication) {
        return postRepository.postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
