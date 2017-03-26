package test.testproperty;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by joshua on 17/3/26.
 */
public class PropertyEditor {

    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        InputStream input = new PropertyEditor().getClass().getClassLoader().getResourceAsStream(
                "testproperty.properties");
        prop.load(input);

        System.out.println("name: " + prop.getProperty("name"));

        prop.setProperty("age", "30");
        FileOutputStream fos = new FileOutputStream("testproperty.properties");
        prop.store(fos, "test store");
        fos.close();
    }
}
