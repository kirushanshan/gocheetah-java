package com.dto.response;

public class VehicleDetailListRes {
    private int vehicleDetailId;
    private String brandName;
    private String modelName;
    private String vehicleCategoryName;

    private int vehicleCategoryId;

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getVehicleDetailId() {
        return vehicleDetailId;
    }

    public void setVehicleDetailId(int vehicleDetailId) {
        this.vehicleDetailId = vehicleDetailId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }
}
