package com.miasoftnanus.automation.core.api.application.service.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * Service for sending POST requests.
 * This service implements the {@link PostUseCase} interface
 * to handle the logic of sending a POST request.
 */
@RequiredArgsConstructor
public class PostService implements PostUseCase {
    private final PostRepository postRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse post(final ApiRequest apiRequest, final String endpoint) {
        return postRepository.post(apiRequest, endpoint);
    }
}
