package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

      public static String getValue(String key) {
        String strPropValue ="";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/browser-config.properties"));
            properties.load(new FileInputStream("resources/testdata-config.properties"));
            strPropValue = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return strPropValue;
    }


    public Long getTimeout() throws Exception {
        String timeout = PropertiesReader.getValue("timeout");
        return Long.parseLong(timeout);
    }
}