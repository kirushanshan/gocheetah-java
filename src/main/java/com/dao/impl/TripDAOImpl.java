package com.dao.impl;

import com.dao.TripDAO;
import com.dto.request.*;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TripDAOImpl implements TripDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public GeneralResponse createNewTrip(CreateTripReq createTripReq) {
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.ITrip.INSERT_TRIP,
                    createTripReq.getSourceLocationId(),
                    createTripReq.getDestinationLocationId(),
                    createTripReq.getTravelDateTime(),
                    calculateCost(),
                    "confirm",
                    createTripReq.getBranchId(),
                    createTripReq.getUserDetailId()
            );

            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
        }
        return commonResponse;
    }


    @Override
    public GeneralResponse editTrip(EditTripReq editTripReq) {
        return null;
    }

    @Override
    public GeneralResponse assignDriverToTrip(AssignDriverReq assignDriverReq) {
        return null;
    }

    @Override
    public GeneralResponse cancelTrip(CancelTripReq cancelTripReq) {
        return null;
    }

    @Override
    public GeneralResponse getTripDetail(TripDetailReq tripDetailReq) {
        return null;
    }

    @Override
    public GeneralResponse getLocationListByCity(GetLocationByCityReq getLocationByCityReq) {
        return null;
    }


    double calculateCost(){
        return 13.0;
    }
}
