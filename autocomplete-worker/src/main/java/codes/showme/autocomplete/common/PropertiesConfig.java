package codes.showme.autocomplete.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jack on 11/13/16.
 */
public class PropertiesConfig implements Configuration {
    private Properties properties = new Properties();

    public PropertiesConfig() {
        InputStream in = getClass().getResourceAsStream("/env.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new LoadConfigFromPropertiesException(e);
        }
    }

    @Override
    public String getRedisIP() {
        return properties.getProperty("redis_ip", "127.0.0.1");
    }

    @Override
    public int getRedisPort() {
        try {
            return Integer.valueOf(properties.getProperty("redis_port", "6379"));
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
