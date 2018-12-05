package test.commonschain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author chuanshi - 2018-12-05 11:20
 */
public class GetCustomerInfo implements Command {

    @Override
    public boolean execute(Context ctx) throws Exception {
        System.out.println("Get customer info");
        ctx.put("customerName", "George Burdell");
        return false;
    }

}
