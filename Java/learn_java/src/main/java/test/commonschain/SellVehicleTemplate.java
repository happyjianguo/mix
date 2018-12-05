package test.commonschain;

/**
 * @author chuanshi - 2018-12-05 11:19
 */
public abstract class SellVehicleTemplate {

    public void sellVehicle() {
        getCustomerInfo();
        testDriveVehicle();
        negotiateSale();
        arrangeFinancing();
        closeSale();
    }

    public abstract void getCustomerInfo();

    public abstract void testDriveVehicle();

    public abstract void negotiateSale();

    public abstract void arrangeFinancing();

    public abstract void closeSale();
}
