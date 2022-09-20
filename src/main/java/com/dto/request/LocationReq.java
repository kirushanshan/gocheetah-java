package com.dto.request;

public class LocationReq {
    String locationName;
    String streetAddress;
    int branchId;
    int cityId;

    int locationTag;

    public int getLocationTag() {
        return locationTag;
    }

    public void setLocationTag(int locationTag) {
        this.locationTag = locationTag;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
