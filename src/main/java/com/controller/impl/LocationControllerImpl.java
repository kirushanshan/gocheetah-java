package com.controller.impl;

import com.business.LocationBusiness;
import com.controller.LocationController;
import com.dto.request.CityAddReq;
import com.dto.request.LocationReq;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LocationControllerImpl implements LocationController {
    @Autowired
    LocationBusiness locationBusiness;

    @Override
    @PostMapping("/create/city/name")
    public GeneralResponse createCity(@RequestBody CityAddReq cityAddReq) {
        return locationBusiness.createCity(cityAddReq);
    }

    @Override
    @PostMapping("/create/location/name")
    public GeneralResponse createLocation(@RequestBody LocationReq locationReq) {
        return locationBusiness.createLocation(locationReq);
    }

    @Override
    @GetMapping("get/city/branch/{id}")
    public GeneralResponse getCityByBranchId(@PathVariable("id") int id) {
        return locationBusiness.getCityByBranchId(id);
    }

    @Override
    @GetMapping("get/location/city/{id}")
    public GeneralResponse getLocationDetailsByCityId(@PathVariable("id") int id) {
        return locationBusiness.getLocationDetailsByCityId(id);
    }

}
