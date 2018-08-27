package utils;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static Properties properties = new Properties();
    private static final String CONFIG_PATH = "application.properties";
    static{
        InputStream inputStream = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            inputStream = classLoader.getResourceAsStream(CONFIG_PATH);
            properties.load(inputStream);

        }catch (Exception e){
        }finally {
            try {
                inputStream.close();
            }catch (Exception e){

            }

        }
    }
    public static String getProperty(String key){
        return (String)properties.get(key);
    }

    public static void main(String[] args) {

        System.out.println(getProperty("server.port"));
    }
}
