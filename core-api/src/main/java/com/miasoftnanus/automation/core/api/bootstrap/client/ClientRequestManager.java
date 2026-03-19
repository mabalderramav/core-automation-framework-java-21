package com.miasoftnanus.automation.core.api.bootstrap.client;

import com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured.RestAssuredDeleteRepository;
import com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured.RestAssuredGetRepository;
import com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured.RestAssuredPostRepository;
import com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured.RestAssuredPutRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.DeleteRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.GetRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PostRepository;
import com.miasoftnanus.automation.core.api.application.port.out.infrastructure.PutRepository;

/**
 * Abstract class responsible for managing client API requests.
 * Acts as a centralized component for handling HTTP methods such as GET, POST, PUT, and DELETE.
 * Provides a foundation for subclasses to implement specific request management functionalities.
 * The class makes use of repository patterns for each HTTP method, supporting modularity and separation of concerns.
 */
public abstract class ClientRequestManager {
    protected final DeleteRepository deleteRepository;
    protected final GetRepository getRepository;
    protected final PostRepository postRepository;
    protected final PutRepository putRepository;

    /**
     * Constructs a new instance of the {@code ClientRequestManager} class.
     * Initializes the repositories responsible for handling HTTP methods (GET, POST, PUT, DELETE)
     * using RestAssured-based implementations.
     * <p>
     * This constructor is protected to ensure that the class cannot be directly instantiated
     * from outside its inheritance hierarchy and is intended to be used via concrete subclasses.
     * The class dependencies are encapsulated within specific repository implementations,
     * enabling the delegation of HTTP request operations for respective use cases.
     * </p>
     */
    protected ClientRequestManager() {
        deleteRepository = new RestAssuredDeleteRepository();
        getRepository = new RestAssuredGetRepository();
        postRepository = new RestAssuredPostRepository();
        putRepository = new RestAssuredPutRepository();
    }
}
