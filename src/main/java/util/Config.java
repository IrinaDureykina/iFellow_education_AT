package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

    private static final Properties prop = new Properties();

    static {
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.err.println("Ошибка при загрузке конфигурации: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return prop.getProperty(key);
    }
}

