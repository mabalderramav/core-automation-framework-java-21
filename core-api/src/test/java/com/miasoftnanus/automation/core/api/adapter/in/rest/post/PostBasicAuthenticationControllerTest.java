package com.miasoftnanus.automation.core.api.adapter.in.rest.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
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
class PostBasicAuthenticationControllerTest {

    @Mock
    private PostBasicAuthenticationUseCase postBasicAuthenticationUseCase;

    @InjectMocks
    private PostBasicAuthenticationController controller;

    @Test
    void postBasicAuthentication_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(201, "created");

        when(postBasicAuthenticationUseCase.postBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenReturn(expected);

        ApiResponse actual = controller.postBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(postBasicAuthenticationUseCase).postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postBasicAuthenticationUseCase);
    }

    @Test
    void postBasicAuthentication_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        RuntimeException boom = new RuntimeException("boom");

        when(postBasicAuthenticationUseCase.postBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenThrow(boom);

        assertThatThrownBy(() -> controller.postBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(postBasicAuthenticationUseCase).postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postBasicAuthenticationUseCase);
    }
}

