package test.testgroovy

/**
 * Created by chuanshi.hzh on 2017/5/16.
 * @author chuanshi.hzh
 * @date 2017/05/16
 */
class GroovyDemo {

    public String writeFile() {
        new File('haiku.txt').withWriter('utf-8') {
            writer ->
                writer.write 'test file'
        }
    }

    public String executeCmd() {
        def process = "ls -l".execute()
        print process.text
    }
}
