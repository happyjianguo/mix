package test.mixtest;

/**
 * 测试是否可以使用接口定义变量
 */
public class TestReturnInstanceFromInterface {

    public static void main(String[] args) {
        IPerson person = new Person();
        person.run();
    }
}
