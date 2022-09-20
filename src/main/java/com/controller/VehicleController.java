package com.controller;

import com.dto.request.GetVehicleDetailReq;
import com.dto.request.VehicleCategoryReq;
import com.dto.request.VehicleDetailReq;
import com.dto.response.CommonResponse;
import com.dto.response.GeneralResponse;
import com.dto.response.VehicleCategoriesRes;
import com.dto.response.VehicleDetailListRes;

import java.util.List;

public interface VehicleController {
    /**
     * createVehicleCategory
     * create a new category
     */
    public GeneralResponse createVehicleCategory(VehicleCategoryReq vehicleCategoryReq);

    /**
     * getVehicleCategories
     * dropdown -  list of categories
     */
    public GeneralResponse getVehicleCategories();

    /**
     * createVehicleDetail
     * @param vehicleDetailReq
     * @return
     */
    public GeneralResponse createVehicleDetail(VehicleDetailReq vehicleDetailReq);

    /**
     * getVehicleDetail
     * @param getVehicleDetailReq
     * @return
     */
    public GeneralResponse getVehicleDetail(GetVehicleDetailReq getVehicleDetailReq);

    /**
     * getVehicleDetails
     * @return
     */
    public GeneralResponse getVehicleDetails();

    /**
     *
     * @return
     */
    public GeneralResponse deleteVehicledetails(String userId);

    public  GeneralResponse updateVehicleCategory(String userId ,VehicleCategoryReq vehicleCategoryReq);

    public GeneralResponse editVehicleDetail(int id, VehicleDetailListRes vehicleDetailListRes );



}
