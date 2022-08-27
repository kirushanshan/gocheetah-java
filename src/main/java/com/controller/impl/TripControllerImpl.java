package com.controller.impl;

import com.business.TripBusiness;
import com.controller.TripController;
import com.dto.request.*;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TripControllerImpl implements TripController {

    @Autowired
    TripBusiness tripBusiness;

    @Override
    @PostMapping("/trip/create")
    public GeneralResponse createNewTrip(@RequestBody CreateTripReq createTripReq) {
        return tripBusiness.createNewTrip(createTripReq);
    }

    @Override
    @PostMapping("/trip/edit")
    public GeneralResponse editTrip(@RequestBody EditTripReq editTripReq) {
        return tripBusiness.editTrip(editTripReq);
    }

    @Override
    @PostMapping("/trip/assign/driver")
    public GeneralResponse assignDriverToTrip(@RequestBody AssignDriverReq assignDriverReq) {
        return tripBusiness.assignDriverToTrip(assignDriverReq);
    }

    @Override
    @PostMapping("/trip/cancel")
    public GeneralResponse cancelTrip(@RequestBody CancelTripReq cancelTripReq) {
        return tripBusiness.cancelTrip(cancelTripReq);
    }

    @Override
    @PostMapping("/trip/list")
    public GeneralResponse getTripList() {
        return null;
    }

    @Override @PostMapping("/trip/detail")
    public GeneralResponse getTripDetail(TripDetailReq tripDetailReq) {
        return tripBusiness.getTripDetail(tripDetailReq);
    }

    @Override
    @PostMapping("/trip/location/list")
    public GeneralResponse getLocationList() {
        return null;
    }

    @Override
    @PostMapping("/trip/location/by/city")
    public GeneralResponse getLocationListByCity(GetLocationByCityReq getLocationByCityReq) {
        return tripBusiness.getLocationListByCity(getLocationByCityReq);
    }
}
