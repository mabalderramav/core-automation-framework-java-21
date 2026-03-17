package com.miasoftnanus.automation.core.api.application.service.get;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
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
class GetServiceTest {

    @Mock
    private GetRepository getRepository;

    @InjectMocks
    private GetService getService;

    @Test
    void get_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource/1";

        ApiResponse expected = new ApiResponse(200, "{\"id\":1}");
        when(getRepository.get(apiRequest, endpoint)).thenReturn(expected);

        ApiResponse actual = getService.get(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(getRepository).get(apiRequest, endpoint);
        verifyNoMoreInteractions(getRepository);
    }

    @Test
    void get_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource/1";

        RuntimeException boom = new RuntimeException("boom");
        when(getRepository.get(apiRequest, endpoint)).thenThrow(boom);

        assertThatThrownBy(() -> getService.get(apiRequest, endpoint))
                .isSameAs(boom);

        verify(getRepository).get(apiRequest, endpoint);
        verifyNoMoreInteractions(getRepository);
    }
}

