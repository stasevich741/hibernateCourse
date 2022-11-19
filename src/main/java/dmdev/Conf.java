package dmdev;

import org.hibernate.cfg.Configuration;

public class Conf {
    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration;
    }
}
