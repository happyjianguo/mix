package com.tutorialspoint;
import java.util.*;
public class JavaCollection {
    List addressList;
    Set  addressSet;
    Map  addressMap;
    Properties addressProp;

    public List getAddressList() {
        System.out.println("List Elements :"  + addressList);
        return addressList;
    }

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public Set getAddressSet() {
        System.out.println("List Elements :"  + addressList);
        return addressSet;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public Map getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map addressMap) {
        System.out.println("Map Elements :"  + addressMap);
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        System.out.println("Map Elements :"  + addressMap);
        this.addressProp = addressProp;
    }
}