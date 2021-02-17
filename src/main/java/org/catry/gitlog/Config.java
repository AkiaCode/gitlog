package org.catry.gitlog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @package Config.java
 * @author Catry
 * @version 1.0
 */

public class Config {
    /**
     * Found config file (config.properties) file and get config
     * @param config
     * @return String
     */
    public static String getConfig (String config) throws  IOException {
        String resource = "./config.properties";

        Properties properties = new Properties();
        InputStream input = new FileInputStream(resource);

        properties.load(input);

        return properties.getProperty(config);
    }

}
