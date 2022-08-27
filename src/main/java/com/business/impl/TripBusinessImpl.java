package com.business.impl;

import com.business.TripBusiness;
import com.dao.TripDAO;
import com.dto.request.*;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripBusinessImpl implements TripBusiness {

    @Autowired
    TripDAO tripDAO;

    @Override
    public GeneralResponse createNewTrip(CreateTripReq createTripReq) {
        return tripDAO.createNewTrip(createTripReq);
    }

    @Override
    public GeneralResponse editTrip(EditTripReq editTripReq) {
        return tripDAO.editTrip(editTripReq);
    }

    @Override
    public GeneralResponse assignDriverToTrip(AssignDriverReq assignDriverReq) {
        return tripDAO.assignDriverToTrip(assignDriverReq);
    }

    @Override
    public GeneralResponse cancelTrip(CancelTripReq cancelTripReq) {
        return tripDAO.cancelTrip(cancelTripReq);
    }

    @Override
    public GeneralResponse getTripDetail(TripDetailReq tripDetailReq) {
        return tripDAO.getTripDetail(tripDetailReq);
    }

    @Override
    public GeneralResponse getLocationListByCity(GetLocationByCityReq getLocationByCityReq) {
        return tripDAO.getLocationListByCity(getLocationByCityReq);
    }

}
