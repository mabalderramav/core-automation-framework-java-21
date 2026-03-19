package com.miasoftnanus.automation.core.api.adapter.in.rest.get;

import com.miasoftnanus.automation.core.api.application.port.in.get.GetBasicAuthenticationUseCase;
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
class GetBasicAuthenticationControllerTest {

    @Mock
    private GetBasicAuthenticationUseCase getBasicAuthenticationUseCase;

    @InjectMocks
    private GetBasicAuthenticationController controller;

    @Test
    void getBasicAuthentication_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(200, "response-body");

        when(getBasicAuthenticationUseCase.getBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenReturn(expected);

        ApiResponse actual = controller.getBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(getBasicAuthenticationUseCase).getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(getBasicAuthenticationUseCase);
    }

    @Test
    void getBasicAuthentication_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        RuntimeException boom = new RuntimeException("boom");

        when(getBasicAuthenticationUseCase.getBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenThrow(boom);

        assertThatThrownBy(() -> controller.getBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(getBasicAuthenticationUseCase).getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(getBasicAuthenticationUseCase);
    }
}

