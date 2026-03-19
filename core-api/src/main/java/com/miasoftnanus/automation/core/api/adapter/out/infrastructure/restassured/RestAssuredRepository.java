package com.miasoftnanus.automation.core.api.adapter.out.infrastructure.restassured;

import com.miasoftnanus.automation.core.api.model.ApiRequest;
import io.restassured.specification.RequestSpecification;
import org.apache.http.entity.ContentType;

import java.io.File;
import java.util.Map;

abstract class RestAssuredRepository {
    /**
     * Adds multipart to request.
     *
     * @param reqSpec request specification.
     * @param request request object.
     */
    protected void addMultiParts(final RequestSpecification reqSpec, final ApiRequest request) {
        for (Map.Entry<String, String> entry : request.formData().entrySet()) {
            if (new File(entry.getValue()).isFile()) {
                String path = entry.getValue();
                reqSpec.multiPart(entry.getKey(), new File(path),
                        ContentType.APPLICATION_OCTET_STREAM.getMimeType());
            }
            reqSpec.multiPart(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN.getMimeType());
        }
    }
}
