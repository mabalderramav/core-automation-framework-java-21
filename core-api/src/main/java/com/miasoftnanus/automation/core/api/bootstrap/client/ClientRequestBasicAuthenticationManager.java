package com.miasoftnanus.automation.core.api.bootstrap.client;

import com.miasoftnanus.automation.core.api.adapter.in.rest.delete.DeleteBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.get.GetBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostFormDataBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostFormParamsBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.put.PutBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.put.PutFormDataBasicAuthenticationController;
import com.miasoftnanus.automation.core.api.application.port.in.delete.DeleteBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.get.GetBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.post.PostBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.post.PostFormDataBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.post.PostFormParamsBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.put.PutBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.put.PutFormDataBasicAuthenticationUseCase;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.DeleteRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;
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

/**
 * A concrete implementation of the {@code ClientRequestManager} class that provides functionality
 * to manage API requests with Basic Authentication. This class performs HTTP operations
 * (GET, POST, PUT, DELETE) and their specialized forms (e.g., form-data and form-params handling)
 * using Basic Authentication credentials.
 * <p>
 * The class delegates the authentication-specific logic for various HTTP methods to respective
 * use cases and controllers, ensuring a clear separation of concerns and modularity.
 * </p>
 * <p>
 * This class implements the {@code RequestBasicAuthenticationManager} interface to align with
 * a predefined contract for handling Basic Authentication in client-side API requests.
 * </p>
 */
public class ClientRequestBasicAuthenticationManager extends ClientRequestManager
        implements RequestBasicAuthenticationManager {

    /**
     * Constructs a new instance of the {@code ClientRequestBasicAuthenticationManager} class.
     * This class extends the capabilities of {@code ClientRequestManager} to include support
     * for handling HTTP requests that require basic authentication. It provides methods for
     * performing various HTTP operations (e.g., GET, POST, PUT, DELETE) with the ability to
     * supply basic authentication credentials.
     * <p>
     * The constructor initializes the superclass to ensure proper setup of the HTTP repositories
     * and maintains compatibility with the extended functionality introduced in this class.
     * The authentication process is streamlined for use cases where APIs require
     * basic authentication headers in conjunction with standard HTTP request data.
     * <p>
     */
    public ClientRequestBasicAuthenticationManager() {
        super();
    }

    /**
     * Constructs a new instance of the {@code ClientRequestBasicAuthenticationManager} class.
     * This constructor initializes the manager with the provided repository instances to perform
     * HTTP operations (GET, POST, PUT, DELETE) with basic authentication support.
     *
     * @param deleteRepository the repository for handling HTTP DELETE requests.
     * @param getRepository    the repository for handling HTTP GET requests.
     * @param postRepository   the repository for handling HTTP POST requests.
     * @param putRepository    the repository for handling HTTP PUT requests.
     */
    public ClientRequestBasicAuthenticationManager(final DeleteRepository deleteRepository,
                                            final GetRepository getRepository,
                                            final PostRepository postRepository,
                                            final PutRepository putRepository) {
        super(deleteRepository, getRepository, postRepository, putRepository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse get(final ApiRequest apiRequest,
                           final String endpoint,
                           final BasicAuthentication basicAuthentication) {
        GetBasicAuthenticationUseCase getBasicAuthenticationUseCase = new GetBasicAuthenticationService(getRepository);
        GetBasicAuthenticationController getBasicAuthenticationController =
                new GetBasicAuthenticationController(getBasicAuthenticationUseCase);
        return getBasicAuthenticationController.getBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse post(final ApiRequest apiRequest,
                            final String endpoint,
                            final BasicAuthentication basicAuthentication) {
        PostBasicAuthenticationUseCase postBasicAuthenticationUseCase =
                new PostBasicAuthenticationService(postRepository);
        PostBasicAuthenticationController postBasicAuthenticationController =
                new PostBasicAuthenticationController(postBasicAuthenticationUseCase);
        return postBasicAuthenticationController.postBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postFormData(final ApiRequest apiRequest,
                                    final String endpoint,
                                    final BasicAuthentication basicAuthentication) {
        PostFormDataBasicAuthenticationUseCase postFormDataBasicAuthenticationUseCase =
                new PostFormDataBasicAuthenticationService(postRepository);
        PostFormDataBasicAuthenticationController postFormDataBasicAuthenticationController =
                new PostFormDataBasicAuthenticationController(postFormDataBasicAuthenticationUseCase);
        return postFormDataBasicAuthenticationController
                .postFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse postFormParams(final ApiRequest apiRequest,
                                      final String endpoint,
                                      final BasicAuthentication basicAuthentication) {
        PostFormParamsBasicAuthenticationUseCase postFormParamsBasicAuthenticationUseCase =
                new PostFormParamsBasicAuthenticationService(postRepository);
        PostFormParamsBasicAuthenticationController postFormParamsBasicAuthenticationController =
                new PostFormParamsBasicAuthenticationController(postFormParamsBasicAuthenticationUseCase);
        return postFormParamsBasicAuthenticationController
                .postFormParamsBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse put(final ApiRequest apiRequest,
                           final String endpoint,
                           final BasicAuthentication basicAuthentication) {
        PutBasicAuthenticationUseCase putBasicAuthenticationUseCase = new PutBasicAuthenticationService(putRepository);
        PutBasicAuthenticationController putBasicAuthenticationController =
                new PutBasicAuthenticationController(putBasicAuthenticationUseCase);
        return putBasicAuthenticationController
                .putBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse putFormData(final ApiRequest apiRequest,
                                   final String endpoint,
                                   final BasicAuthentication basicAuthentication) {
        PutFormDataBasicAuthenticationUseCase putFormDataBasicAuthenticationUseCase =
                new PutFormDataBasicAuthenticationService(putRepository);
        PutFormDataBasicAuthenticationController putFormDataBasicAuthenticationController =
                new PutFormDataBasicAuthenticationController(putFormDataBasicAuthenticationUseCase);
        return putFormDataBasicAuthenticationController
                .putFormDataBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse delete(final ApiRequest apiRequest,
                              final String endpoint,
                              final BasicAuthentication basicAuthentication) {
        DeleteBasicAuthenticationUseCase deleteBasicAuthenticationUseCase =
                new DeleteBasicAuthenticationService(deleteRepository);
        DeleteBasicAuthenticationController deleteBasicAuthenticationController =
                new DeleteBasicAuthenticationController(deleteBasicAuthenticationUseCase);
        return deleteBasicAuthenticationController
                .deleteBasicAuthentication(apiRequest, endpoint, basicAuthentication);
    }
}
