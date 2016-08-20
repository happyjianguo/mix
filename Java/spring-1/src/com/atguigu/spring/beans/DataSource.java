package com.atguigu.spring.beans;

import java.util.Properties;

/**
 * Created by joshua on 16/5/28.
 */
public class DataSource {
    private Properties properties;

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
