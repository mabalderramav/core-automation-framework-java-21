package com.miasoftnanus.automation.core.api.application.service.delete;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.DeleteRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteServiceTest {

    @Mock
    private DeleteRepository deleteRepository;

    @InjectMocks
    private DeleteService deleteService;

    @Test
    void delete_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource/1";

        ApiResponse expected = new ApiResponse(204, "");
        when(deleteRepository.delete(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = deleteService.delete(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(deleteRepository).delete(apiRequest, endpoint);
        verifyNoMoreInteractions(deleteRepository);
    }

    @Test
    void delete_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource/1";

        RuntimeException boom = new RuntimeException("boom");
        when(deleteRepository.delete(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> deleteService.delete(apiRequest, endpoint))
                .isSameAs(boom);

        verify(deleteRepository).delete(apiRequest, endpoint);
        verifyNoMoreInteractions(deleteRepository);
    }
}

