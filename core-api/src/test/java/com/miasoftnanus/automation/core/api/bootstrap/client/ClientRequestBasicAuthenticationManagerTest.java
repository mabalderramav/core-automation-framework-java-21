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
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;
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
