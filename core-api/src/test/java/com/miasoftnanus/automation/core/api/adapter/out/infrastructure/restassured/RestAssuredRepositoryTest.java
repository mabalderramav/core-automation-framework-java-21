package com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import io.restassured.specification.RequestSpecification;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RestAssuredRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void addMultiParts_shouldAddBinaryMultiPartWhenFormDataValueIsAnExistingFile() throws IOException {
        // Arrange
        Path tempFile = Files.createTempFile(tempDir, "upload-", ".txt");
        Files.writeString(tempFile, "file-content");

        ApiRequest apiRequest = new ApiRequest()
                .formData(Map.of("upload", tempFile.toString()));
        RequestSpecification requestSpecification = mock(RequestSpecification.class);
        TestRestAssuredRepository repository = new TestRestAssuredRepository();

        assertThat(tempFile)
                .exists()
                .isRegularFile();
        assertThat(apiRequest.formData())
                .containsEntry("upload", tempFile.toString());

        // Act
        repository.exposeAddMultiParts(requestSpecification, apiRequest);

        // Assert
        File expectedFile = tempFile.toFile();
        verify(requestSpecification).multiPart(
                "upload",
                expectedFile,
                ContentType.APPLICATION_OCTET_STREAM.getMimeType()
        );
        verify(requestSpecification).multiPart(
                "upload",
                tempFile.toString(),
                ContentType.TEXT_PLAIN.getMimeType()
        );
    }

    private static final class TestRestAssuredRepository extends RestAssuredRepository {
        private void exposeAddMultiParts(final RequestSpecification requestSpecification, final ApiRequest apiRequest) {
            addMultiParts(requestSpecification, apiRequest);
        }
    }
}

