package test.testdrools.model;

/**
 * @author chuanshi - 2018-12-10 19:27
 */
public class TaxiRide {

    private Boolean isNightSurcharge;
    private Long distanceInMile;

    public Boolean getIsNightSurcharge() {
        return isNightSurcharge;
    }

    public void setIsNightSurcharge(Boolean isNightSurcharge) {
        this.isNightSurcharge = isNightSurcharge;
    }

    public Long getDistanceInMile() {
        return distanceInMile;
    }

    public void setDistanceInMile(Long distanceInMile) {
        this.distanceInMile = distanceInMile;
    }

}
