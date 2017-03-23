package test.testaspectj;

/**
 * Created by joshua on 17/3/23.
 */
public interface CustomerBo {

    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);

}
