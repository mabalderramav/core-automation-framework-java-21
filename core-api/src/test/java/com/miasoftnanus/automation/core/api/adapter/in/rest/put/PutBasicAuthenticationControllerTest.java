package com.miasoftnanus.automation.core.api.adapter.in.rest.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutBasicAuthenticationUseCase;
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
class PutBasicAuthenticationControllerTest {

    @Mock
    private PutBasicAuthenticationUseCase putBasicAuthenticationUseCase;

    @InjectMocks
    private PutBasicAuthenticationController controller;

    @Test
    void putBasicAuthentication_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(200, "updated");

        when(putBasicAuthenticationUseCase.putBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenReturn(expected);

        ApiResponse actual = controller.putBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(putBasicAuthenticationUseCase).putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putBasicAuthenticationUseCase);
    }

    @Test
    void putBasicAuthentication_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        RuntimeException boom = new RuntimeException("boom");

        when(putBasicAuthenticationUseCase.putBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenThrow(boom);

        assertThatThrownBy(() -> controller.putBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(putBasicAuthenticationUseCase).putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putBasicAuthenticationUseCase);
    }
}

