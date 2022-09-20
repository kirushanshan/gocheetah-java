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

    @Override
    public GeneralResponse tripRequest(TripRequestReq tripRequestReq) {
        int driver;

        int branchid = tripRequestReq.getBranch();
        driver = tripDAO.assignDriverByBranch(branchid);

        int srcLocationTag = tripDAO.getLocationTag(tripRequestReq.getSlocation());
        int desLocationTag = tripDAO.getLocationTag(tripRequestReq.getDlocation());

        double tripFare = calculateTripFare(srcLocationTag,desLocationTag);

        return tripDAO.tripBook(tripRequestReq,driver,tripFare);
    }

    private double calculateTripFare(int srcLocationTag, int desLocationTag) {
        int distance = Math.abs(srcLocationTag - desLocationTag);
        double minAmount = 250.00;
        int minDistance = 2;
        double tripFare ;
        int balanceDistance;

        if(distance <= 2) {
            tripFare = minAmount;
        } else if (distance<= 4) {
            balanceDistance = distance - minDistance;
            tripFare = minAmount + balanceDistance * 100;
        }else if (distance<= 8){
            balanceDistance = distance - minDistance;
            tripFare = minAmount + balanceDistance * 85;
        }else {
            balanceDistance = distance - minDistance;
            tripFare = minAmount + balanceDistance * 55;
        }
        return tripFare;

    }

    @Override
    public GeneralResponse getTripDetails(int tripId) {
        return tripDAO.getTripDetails(tripId);
    }
}
