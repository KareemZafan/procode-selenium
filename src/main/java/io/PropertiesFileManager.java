package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileManager {
    private final Properties properties;

    public PropertiesFileManager(String filePath) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
