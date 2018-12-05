package test.commonschain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author chuanshi - 2018-12-05 11:22
 */
public class TestDriveVehicle implements Command {

    @Override
    public boolean execute(Context ctx) throws Exception {
        System.out.println("Test drive the vehicle");
        return false;
    }

}
