# Core Automation Framework - Java 25

A modular automation framework built with **Java 25** and **Gradle 9.5.1**, designed to provide reusable core components for configuration-driven UI and API automation.

## Overview

This project is a multi-module Gradle framework that centralizes shared automation capabilities into reusable libraries. The current workspace includes:

- **`core-utils`**  
  Common helpers for reading JSON and `.properties` files, parsing JSON content, and extracting values with JsonPath.

- **`core-environment`**  
  JSON-based environment management for UI and API automation, including environment selection, API/version resolution, authentication lookup, and portal/user mapping.

- **`core-configuration-properties`**  
  Property-based configuration management for UI and API settings through dedicated managers and repository/service/controller layers.

- **`core-api`**  
  Reusable API request abstractions, request managers, controllers, services, and Rest Assured-based repositories for HTTP operations with and without basic authentication.

The framework is intended to be a foundation for scalable automation solutions where shared concerns such as configuration loading, environment resolution, and API client behavior are implemented once and reused across projects.

---

## Tech Stack

- **Java 25**
- **Gradle 9.5.1**
- **JUnit 5**
- **AssertJ**
- **Mockito**
- **Gson**
- **JsonPath**
- **Rest Assured**
- **Log4j2**
- **Lombok**
- **JaCoCo**
- **SonarQube**

---

## Project Structure

```text
core-automation-framework-java/
├── core-api/
├── core-configuration-properties/
├── core-environment/
├── core-utils/
├── gradle/
├── build.gradle
├── command.txt
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

The modules included in `settings.gradle` are:

- `core-utils`
- `core-environment`
- `core-configuration-properties`
- `core-api`

---

## Modules

### `core-utils`

Contains reusable utility functionality such as:

- JSON file reading
- JSON parsing
- JSON path-based value extraction
- `.properties` file reading
- shared logging support

Representative utilities include:

- `JsonFileReader`
- `JsonParser`
- `JsonPath`
- `PropertiesFileReader`

### `core-environment`

Contains JSON-based environment bootstrap and configuration logic such as:

- reading UI environment definitions from JSON files
- reading API environment definitions from JSON files
- selecting an environment by name
- selecting a portal, API, version, and user type
- resolving authentication data
- mapping Gson entities into domain models

Representative entry points include:

- `EnvironmentUiManager`
- `EnvironmentApiManager`

Representative mappers include:

- `ApiMapper`
- `PortalMapper`
- `EnvironmentApiMapper`
- `EnvironmentUiMapper`

### `core-configuration-properties`

Contains property-based configuration management such as:

- reading UI configuration from `.properties` files
- reading API configuration from `.properties` files
- exposing strongly typed UI and API config models
- separating controller, service, and repository responsibilities

Representative entry points include:

- `UiConfigManager`
- `ApiConfigManager`

Representative models include:

- `UiConfig`
- `ApiConfig`
- `CommonConfig`

### `core-api`

Contains reusable API automation components such as:

- `ApiRequest`, `ApiResponse`, and `BasicAuthentication` models
- managers for requests with and without authentication
- controller and service layers for `GET`, `POST`, `PUT`, and `DELETE`
- support for basic-authenticated requests
- support for form-data and form-params POST flows
- support for form-data PUT flows
- Rest Assured-based repository implementations

Representative entry points include:

- `ClientWithoutAuthenticationRequestManager`
- `ClientRequestBasicAuthenticationManager`
- `RequestManager`
- `RequestBasicAuthenticationManager`

---

## Features

### Environment Management

The framework supports loading environment configuration from JSON files and exposing structured access to:

- environment selection
- API definitions
- API versions
- authentication details
- user data
- portal/UI configuration

### Properties-Based Configuration

The framework also supports loading `.properties`-based configuration for automation settings such as:

- UI wait values
- browser-related settings
- API-related settings
- common/shared configuration values

### API Automation Support

The API module provides reusable request handling for:

- `GET`
- `POST`
- `PUT`
- `DELETE`
- basic authentication
- multipart/form-data upload scenarios
- form parameter submission scenarios

### Utilities

Provides helper classes for:

- reading JSON files
- converting JSON content
- extracting values using JSON path
- reading `.properties` files

### Test Support

The framework includes unit tests for core functionality using:

- **JUnit 5** for test execution
- **AssertJ** for fluent assertions
- **Mockito** for mocks, constructor mocking, and interaction verification

Recent automated coverage includes tests for:

- environment mappers and models
- configuration managers and property-backed models
- API models such as `ApiRequest`, `ApiResponse`, and `BasicAuthentication`
- API services, repositories, controllers, and request managers

### Recent Changes

Recent updates in the framework include:

- migration to **Java 25** and **Gradle 9.5.1**
- expanded unit coverage for environment mappers, configuration components, API services, repositories, controllers, and request managers
- new constructor-focused tests for `ClientRequestBasicAuthenticationManager` and `ClientWithoutAuthenticationRequestManager` to verify injected repositories are used correctly
- improved support for constructor-based repository injection in request managers, making the API layer easier to test and customize

### Reporting and Code Quality

Integrated support for:

- **JaCoCo** XML and HTML coverage reports in subprojects
- root-level **SonarQube** analysis configured to consume subproject JaCoCo XML reports

---

## Prerequisites

Before using the framework, make sure you have:

- **Java 25**
- **Gradle 9.5.1** (optional if using the wrapper)
- access to a terminal or command prompt

---

## Build the Project

Use the Gradle wrapper to build the full project.

### Linux / macOS

```bash
./gradlew clean build
```

### Windows

```powershell
.\gradlew.bat clean build
```

---

## Run Tests

Run all tests for the workspace:

### Linux / macOS

```bash
./gradlew test
```

### Windows

```powershell
.\gradlew.bat test
```

Run tests for a specific module, for example `core-api`:

### Linux / macOS

```bash
./gradlew :core-api:test
```

### Windows

```powershell
.\gradlew.bat :core-api:test
```

---

## Generate Code Coverage Report

Generate JaCoCo coverage for a specific subproject, for example `core-api`:

### Linux / macOS

```bash
./gradlew :core-api:jacocoTestReport
```

### Windows

```powershell
.\gradlew.bat :core-api:jacocoTestReport
```

Coverage reports are generated in each subproject under:

```text
<module>/build/reports/jacoco/test/
```

---

## SonarQube Analysis

The root project is configured so the `sonar` task depends on each subproject's `jacocoTestReport` output, and SonarQube consumes those XML coverage reports automatically.

Example command:

### Linux / macOS

```bash
./gradlew sonar \
  -Dsonar.projectKey=core-automation-framework-java \
  -Dsonar.projectName=core-automation-framework-java \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=YOUR_TOKEN
```

### Windows

```powershell
.\gradlew.bat sonar `
  -Dsonar.projectKey=core-automation-framework-java `
  -Dsonar.projectName=core-automation-framework-java `
  -Dsonar.host.url=http://localhost:9000 `
  -Dsonar.token=YOUR_TOKEN
```

You can also refer to `command.txt` for the project SonarQube command template.

> Replace `YOUR_TOKEN` with your SonarQube token.

---

## How to Use

### 1. Add your configuration files

Prepare the configuration sources required by your automation flow:

- JSON environment files for UI or API environment resolution
- `.properties` files for UI/API/common configuration values

### 2. Load UI environment data

Use the UI environment manager when your automation needs portal and user-specific configuration.

Typical responsibilities include:

- selecting an environment by name
- selecting a portal
- selecting a user type
- exposing the resolved configuration for tests or automation flows

### 3. Load API environment data

Use the API environment manager when your automation needs API-specific configuration.

Typical responsibilities include:

- selecting an environment by name
- selecting an API
- selecting a version
- selecting an authentication type
- selecting an authentication user type

Small example:

```text
import com.miasoftnanus.automation.core.environment.bootstrap.EnvironmentApiManager;

EnvironmentApiManager.resetInstance();

EnvironmentApiManager environmentApiManager = EnvironmentApiManager.getInstance(
        "DEV",
        "MIASOFTNANUS_CONF",
        "V1",
        "BASIC",
        "API-AUTO",
        "./src/test/resources/EnvironmentApi.json"
);

String baseUrl = environmentApiManager.api().baseUrl();
String pathVersion = environmentApiManager.version().pathVersion();
String username = environmentApiManager.user().username();
String password = environmentApiManager.user().password();

String endpoint = baseUrl + pathVersion + "health";
```

If you prefer the default environment file path configured in `EnvironmentManagerWords`, you can use the five-argument `getInstance(...)` overload instead.

### 4. Load UI and API property configuration

Use the configuration properties managers when your automation needs strongly typed values from `.properties` files.

Typical responsibilities include:

- loading UI config values
- loading API config values
- exposing shared/common config values

### 5. Reuse API request managers

Use the API module to execute reusable HTTP requests through the provided managers and layers.

Typical responsibilities include:

- invoking HTTP requests with or without basic authentication
- sending form-data requests
- sending form-parameter requests
- validating standardized API response objects

Small example:

```text
import com.miasoftnanus.automation.core.api.bootstrap.client.ClientRequestBasicAuthenticationManager;
import com.miasoftnanus.automation.core.api.model.ApiRequest;
import com.miasoftnanus.automation.core.api.model.ApiResponse;
import com.miasoftnanus.automation.core.api.model.BasicAuthentication;

ApiRequest apiRequest = new ApiRequest();
apiRequest.headers().put("Content-Type", "application/json");
apiRequest.body("""
        {
          "name": "sample"
        }
        """);

BasicAuthentication basicAuthentication = new BasicAuthentication("user", "password");

ClientRequestBasicAuthenticationManager client = new ClientRequestBasicAuthenticationManager();
ApiResponse response = client.post(
        apiRequest,
        "https://example.test/api/v1/resources",
        basicAuthentication
);

int statusCode = response.statusCode();
String responseBody = response.body();
```

For tests or custom wiring, `ClientRequestBasicAuthenticationManager` also provides a constructor that accepts `DeleteRepository`, `GetRepository`, `PostRepository`, and `PutRepository` instances.

### 6. Reuse utility modules

Use the utility module for shared JSON and properties-file operations across other automation layers.

---

## Example Use Cases

This framework can be used as the foundation for:

- UI automation frameworks
- API automation frameworks
- hybrid UI/API testing projects
- centralized configuration-driven automation
- reusable enterprise automation libraries

---

## Dependency Highlights

### Root Project

- JUnit BOM
- JUnit Jupiter
- SonarQube plugin
- root SonarQube configuration for subproject JaCoCo XML reports

### `core-utils`

- Log4j2
- Gson
- JsonPath
- Lombok
- JUnit 5
- SLF4J Simple (test scope)

### `core-environment`

- depends on `core-utils`
- Log4j2
- Gson
- Lombok
- JUnit 5

### `core-configuration-properties`

- depends on `core-utils`
- Log4j2
- Gson
- Lombok
- JUnit 5
- AssertJ

### `core-api`

- Log4j2
- Gson
- Rest Assured
- Lombok
- JUnit 5
- AssertJ
- Mockito Core
- Mockito Inline
- Mockito JUnit Jupiter

---

## Design Goals

- **Modular**: separate reusable concerns into focused modules
- **Maintainable**: keep environment handling, configuration loading, and API request execution independent
- **Extensible**: support adding more automation modules later
- **Reusable**: share common components across multiple automation projects
- **Testable**: support unit testing with fluent assertions and injectable collaborators

---

## Future Extension Ideas

Possible next additions to the framework:

- `core-ui-web`
- `core-mobile`
- `core-db`
- `core-reporting`
- `core-test-data`
- `core-assertions`

---

## License

This project includes a `LICENSE` file in the repository root.  
Refer to it for license details.

---

## Author Notes

This framework is a strong starting point for building a scalable automation ecosystem around shared core capabilities. As the project evolves, the modular structure makes it easy to add new automation layers without duplicating foundational logic.
