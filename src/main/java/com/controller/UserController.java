package com.controller;

import com.dto.request.CustomerLoginReq;
import com.dto.request.DriverRegistrationReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;

public interface UserController {


    /**
     *
     * @param userRegistrationReq
     * @return
     */
    public GeneralResponse userRegistrationReq(UserRegistrationReq userRegistrationReq);

    /**
     *
     * @param customerLoginReq
     * @return
     */
    public GeneralResponse userLogin(CustomerLoginReq customerLoginReq);

    /**
     *
     * @param driverRegistrationReq
     * @return
     */
    public GeneralResponse driverRegistration(DriverRegistrationReq driverRegistrationReq);


}
