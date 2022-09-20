package com.controller;

import com.dto.request.CityAddReq;
import com.dto.request.LocationReq;
import com.dto.response.GeneralResponse;

public interface LocationController {

    public GeneralResponse createCity(CityAddReq cityAddReq);

    public  GeneralResponse createLocation(LocationReq locationReq);

    public  GeneralResponse getCityByBranchId(int id);

    GeneralResponse getLocationDetailsByCityId(int id);
}
