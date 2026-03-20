package com.miasoftnanus.automation.core.api.bootstrap.client;

import com.miasoftnanus.automation.core.api.adapter.in.rest.delete.DeleteController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.get.GetController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.put.PutController;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.DeleteRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
import com.miasoftnanus.automation.core.api.application.service.delete.DeleteService;
import com.miasoftnanus.automation.core.api.application.service.get.GetService;
import com.miasoftnanus.automation.core.api.application.service.post.PostService;
import com.miasoftnanus.automation.core.api.application.service.put.PutService;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
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

class ClientWithoutAuthenticationRequestManagerTest {

    @Test
    void get_delegatesToGetControllerAndReturnsResponse() {
        assertDelegationSuccess(
                GetController.class,
                GetService.class,
                GetController::get,
                ClientWithoutAuthenticationRequestManager::get
        );
    }

    @Test
    void get_propagatesControllerException() {
        assertDelegationFailure(
                GetController.class,
                GetService.class,
                GetController::get,
                ClientWithoutAuthenticationRequestManager::get
        );
    }

    @Test
    void post_delegatesToPostControllerAndReturnsResponse() {
        assertDelegationSuccess(
                PostController.class,
                PostService.class,
                PostController::post,
                ClientWithoutAuthenticationRequestManager::post
        );
    }

    @Test
    void post_propagatesControllerException() {
        assertDelegationFailure(
                PostController.class,
                PostService.class,
                PostController::post,
                ClientWithoutAuthenticationRequestManager::post
        );
    }

    @Test
    void put_delegatesToPutControllerAndReturnsResponse() {
        assertDelegationSuccess(
                PutController.class,
                PutService.class,
                PutController::put,
                ClientWithoutAuthenticationRequestManager::put
        );
    }

    @Test
    void put_propagatesControllerException() {
        assertDelegationFailure(
                PutController.class,
                PutService.class,
                PutController::put,
                ClientWithoutAuthenticationRequestManager::put
        );
    }

    @Test
    void delete_delegatesToDeleteControllerAndReturnsResponse() {
        assertDelegationSuccess(
                DeleteController.class,
                DeleteService.class,
                DeleteController::delete,
                ClientWithoutAuthenticationRequestManager::delete
        );
    }

    @Test
    void delete_propagatesControllerException() {
        assertDelegationFailure(
                DeleteController.class,
                DeleteService.class,
                DeleteController::delete,
                ClientWithoutAuthenticationRequestManager::delete
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
        ApiResponse expected = new ApiResponse(200, "get-response");
        when(getRepository.get(apiRequest, endpoint)).thenReturn(expected);

        ClientWithoutAuthenticationRequestManager manager =
                new ClientWithoutAuthenticationRequestManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.get(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(getRepository).get(apiRequest, endpoint);
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
        ApiResponse expected = new ApiResponse(201, "post-response");
        when(postRepository.post(apiRequest, endpoint)).thenReturn(expected);

        ClientWithoutAuthenticationRequestManager manager =
                new ClientWithoutAuthenticationRequestManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.post(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(postRepository).post(apiRequest, endpoint);
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
        ApiResponse expected = new ApiResponse(200, "put-response");
        when(putRepository.put(apiRequest, endpoint)).thenReturn(expected);

        ClientWithoutAuthenticationRequestManager manager =
                new ClientWithoutAuthenticationRequestManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.put(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(putRepository).put(apiRequest, endpoint);
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
        ApiResponse expected = new ApiResponse(204, "delete-response");
        when(deleteRepository.delete(apiRequest, endpoint)).thenReturn(expected);

        ClientWithoutAuthenticationRequestManager manager =
                new ClientWithoutAuthenticationRequestManager(deleteRepository, getRepository, postRepository, putRepository);

        ApiResponse actual = manager.delete(apiRequest, endpoint);

        assertThat(actual).isSameAs(expected);
        verify(deleteRepository).delete(apiRequest, endpoint);
        verifyNoMoreInteractions(deleteRepository);
        verifyNoInteractions(getRepository, postRepository, putRepository);
    }

    @Test
    void constructor_withNullDeleteRepository_throwsNullPointerException() {
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        assertThatThrownBy(() -> new ClientWithoutAuthenticationRequestManager(null, getRepository, postRepository, putRepository))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("deleteRepository must not be null");
    }

    @Test
    void constructor_withNullGetRepository_throwsNullPointerException() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        PostRepository postRepository = mock(PostRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        assertThatThrownBy(() -> new ClientWithoutAuthenticationRequestManager(deleteRepository, null, postRepository, putRepository))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("getRepository must not be null");
    }

    @Test
    void constructor_withNullPostRepository_throwsNullPointerException() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PutRepository putRepository = mock(PutRepository.class);

        assertThatThrownBy(() -> new ClientWithoutAuthenticationRequestManager(deleteRepository, getRepository, null, putRepository))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("postRepository must not be null");
    }

    @Test
    void constructor_withNullPutRepository_throwsNullPointerException() {
        DeleteRepository deleteRepository = mock(DeleteRepository.class);
        GetRepository getRepository = mock(GetRepository.class);
        PostRepository postRepository = mock(PostRepository.class);

        assertThatThrownBy(() -> new ClientWithoutAuthenticationRequestManager(deleteRepository, getRepository, postRepository, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("putRepository must not be null");
    }

    private <C> void assertDelegationSuccess(final Class<C> controllerClass,
                                             final Class<?> expectedUseCaseClass,
                                             final ControllerInvocation<C> controllerInvocation,
                                             final ManagerInvocation managerInvocation) {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        ApiResponse expected = new ApiResponse(200, "response-body");
        List<List<?>> constructorArguments = new ArrayList<>();

        try (MockedConstruction<C> controllerConstruction = mockConstruction(controllerClass, (mock, context) -> {
            constructorArguments.add(new ArrayList<>(context.arguments()));
            when(controllerInvocation.invoke(mock, apiRequest, endpoint)).thenReturn(expected);
        })) {
            ApiResponse actual = managerInvocation.invoke(new ClientWithoutAuthenticationRequestManager(),
                    apiRequest, endpoint);

            assertThat(actual).isSameAs(expected);
            assertControllerConstruction(controllerConstruction, constructorArguments, expectedUseCaseClass);

            C controller = controllerConstruction.constructed().getFirst();
            controllerInvocation.invoke(verify(controller), apiRequest, endpoint);
            verifyNoMoreInteractions(controller);
        }
    }

    private <C> void assertDelegationFailure(final Class<C> controllerClass,
                                             final Class<?> expectedUseCaseClass,
                                             final ControllerInvocation<C> controllerInvocation,
                                             final ManagerInvocation managerInvocation) {
        ApiRequest apiRequest = new ApiRequest();
        String endpoint = "/resource";
        RuntimeException boom = new RuntimeException("boom");
        List<List<?>> constructorArguments = new ArrayList<>();

        try (MockedConstruction<C> controllerConstruction = mockConstruction(controllerClass, (mock, context) -> {
            constructorArguments.add(new ArrayList<>(context.arguments()));
            when(controllerInvocation.invoke(mock, apiRequest, endpoint)).thenThrow(boom);
        })) {
            assertThatThrownBy(() -> managerInvocation.invoke(new ClientWithoutAuthenticationRequestManager(),
                    apiRequest, endpoint))
                    .isSameAs(boom);

            assertControllerConstruction(controllerConstruction, constructorArguments, expectedUseCaseClass);

            C controller = controllerConstruction.constructed().getFirst();
            controllerInvocation.invoke(verify(controller), apiRequest, endpoint);
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
                           String endpoint);
    }

    @FunctionalInterface
    private interface ManagerInvocation {
        ApiResponse invoke(ClientWithoutAuthenticationRequestManager manager,
                           ApiRequest apiRequest,
                           String endpoint);
    }
}
