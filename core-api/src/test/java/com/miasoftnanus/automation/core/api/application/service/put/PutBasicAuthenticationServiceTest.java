package com.miasoftnanus.automation.core.api.application.service.put;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PutBasicAuthenticationServiceTest {

    @Mock
    private PutRepository putRepository;

    @InjectMocks
    private PutBasicAuthenticationService service;

    @Test
    void putBasicAuthentication_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        ApiResponse expected = new ApiResponse(200, "{\"updated\":true}");
        when(putRepository.putBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ApiResponse actual = service.putBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(putRepository).putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putRepository);
    }

    @Test
    void putBasicAuthentication_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        RuntimeException boom = new RuntimeException("boom");
        when(putRepository.putBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenThrow(boom);

        assertThatThrownBy(() -> service.putBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(putRepository).putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putRepository);
    }
}

