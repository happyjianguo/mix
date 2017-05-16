package test.testgroovy

/**
 * Created by chuanshi.hzh on 2017/5/16.
 * @author chuanshi.hzh
 * @date 2017/05/16
 */
class GroovyDemo {

    public String hello() {
        def map = ['name': 'john', 'age': 14, 'sex': 'boy']
        map = map + ['weight': 25]
        print map['name']
    }
}
