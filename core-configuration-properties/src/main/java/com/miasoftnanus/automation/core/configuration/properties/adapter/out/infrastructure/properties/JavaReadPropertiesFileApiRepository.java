package com.miasoftnanus.automation.core.configuration.properties.adapter.out.infrastructure.properties;

import com.miasoftnanus.automation.core.configuration.properties.application.port.out.infrastructure.ReadPropertiesFileApiRepository;
import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfig;
import com.miasoftnanus.automation.core.configuration.properties.model.ApiConfigWords;
import com.miasoftnanus.automation.core.configuration.properties.model.CommonConfigWords;
import com.miasoftnanus.automation.core.utils.properties.PropertiesFileReader;

/**
 * Implementation of {@link ReadPropertiesFileApiRepository} that reads API-related properties
 * from a specified properties file and converts them into an {@link ApiConfig} instance.
 * This class leverages {@link PropertiesFileReader} to extract property values and populate
 * configuration details such as environment name, API name, version, and authentication details.
 */
public class JavaReadPropertiesFileApiRepository implements ReadPropertiesFileApiRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiConfig readPropertiesFile(String propertyFilePath) {
        var propertiesFileReader = new PropertiesFileReader(propertyFilePath);
        var apiConfig = new ApiConfig();
        apiConfig.environmentName(propertiesFileReader.getPropertyValue(CommonConfigWords.ENVIRONMENT_NAME.val()));
        apiConfig.environmentFilePath(
                propertiesFileReader.getPropertyValue(CommonConfigWords.ENVIRONMENT_FILE_PATH.val()));
        apiConfig.apiName(propertiesFileReader.getPropertyValue(ApiConfigWords.API_NAME.val()));
        apiConfig.versionName(propertiesFileReader.getPropertyValue(ApiConfigWords.API_VERSION_NAME.val()));
        apiConfig.authenticationType(
                propertiesFileReader.getPropertyValue(ApiConfigWords.API_AUTHENTICATION_TYPE.val()));
        apiConfig.authenticationUserType(
                propertiesFileReader.getPropertyValue(ApiConfigWords.API_AUTHENTICATION_USER_TYPE.val()));
        return apiConfig;
    }
}
