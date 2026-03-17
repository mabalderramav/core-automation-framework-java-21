package com.miasoftnanus.automation.core.api.application.service.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostFormParamsBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Service for sending POST requests with form parameters and basic authentication.
 * This service implements the {@link PostFormParamsBasicAuthenticationUseCase} interface
 * to handle the logic of sending a POST request with form parameters and basic authentication.
 */
@RequiredArgsConstructor
public class PostFormParamsBasicAuthenticationService implements PostFormParamsBasicAuthenticationUseCase {
    private final PostRepository postRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postFormParamsBasicAuthentication(final ApiRequest apiRequest,
                                                         final String endpoint,
                                                         final BasicAuthentication basicAuthentication) {
        return postRepository.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
