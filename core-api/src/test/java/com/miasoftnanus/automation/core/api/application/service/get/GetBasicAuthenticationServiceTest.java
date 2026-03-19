package com.miasoftnanus.automation.core.api.application.service.get;

import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
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
class GetBasicAuthenticationServiceTest {

    @Mock
    private GetRepository getRepository;

    @InjectMocks
    private GetBasicAuthenticationService service;

    @Test
    void getBasicAuthentication_delegatesToRepositoryAndReturnsResponse() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        ApiResponse expected = new ApiResponse(200, "{\"ok\":true}");
        when(getRepository.getBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ApiResponse actual = service.getBasicAuthentication(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(getRepository).getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(getRepository);
    }

    @Test
    void getBasicAuthentication_propagatesRepositoryException() {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/auth/basic";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");

        RuntimeException boom = new RuntimeException("boom");
        when(getRepository.getBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenThrow(boom);

        assertThatThrownBy(() -> service.getBasicAuthentication(apiRequest, endpoint, basicAuthentication))
                .isSameAs(boom);

        verify(getRepository).getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(getRepository);
    }
}

