package com.miasoftnanus.automation.core.api.application.service.post;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    void post_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";

        ApiResponse expected = new ApiResponse(201, "{\"created\":true}");
        when(postRepository.post(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = postService.post(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(postRepository).post(apiRequest, endpoint);
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    void post_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";

        RuntimeException boom = new RuntimeException("boom");
        when(postRepository.post(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> postService.post(apiRequest, endpoint))
                .isSameAs(boom);

        verify(postRepository).post(apiRequest, endpoint);
        verifyNoMoreInteractions(postRepository);
    }
}

