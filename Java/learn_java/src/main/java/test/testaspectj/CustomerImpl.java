package test.testaspectj;

/**
 * Created by joshua on 17/3/23.
 */
public class CustomerImpl implements CustomerBo {

    public void addCustomer() {
        System.out.println("addCustomer() is running");
    }

    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue() is running");
        return "hello";
    }

    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running");
        throw new Exception("Generic Error");
    }

    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround() is running");
    }
}
