package com.miasoftnanus.automation.core.api.application.service.put;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
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
class PutServiceTest {

    @Mock
    private PutRepository putRepository;

    @InjectMocks
    private PutService putService;

    @Test
    void put_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource/1";

        ApiResponse expected = new ApiResponse(200, "{\"updated\":true}");
        when(putRepository.put(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = putService.put(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(putRepository).put(apiRequest, endpoint);
        verifyNoMoreInteractions(putRepository);
    }

    @Test
    void put_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource/1";

        RuntimeException boom = new RuntimeException("boom");
        when(putRepository.put(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> putService.put(apiRequest, endpoint))
                .isSameAs(boom);

        verify(putRepository).put(apiRequest, endpoint);
        verifyNoMoreInteractions(putRepository);
    }
}

