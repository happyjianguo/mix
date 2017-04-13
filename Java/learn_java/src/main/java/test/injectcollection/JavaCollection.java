package test.injectcollection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by joshua on 17/4/13.
 */
public class JavaCollection {

    private List addressList;
    private Set addressSet;
    private Map addressMap;
    private Properties addressProp;

    public List getAddressList() {
        System.out.println("List Elements :" + addressList);
        return addressList;
    }

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public Set getAddressSet() {
        System.out.println("Set Elements :" + addressSet);
        return addressSet;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public Map getAddressMap() {
        System.out.println("Map Elements :" + addressMap);
        return addressMap;
    }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        System.out.println("Properties Elements :" + addressProp);
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }
}
