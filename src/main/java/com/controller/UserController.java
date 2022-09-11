package com.controller;

import com.dto.request.UserLoginReq;
import com.dto.request.DriverRegistrationReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {


    /**
     *
     * @param userRegistrationReq
     * @return
     */
    public GeneralResponse userRegistrationReq(@RequestBody UserRegistrationReq userRegistrationReq);

    /**
     *
     * @param userLoginReq
     * @return
     */
    public GeneralResponse userLogin(@RequestBody UserLoginReq userLoginReq);

    /**
     *
     * @param driverRegistrationReq
     * @return
     */
    public GeneralResponse driverRegistration(DriverRegistrationReq driverRegistrationReq);


}
