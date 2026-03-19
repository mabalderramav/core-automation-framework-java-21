package com.miasoftnanus.automation.core.api.adapter.in.rest.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostUseCase postUseCase;

    @InjectMocks
    private PostController controller;

    @Test
    void post_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        ApiResponse expected = new ApiResponse(201, "created");

        when(postUseCase.post(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = controller.post(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(postUseCase).post(apiRequest, endpoint);
        verifyNoMoreInteractions(postUseCase);
    }

    @Test
    void post_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        RuntimeException boom = new RuntimeException("boom");

        when(postUseCase.post(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> controller.post(apiRequest, endpoint))
                .isSameAs(boom);

        verify(postUseCase).post(apiRequest, endpoint);
        verifyNoMoreInteractions(postUseCase);
    }
}

