package com.dto.request;

public class TripRequestReq {
    int userId;
    int branch;
    int city;
    int slocation;
    int dlocation;
    int vehicleCategory;
    String travelDateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getSlocation() {
        return slocation;
    }

    public void setSlocation(int slocation) {
        this.slocation = slocation;
    }

    public int getDlocation() {
        return dlocation;
    }

    public void setDlocation(int dlocation) {
        this.dlocation = dlocation;
    }

    public int getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(int vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getTravelDateTime() {
        return travelDateTime;
    }

    public void setTravelDateTime(String travelDateTime) {
        this.travelDateTime = travelDateTime;
    }
}
