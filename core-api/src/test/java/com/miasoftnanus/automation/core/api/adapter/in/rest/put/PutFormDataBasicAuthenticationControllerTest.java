package com.miasoftnanus.automation.core.api.adapter.in.rest.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutFormDataBasicAuthenticationUseCase;
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
class PutFormDataBasicAuthenticationControllerTest {

    @Mock
    private PutFormDataBasicAuthenticationUseCase putFormDataBasicAuthenticationUseCase;

    @InjectMocks
    private PutFormDataBasicAuthenticationController controller;

    @Test
    void putFormDataBasicAuthentication_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(200, "updated");

        when(putFormDataBasicAuthenticationUseCase.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenReturn(expected);

        ApiResponse actual = controller.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(putFormDataBasicAuthenticationUseCase)
                .putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putFormDataBasicAuthenticationUseCase);
    }

    @Test
    void putFormDataBasicAuthentication_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        RuntimeException boom = new RuntimeException("boom");

        when(putFormDataBasicAuthenticationUseCase.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenThrow(boom);

        assertThatThrownBy(() -> controller.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(putFormDataBasicAuthenticationUseCase)
                .putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putFormDataBasicAuthenticationUseCase);
    }
}

