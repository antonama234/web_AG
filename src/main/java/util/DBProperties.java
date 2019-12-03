package util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBProperties {
    private static final String PATH_TO_PROPERTIES = "C:\\projects\\web_AG\\src\\main\\resources\\conf.properties";

    public static Properties getMyProperties() {
        FileInputStream fileInputStream;
        Properties properties = null;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
