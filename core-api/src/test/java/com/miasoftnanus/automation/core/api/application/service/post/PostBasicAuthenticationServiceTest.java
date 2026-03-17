package com.miasoftnanus.automation.core.api.application.service.post;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostBasicAuthenticationServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostBasicAuthenticationService service;

    @Test
    void postBasicAuthentication_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        ApiResponse expected = new ApiResponse(201, "{\"created\":true}");
        when(postRepository.postBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ApiResponse actual = service.postBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(postRepository).postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    void postBasicAuthentication_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        RuntimeException boom = new RuntimeException("boom");
        when(postRepository.postBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenThrow(boom);

        assertThatThrownBy(() -> service.postBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(postRepository).postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postRepository);
    }
}

