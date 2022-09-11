package com.controller.impl;

import com.business.UserBusiness;
import com.controller.UserController;
import com.dto.request.UserLoginReq;
import com.dto.request.DriverRegistrationReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class UserControllerImpl implements UserController {

    @Autowired
    UserBusiness userBusiness;


    @Override
    @PostMapping("/create/customer")
    public GeneralResponse userRegistrationReq(@RequestBody UserRegistrationReq userRegistrationReq) {
        return userBusiness.userRegistration(userRegistrationReq);
    }

    @Override
    @PostMapping("/login/user")
    public GeneralResponse userLogin(@RequestBody UserLoginReq userLoginReq) {
        return userBusiness.userLogin(userLoginReq);
    }

    @Override
    @PostMapping("/create/driver")
    public GeneralResponse driverRegistration(DriverRegistrationReq driverRegistrationReq) {
        return userBusiness.driverRegistration(driverRegistrationReq);
    }
}
