package com.miasoftnanus.automation.core.api.adapter.in.rest.post;

import com.miasoftnanus.automation.core.api.application.port.in.post.PostFormParamsBasicAuthenticationUseCase;
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
class PostFormParamsBasicAuthenticationControllerTest {

    @Mock
    private PostFormParamsBasicAuthenticationUseCase postFormParamsBasicAuthenticationUseCase;

    @InjectMocks
    private PostFormParamsBasicAuthenticationController controller;

    @Test
    void postFormParamsBasicAuthentication_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(201, "created");

        when(postFormParamsBasicAuthenticationUseCase.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenReturn(expected);

        ApiResponse actual = controller.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(postFormParamsBasicAuthenticationUseCase)
                .postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postFormParamsBasicAuthenticationUseCase);
    }

    @Test
    void postFormParamsBasicAuthentication_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        RuntimeException boom = new RuntimeException("boom");

        when(postFormParamsBasicAuthenticationUseCase.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenThrow(boom);

        assertThatThrownBy(() -> controller.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(postFormParamsBasicAuthenticationUseCase)
                .postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postFormParamsBasicAuthenticationUseCase);
    }
}

