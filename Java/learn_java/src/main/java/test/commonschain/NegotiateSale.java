package test.commonschain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author chuanshi - 2018-12-05 11:23
 */
public class NegotiateSale implements Command {

    @Override
    public boolean execute(Context ctx) throws Exception {
        System.out.println("Negotiate sale");
        return false;
    }

}
