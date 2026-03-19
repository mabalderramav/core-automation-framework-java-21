package com.miasoftnanus.automation.core.api.adapter.in.rest.delete;

import com.miasoftnanus.automation.core.api.application.port.in.delete.DeleteUseCase;
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
class DeleteControllerTest {

    @Mock
    private DeleteUseCase deleteUseCase;

    @InjectMocks
    private DeleteController controller;

    @Test
    void delete_delegatesToUseCaseAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        ApiResponse expected = new ApiResponse(204, "");

        when(deleteUseCase.delete(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = controller.delete(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(deleteUseCase).delete(apiRequest, endpoint);
        verifyNoMoreInteractions(deleteUseCase);
    }

    @Test
    void delete_propagatesUseCaseException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        RuntimeException boom = new RuntimeException("boom");

        when(deleteUseCase.delete(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> controller.delete(apiRequest, endpoint))
                .isSameAs(boom);

        verify(deleteUseCase).delete(apiRequest, endpoint);
        verifyNoMoreInteractions(deleteUseCase);
    }
}

