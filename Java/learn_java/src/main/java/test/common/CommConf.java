package test.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by joshua on 16/12/3.
 */
public class CommConf {

    public static void main(String[] args) {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration("usergui.properties");
            config.setProperty("colors.background", "#000000");
            config.save();

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
