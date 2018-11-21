package com.faber.connection;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//</editor-fold>

/**
 *
 * @author NGUYEN DUC THIEN
 */
public class EnvironmentVariable {

    public static String CONFIG_PATH = "C:\\work\\competitionAI\\src\\main\\resources\\config_dev.properties";

    public static Properties getEnvironmentVariable() {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream(CONFIG_PATH)) {
            prop.load(inputStream);
        } catch (IOException e) {
            System.err.println(e);
        }
        return prop;
    }

    public static String getDomain() {
        Properties prop = getEnvironmentVariable();
        return prop.getProperty("domainPart");
    }

    public static String getDomainAllowCORS() {
        Properties prop = getEnvironmentVariable();
        return prop.getProperty("domainCORS");
    }

}
