package test.xxetest

import groovy.util.XmlSlurper

/**
 * Created by chuanshi.hzh on 2017/5/10.
 * @author chuanshi.hzh
 * @date 2017/05/10
 */
class GroovyApp {

    static void main(String... args) {

//        String content = readFileByLines("test.xml");
////        System.out.println(content)
//        def ap = new XmlSlurper().parseText(content)
        String content = '''
<!DOCTYPE a [<!ENTITY b SYSTEM "file:///etc/passwd">]>
<some>
    <technology name="groovyProperty">
        <name>GroovyNode</name>
    </technology>
</some>
'''
        def ap = new XmlSlurper(false,false,true).parseText(content)
        System.out.println(ap.toString())

    }

    public static String readFileByLines(String fileName) {
        InputStream file = null;
        BufferedReader reader = null;
        InputStreamReader inputFileReader = null;
        String content = "";
        String tempString = null;
        try {
            file = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            inputFileReader = new InputStreamReader(file, "utf-8");
            reader = new BufferedReader(inputFileReader);
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                content += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return content;
    }


}
