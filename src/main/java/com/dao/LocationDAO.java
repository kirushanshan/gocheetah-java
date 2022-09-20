package com.dao;

import com.dto.request.CityAddReq;
import com.dto.request.LocationReq;
import com.dto.response.GeneralResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDAO {


    public GeneralResponse createCity(CityAddReq cityAddReq);

    GeneralResponse createLocation(LocationReq locationReq);

    GeneralResponse getCityByBranchId(int id);

    GeneralResponse getLocationDetailsByCityId(int id);
}
