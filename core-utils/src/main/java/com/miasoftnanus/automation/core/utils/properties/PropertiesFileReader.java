package com.miasoftnanus.automation.core.utils.properties;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

/**
 * Reads data from .properties file.
 */
@Log4j2
public class PropertiesFileReader {
    private Properties properties;

    /**
     * Initializes an instance of {@link PropertiesFileReader}.
     *
     * @param filePath properties file path String.
     */
    public PropertiesFileReader(final String filePath) {
        log.info("Reading config file from path:{}", filePath);
        this.init(filePath);
    }

    /**
     * Reads the config file.
     *
     * @param filePath config properties file path String.
     */
    private void init(final String filePath) {
        String path = filePath;

        if (!new File(filePath).exists()) {
            path = filePath.replace(ReservedWords.DOUBLE_DOT_AND_SLASH.val(), ReservedWords.STRING_EMPTY.val());
        }
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)) {
            this.properties = new Properties();
            this.properties.load(inputFile);
        } catch (FileNotFoundException e) {
            log.warn("The properties file couldn't be found", e);
            throw new ExceptionInInitializerError(e);
        } catch (IOException e) {
            log.warn("A problem of type", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Gets a property value from the properties config file.
     *
     * @param propertyName property name as string.
     * @return value of specified property.
     */
    public String getPropertyValue(final String propertyName) {
        String property = System.getProperty(propertyName);
        if (Objects.isNull(property)) {
            property = properties.getProperty(propertyName);
            log.info("property name: {} -> value: {}", propertyName, property);
            return property;
        }

        log.info("property name: {} -> value: {}", propertyName, property);
        return property;
    }
}
