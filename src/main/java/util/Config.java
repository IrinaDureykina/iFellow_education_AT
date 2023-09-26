package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

    private static final Properties prop = new Properties();

    static {
        InputStream input = null;
        try {
            input = new FileInputStream(CONFIG_FILE_PATH);
            prop.load(input);
        } catch (IOException ex) {
            System.err.println("Ошибка при загрузке конфигурации: " + ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии потока: " + e.getMessage());
                }
            }
        }
    }
    public static String getProperties(String key) {
        return prop.getProperty(key);
    }
}

