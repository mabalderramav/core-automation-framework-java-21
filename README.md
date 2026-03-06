# Core Automation Framework - Java 21

A modular automation framework built with **Java 21** and **Gradle**, designed to provide reusable core components for test automation and environment configuration management.

## Overview

This project is structured as a multi-module Gradle framework that centralizes common automation capabilities into reusable libraries. It currently includes:

- **core-utils**  
  Shared utility components for working with JSON, properties files, and supporting helpers.

- **core-environment**  
  Environment configuration management for UI and API automation, including loading and resolving environment data from JSON files.

The framework is intended to serve as a foundation for scalable automation solutions where common concerns such as configuration, parsing, and environment selection are separated into maintainable modules.

---

## Tech Stack

- **Java 21**
- **Gradle**
- **JUnit 5**
- **Gson**
- **JsonPath**
- **Log4j2**
- **Lombok**
- **JaCoCo**
- **SonarQube**

---

## Project Structure
```
core-automation-framework-java-21 
├── core-utils 
├── core-environment 
├── build.gradle 
├── settings.gradle 
├── gradlew 
├── gradlew.bat 
└── README.md
```

### Modules

#### `core-utils`
Contains reusable utility functionality such as:

- JSON file reading
- JSON parsing and path-based access
- Properties file reading
- Logging support

#### `core-environment`
Contains environment bootstrap and configuration logic such as:

- Reading environment definitions from JSON
- Managing UI environment configuration
- Managing API environment configuration
- Mapping configuration data into domain models

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

### Utilities
Provides helper classes for:

- reading JSON files
- converting JSON content
- extracting values using JSON path
- reading `.properties` files

### Test Support
The framework includes unit tests for core functionality using **JUnit 5**.

### Reporting and Code Quality
Integrated support for:

- **JaCoCo** XML and HTML coverage reports
- **SonarQube** analysis

---

## Prerequisites

Before using the framework, make sure you have:

- **Java 21**
- **Gradle** (optional if using the wrapper)
- Access to a terminal or command prompt

---

## Build the Project

Use the Gradle wrapper to build the full project:

### Linux / macOS
bash ./gradlew clean build
### Windows
bash gradlew.bat clean build

---

## Run Tests
bash ./gradlew test

### Linux / macOS
bash gradlew.bat test

---

## Generate Code Coverage Report

bash ./gradlew jacocoTestReport


Coverage reports are generated for subprojects where tests are present.

---

## SonarQube Analysis

To run SonarQube analysis, use a command like:
```
bash ./gradlew sonar
-Dsonar.projectKey=core-automation-framework-java-21
-Dsonar.projectName=core-automation-framework-java-21
-Dsonar.host.url=[http://localhost:9000](http://localhost:9000)
-Dsonar.token=YOUR_TOKEN
```


> Replace `YOUR_TOKEN` with your SonarQube token.

---

## How to Use

### 1. Add your environment configuration file
Prepare a JSON file that contains the environment definitions needed for your UI or API automation flows.

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

### 4. Reuse utility modules
Use the utility module for reading JSON and properties files across other automation layers.

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

### core-utils
- Log4j2
- Gson
- JsonPath
- Lombok
- JUnit 5
- SLF4J Simple (test scope)

### core-environment
- Depends on `core-utils`
- Log4j2
- Gson
- Lombok
- JUnit 5

---

## Design Goals

- **Modular**: separate reusable concerns into focused modules
- **Maintainable**: keep environment handling and utilities independent
- **Extensible**: support adding more automation modules later
- **Reusable**: share common components across multiple automation projects

---

## Future Extension Ideas

Possible next additions to the framework:

- `core-api-client`
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