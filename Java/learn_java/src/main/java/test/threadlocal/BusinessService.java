package test.threadlocal;

/**
 * 模拟业务层，在某处读取context对象
 */
public class BusinessService {

    public void businessMethod() {
        Context context = MyThreadLocal.get();
        System.out.println(context.getTransactionId());
    }
}
