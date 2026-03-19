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
class PutFormDataBasicAuthenticationServiceTest {

    @Mock
    private PutRepository putRepository;

    @InjectMocks
    private PutFormDataBasicAuthenticationService service;

    @Test
    void putFormDataBasicAuthentication_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/form";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        ApiResponse expected = new ApiResponse(200, "{\"updated\":true}");
        when(putRepository.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ApiResponse actual = service.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(putRepository).putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putRepository);
    }

    @Test
    void putFormDataBasicAuthentication_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/form";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        RuntimeException boom = new RuntimeException("boom");
        when(putRepository.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenThrow(boom);

        assertThatThrownBy(() -> service.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(putRepository).putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putRepository);
    }
}

