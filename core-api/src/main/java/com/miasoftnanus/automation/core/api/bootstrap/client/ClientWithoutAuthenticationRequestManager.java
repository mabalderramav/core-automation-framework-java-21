package com.miasoftnanus.automation.core.api.bootstrap.client;

import com.miasoftnanus.automation.core.api.adapter.in.rest.delete.DeleteController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.get.GetController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.post.PostController;
import com.miasoftnanus.automation.core.api.adapter.in.rest.put.PutController;
import com.miasoftnanus.automation.core.api.application.port.in.delete.DeleteUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.get.GetUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.post.PostUseCase;
import com.miasoftnanus.automation.core.api.application.port.in.put.PutUseCase;
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

/**
 * A request manager for handling client API requests without requiring authentication.
 * This class extends {@code ClientRequestManager} and implements the {@code RequestManager} interface,
 * providing concrete implementations for managing HTTP requests (GET, POST, PUT, and DELETE).
 * <p>
 * The responsibility of this class is to delegate the execution of API operations to the appropriate
 * use case and controller classes using repository patterns. Since authentication is not required,
 * this manager focuses on handling requests without adding any authentication headers or tokens.
 * </p>
 * <p>
 * All HTTP operations are carried out using the respective service and controller layers, ensuring
 * modularity, separation of concerns, and scalability when integrating with API endpoints.
 * </p>
 */
public class ClientWithoutAuthenticationRequestManager extends ClientRequestManager implements RequestManager {

    /**
     * Constructs a new instance of {@code ClientWithoutAuthenticationRequestManager}.
     * This class is designed to handle API requests without requiring authentication.
     * It extends {@code ClientRequestManager} and inherits its repository initialization,
     * enabling the management of HTTP methods such as GET, POST, PUT, and DELETE through
     * their respective service, use case, and controller layers.
     * <p>
     * The constructor invokes the superclass constructor to initialize the repositories
     * for executing HTTP requests. As authentication is not required in this manager,
     * no additional request headers or tokens are added.
     * </p>
     */
    public ClientWithoutAuthenticationRequestManager() {
        super();
    }

    /**
     * Constructs a new instance of {@code ClientWithoutAuthenticationRequestManager}.
     * <p>
     * This constructor initializes the manager with the repositories responsible for handling
     * DELETE, GET, POST, and PUT HTTP requests. It leverages the provided repository implementations
     * to allow API communications without requiring authentication.
     * </p>
     *
     * @param deleteRepository the repository used for executing DELETE requests.
     * @param getRepository the repository used for executing GET requests.
     * @param postRepository the repository used for executing POST requests.
     * @param putRepository the repository used for executing PUT requests.
     */
    public ClientWithoutAuthenticationRequestManager(final DeleteRepository deleteRepository,
                                              final GetRepository getRepository,
                                              final PostRepository postRepository,
                                              final PutRepository putRepository) {
        super(deleteRepository, getRepository, postRepository, putRepository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse get(final ApiRequest apiRequest, final String endpoint) {
        GetUseCase getUseCase = new GetService(getRepository);
        GetController getController = new GetController(getUseCase);
        return getController.get(apiRequest, endpoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse post(final ApiRequest apiRequest, final String endpoint) {
        PostUseCase postUseCase = new PostService(postRepository);
        PostController postController = new PostController(postUseCase);
        return postController.post(apiRequest, endpoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse put(final ApiRequest apiRequest, final String endpoint) {
        PutUseCase putUseCase = new PutService(putRepository);
        PutController putController = new PutController(putUseCase);
        return putController.put(apiRequest, endpoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse delete(final ApiRequest apiRequest, final String endpoint) {
        DeleteUseCase deleteUseCase = new DeleteService(deleteRepository);
        DeleteController deleteController = new DeleteController(deleteUseCase);
        return deleteController.delete(apiRequest, endpoint);
    }
}
