package com.miasoftnanus.automation.core.api.adapter.in.rest.get;

import com.miasoftnanus.automation.core.api.application.port.in.get.GetUseCase;
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
class GetControllerTest {

    @Mock
    private GetUseCase getUseCase;

    @InjectMocks
    private GetController controller;

    @Test
    void get_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        ApiResponse expected = new ApiResponse(200, "response-body");

        when(getUseCase.get(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = controller.get(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(getUseCase).get(apiRequest, endpoint);
        verifyNoMoreInteractions(getUseCase);
    }

    @Test
    void get_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        RuntimeException boom = new RuntimeException("boom");

        when(getUseCase.get(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> controller.get(apiRequest, endpoint))
                .isSameAs(boom);

        verify(getUseCase).get(apiRequest, endpoint);
        verifyNoMoreInteractions(getUseCase);
    }
}

