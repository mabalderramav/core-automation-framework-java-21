package com.miasoftnanus.automation.core.api.adapter.in.rest.delete;

import com.miasoftnanus.automation.core.api.application.port.in.delete.DeleteBasicAuthenticationUseCase;
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
class DeleteBasicAuthenticationControllerTest {

    @Mock
    private DeleteBasicAuthenticationUseCase deleteBasicAuthenticationUseCase;

    @InjectMocks
    private DeleteBasicAuthenticationController controller;

    @Test
    void deleteBasicAuthentication_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        ApiResponse expected = new ApiResponse(204, "");
        when(deleteBasicAuthenticationUseCase.deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenReturn(expected);

        ApiResponse actual = controller.deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(deleteBasicAuthenticationUseCase).deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(deleteBasicAuthenticationUseCase);
    }

    @Test
    void deleteBasicAuthentication_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        RuntimeException boom = new RuntimeException("boom");
        when(deleteBasicAuthenticationUseCase.deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .thenThrow(boom);

        assertThatThrownBy(() -> controller.deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(deleteBasicAuthenticationUseCase).deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(deleteBasicAuthenticationUseCase);
    }
}

