package com.business;

import com.dto.request.CityAddReq;
import com.dto.request.LocationReq;
import com.dto.response.GeneralResponse;

public interface LocationBusiness {
    GeneralResponse createCity(CityAddReq cityAddReq);

    GeneralResponse createLocation(LocationReq locationReq);

    GeneralResponse getCityByBranchId(int id);


    GeneralResponse getLocationDetailsByCityId(int id);
}
