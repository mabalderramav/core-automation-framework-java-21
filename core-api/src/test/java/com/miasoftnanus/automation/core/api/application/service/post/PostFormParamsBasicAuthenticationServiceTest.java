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
class PostFormParamsBasicAuthenticationServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostFormParamsBasicAuthenticationService service;

    @Test
    void postFormParamsBasicAuthentication_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/form";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        ApiResponse expected = new ApiResponse(201, "{\"created\":true}");
        when(postRepository.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ApiResponse actual = service.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(postRepository).postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    void postFormParamsBasicAuthentication_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/form";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        RuntimeException boom = new RuntimeException("boom");
        when(postRepository.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenThrow(boom);

        assertThatThrownBy(() -> service.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(postRepository).postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postRepository);
    }
}

