package com.dao;

import com.dto.request.GetVehicleDetailReq;
import com.dto.request.VehicleCategoryReq;
import com.dto.request.VehicleDetailReq;
import com.dto.response.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VehicleDAO  {

    CommonResponse createVehicleCategory(VehicleCategoryReq vehicleCategoryReq);

    List<VehicleCategoriesRes> getVehicleCategories();

    CommonResponse createVehicleDetail(VehicleDetailReq vehicleDetailReq);

    VehicleDetailRes getVehicleDetail(GetVehicleDetailReq getVehicleDetailReq);

    GeneralResponse getVehicleDetails();

    CommonResponse deleteVehicledetails(String userId);

    CommonResponse updateVehicleCategory(String userId ,VehicleCategoryReq vehicleCategoryReq);

    GeneralResponse editVehicleDetail(int id, VehicleDetailListRes vehicleDetailListRes);
}
