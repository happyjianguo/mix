package test.commonschain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author chuanshi - 2018-12-05 11:24
 */
public class CloseSale implements Command {

    @Override
    public boolean execute(Context ctx) throws Exception {
        System.out.println("Congratulations " + ctx.get("customerName") + ", you bought a new car!");
        return false;
    }

}
