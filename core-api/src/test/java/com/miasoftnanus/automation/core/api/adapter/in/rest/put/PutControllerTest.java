package com.miasoftnanus.automation.core.api.adapter.in.rest.put;

import com.miasoftnanus.automation.core.api.application.port.in.put.PutUseCase;
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
class PutControllerTest {

    @Mock
    private PutUseCase putUseCase;

    @InjectMocks
    private PutController controller;

    @Test
    void put_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        ApiResponse expected = new ApiResponse(200, "updated");

        when(putUseCase.put(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = controller.put(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(putUseCase).put(apiRequest, endpoint);
        verifyNoMoreInteractions(putUseCase);
    }

    @Test
    void put_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        RuntimeException boom = new RuntimeException("boom");

        when(putUseCase.put(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> controller.put(apiRequest, endpoint))
                .isSameAs(boom);

        verify(putUseCase).put(apiRequest, endpoint);
        verifyNoMoreInteractions(putUseCase);
    }
}

