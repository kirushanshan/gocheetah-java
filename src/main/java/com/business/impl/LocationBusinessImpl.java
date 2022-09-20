package com.business.impl;

import com.business.LocationBusiness;
import com.dao.LocationDAO;
import com.dto.request.CityAddReq;
import com.dto.request.LocationReq;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationBusinessImpl implements LocationBusiness {
    @Autowired
    LocationDAO locationDAO;
    @Override
    public GeneralResponse createCity(CityAddReq cityAddReq) {
       return   locationDAO.createCity(cityAddReq);
    }

    @Override
    public GeneralResponse createLocation(LocationReq locationReq) {
        return locationDAO.createLocation(locationReq);
    }

    @Override
    public GeneralResponse getCityByBranchId(int id) {
        return locationDAO.getCityByBranchId(id);
    }

    @Override
    public GeneralResponse getLocationDetailsByCityId(int id) {
        return locationDAO.getLocationDetailsByCityId(id);
    }


}
