package com.miasoftnanus.automation.core.api.bootstrap.client;

import com.miasoftnanus.automation.core.api.adapter.in.rest.delete.DeleteBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.get.GetBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostFormDataBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostFormParamsBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.put.PutBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.put.PutFormDataBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.application.service.delete.DeleteBasicAuthenticationService;
import com.miasoftnanus.automation.core.api.application.service.get.GetBasicAuthenticationService;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.DeleteRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
import com.miasoftnanus.automation.core.api.application.service.post.PostBasicAuthenticationService;
import com.miasoftnanus.automation.core.api.application.service.post.PostFormDataBasicAuthenticationService;
import com.miasoftnanus.automation.core.api.application.service.post.PostFormParamsBasicAuthenticationService;
import com.miasoftnanus.automation.core.api.application.service.put.PutBasicAuthenticationService;
import com.miasoftnanus.automation.core.api.application.service.put.PutFormDataBasicAuthenticationService;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class ClientRequestBasicAuthenticationManagerTest {

    @Test
    void get_delegatesToGetBasicAuthenticationControllerAndReturnsResponse() {
        assertDelegationSuccess(
                GetBasicAuthenticationController.class,
                GetBasicAuthenticationService.class,
                GetBasicAuthenticationController::getBasicAuthentication,
                ClientRequestBasicAuthenticationManager::get
        );
    }

    @Test
    void get_propagatesControllerException() {
        assertDelegationFailure(
                GetBasicAuthenticationController.class,
                GetBasicAuthenticationService.class,
                GetBasicAuthenticationController::getBasicAuthentication,
                ClientRequestBasicAuthenticationManager::get
        );
    }

    @Test
    void post_delegatesToPostBasicAuthenticationControllerAndReturnsResponse() {
        assertDelegationSuccess(
                PostBasicAuthenticationController.class,
                PostBasicAuthenticationService.class,
                PostBasicAuthenticationController::postBasicAuthentication,
                ClientRequestBasicAuthenticationManager::post
        );
    }

    @Test
    void post_propagatesControllerException() {
        assertDelegationFailure(
                PostBasicAuthenticationController.class,
                PostBasicAuthenticationService.class,
                PostBasicAuthenticationController::postBasicAuthentication,
                ClientRequestBasicAuthenticationManager::post
        );
    }

    @Test
    void postFormData_delegatesToPostFormDataBasicAuthenticationControllerAndReturnsResponse() {
        assertDelegationSuccess(
                PostFormDataBasicAuthenticationController.class,
                PostFormDataBasicAuthenticationService.class,
                PostFormDataBasicAuthenticationController::postFormDataBasicAuthentication,
                ClientRequestBasicAuthenticationManager::postFormData
        );
    }

    @Test
    void postFormData_propagatesControllerException() {
        assertDelegationFailure(
                PostFormDataBasicAuthenticationController.class,
                PostFormDataBasicAuthenticationService.class,
                PostFormDataBasicAuthenticationController::postFormDataBasicAuthentication,
                ClientRequestBasicAuthenticationManager::postFormData
        );
    }

    @Test
    void postFormParams_delegatesToPostFormParamsBasicAuthenticationControllerAndReturnsResponse() {
        assertDelegationSuccess(
                PostFormParamsBasicAuthenticationController.class,
                PostFormParamsBasicAuthenticationService.class,
                PostFormParamsBasicAuthenticationController::postFormParamsBasicAuthentication,
                ClientRequestBasicAuthenticationManager::postFormParams
        );
    }

    @Test
    void postFormParams_propagatesControllerException() {
        assertDelegationFailure(
                PostFormParamsBasicAuthenticationController.class,
                PostFormParamsBasicAuthenticationService.class,
                PostFormParamsBasicAuthenticationController::postFormParamsBasicAuthentication,
                ClientRequestBasicAuthenticationManager::postFormParams
        );
    }

    @Test
    void put_delegatesToPutBasicAuthenticationControllerAndReturnsResponse() {
        assertDelegationSuccess(
                PutBasicAuthenticationController.class,
                PutBasicAuthenticationService.class,
                PutBasicAuthenticationController::putBasicAuthentication,
                ClientRequestBasicAuthenticationManager::put
        );
    }

    @Test
    void put_propagatesControllerException() {
        assertDelegationFailure(
                PutBasicAuthenticationController.class,
                PutBasicAuthenticationService.class,
                PutBasicAuthenticationController::putBasicAuthentication,
                ClientRequestBasicAuthenticationManager::put
        );
    }

    @Test
    void putFormData_delegatesToPutFormDataBasicAuthenticationControllerAndReturnsResponse() {
        assertDelegationSuccess(
                PutFormDataBasicAuthenticationController.class,
                PutFormDataBasicAuthenticationService.class,
                PutFormDataBasicAuthenticationController::putFormDataBasicAuthentication,
                ClientRequestBasicAuthenticationManager::putFormData
        );
    }

    @Test
    void putFormData_propagatesControllerException() {
        assertDelegationFailure(
                PutFormDataBasicAuthenticationController.class,
                PutFormDataBasicAuthenticationService.class,
                PutFormDataBasicAuthenticationController::putFormDataBasicAuthentication,
                ClientRequestBasicAuthenticationManager::putFormData
        );
    }

    @Test
    void delete_delegatesToDeleteBasicAuthenticationControllerAndReturnsResponse() {
        assertDelegationSuccess(
                DeleteBasicAuthenticationController.class,
                DeleteBasicAuthenticationService.class,
                DeleteBasicAuthenticationController::deleteBasicAuthentication,
                ClientRequestBasicAuthenticationManager::delete
        );
    }

    @Test
    void delete_propagatesControllerException() {
        assertDelegationFailure(
                DeleteBasicAuthenticationController.class,
                DeleteBasicAuthenticationService.class,
                DeleteBasicAuthenticationController::deleteBasicAuthentication,
                ClientRequestBasicAuthenticationManager::delete
        );
    }

    @Test
    void get_withInjectedRepositories_usesInjectedGetRepository() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(200, "get-response");
        when(getRepository.getBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ClientRequestBasicAuthenticationManager manager =
                new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.get(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(getRepository).getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(getRepository);
        verifyNoInteractions(deleteRepository, postRepository, putRepository);
    }

    @Test
    void post_withInjectedRepositories_usesInjectedPostRepository() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(201, "post-response");
        when(postRepository.postBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ClientRequestBasicAuthenticationManager manager =
                new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.post(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(postRepository).postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postRepository);
        verifyNoInteractions(deleteRepository, getRepository, putRepository);
    }

    @Test
    void postFormData_withInjectedRepositories_usesInjectedPostRepository() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(201, "post-form-data-response");
        when(postRepository.postFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ClientRequestBasicAuthenticationManager manager =
                new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.postFormData(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(postRepository).postFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postRepository);
        verifyNoInteractions(deleteRepository, getRepository, putRepository);
    }

    @Test
    void postFormParams_withInjectedRepositories_usesInjectedPostRepository() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(201, "post-form-params-response");
        when(postRepository.postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ClientRequestBasicAuthenticationManager manager =
                new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.postFormParams(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(postRepository).postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(postRepository);
        verifyNoInteractions(deleteRepository, getRepository, putRepository);
    }

    @Test
    void put_withInjectedRepositories_usesInjectedPutRepository() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(200, "put-response");
        when(putRepository.putBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ClientRequestBasicAuthenticationManager manager =
                new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.put(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(putRepository).putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putRepository);
        verifyNoInteractions(deleteRepository, getRepository, postRepository);
    }

    @Test
    void putFormData_withInjectedRepositories_usesInjectedPutRepository() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(200, "put-form-data-response");
        when(putRepository.putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ClientRequestBasicAuthenticationManager manager =
                new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.putFormData(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(putRepository).putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(putRepository);
        verifyNoInteractions(deleteRepository, getRepository, postRepository);
    }

    @Test
    void delete_withInjectedRepositories_usesInjectedDeleteRepository() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(204, "delete-response");
        when(deleteRepository.deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication)).thenReturn(expected);

        ClientRequestBasicAuthenticationManager manager =
                new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.delete(apiRequest, endpoint, basicAuthentication);

        assertThat(actual).isSameAs(expected);
        verify(deleteRepository).deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication);
        verifyNoMoreInteractions(deleteRepository);
        verifyNoInteractions(getRepository, postRepository, putRepository);
    }

    @Test
    void constructor_withNullDeleteRepository_throwsNullPointerException() {
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        assertThatThrownBy(() -> new ClientRequestBasicAuthenticationManager(null, getRepository, postRepository, putRepository))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("deleteRepository must not be null");
    }

    @Test
    void constructor_withNullGetRepository_throwsNullPointerException() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        assertThatThrownBy(() -> new ClientRequestBasicAuthenticationManager(deleteRepository, null, postRepository, putRepository))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("getRepository must not be null");
    }

    @Test
    void constructor_withNullPostRepository_throwsNullPointerException() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        assertThatThrownBy(() -> new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, null, putRepository))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("postRepository must not be null");
    }

    @Test
    void constructor_withNullPutRepository_throwsNullPointerException() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);

        assertThatThrownBy(() -> new ClientRequestBasicAuthenticationManager(deleteRepository, getRepository, postRepository, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("putRepository must not be null");
    }

    private <C> void assertDelegationSuccess(final Class<C> controllerClass,
                                             final Class<?> expectedUseCaseClass,
                                             final ControllerInvocation<C> controllerInvocation,
                                             final ManagerInvocation managerInvocation) {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        ApiResponse expected = new ApiResponse(200, "response-body");
        List<List<?>> constructorArguments = new ArrayList<>();

        try (MockedConstruction<C> controllerConstruction = mockConstruction(controllerClass, (mock, context) -> {
            constructorArguments.add(new ArrayList<>(context.arguments()));
            when(controllerInvocation.invoke(mock, apiRequest, endpoint, basicAuthentication)).thenReturn(expected);
        })) {
            ApiResponse actual = managerInvocation.invoke(new ClientRequestBasicAuthenticationManager(),
                    apiRequest, endpoint, basicAuthentication);

            assertThat(actual).isSameAs(expected);
            assertControllerConstruction(controllerConstruction, constructorArguments, expectedUseCaseClass);

            C controller = controllerConstruction.constructed().getFirst();
            controllerInvocation.invoke(verify(controller), apiRequest, endpoint, basicAuthentication);
            verifyNoMoreInteractions(controller);
        }
    }

    private <C> void assertDelegationFailure(final Class<C> controllerClass,
                                             final Class<?> expectedUseCaseClass,
                                             final ControllerInvocation<C> controllerInvocation,
                                             final ManagerInvocation managerInvocation) {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        BasicAuthentication basicAuthentication = new BasicAuthentication("user", "pass");
        RuntimeException boom = new RuntimeException("boom");
        List<List<?>> constructorArguments = new ArrayList<>();

        try (MockedConstruction<C> controllerConstruction = mockConstruction(controllerClass, (mock, context) -> {
            constructorArguments.add(new ArrayList<>(context.arguments()));
            when(controllerInvocation.invoke(mock, apiRequest, endpoint, basicAuthentication)).thenThrow(boom);
        })) {
            assertThatThrownBy(() -> managerInvocation.invoke(new ClientRequestBasicAuthenticationManager(),
                    apiRequest, endpoint, basicAuthentication))
                    .isSameAs(boom);

            assertControllerConstruction(controllerConstruction, constructorArguments, expectedUseCaseClass);

            C controller = controllerConstruction.constructed().getFirst();
            controllerInvocation.invoke(verify(controller), apiRequest, endpoint, basicAuthentication);
            verifyNoMoreInteractions(controller);
        }
    }

    private void assertControllerConstruction(final MockedConstruction<?> controllerConstruction,
                                              final List<List<?>> constructorArguments,
                                              final Class<?> expectedUseCaseClass) {
        assertThat(controllerConstruction.constructed()).hasSize(1);
        assertThat(constructorArguments).hasSize(1);
        assertThat(constructorArguments.getFirst()).hasSize(1);
        assertThat(constructorArguments.getFirst().getFirst()).isInstanceOf(expectedUseCaseClass);
    }

    @FunctionalInterface
    private interface ControllerInvocation<C> {
        ApiResponse invoke(C controller,
                           ApiRequest apiRequest,
                           String endpoint,
                           BasicAuthentication basicAuthentication);
    }

    @FunctionalInterface
    private interface ManagerInvocation {
        ApiResponse invoke(ClientRequestBasicAuthenticationManager manager,
                           ApiRequest apiRequest,
                           String endpoint,
                           BasicAuthentication basicAuthentication);
    }
}
