package test.testguava;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by joshua on 17/4/26.
 */
public class MixDemo {

    public static void main(String[] args) {
        List<String> lines = new MixDemo().readFile();
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public List<String> readFile() {
        File file = new File(getClass().getResource("/log4j.properties").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
