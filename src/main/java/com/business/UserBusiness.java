package com.business;

import com.dto.request.CustomerLoginReq;
import com.dto.request.DriverRegistrationReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;

public interface UserBusiness {

    /**
     *
     * @param userRegistrationReq
     * @return
     */
    GeneralResponse userRegistration(UserRegistrationReq userRegistrationReq);

    /**
     *
     * @param customerLoginReq
     * @return
     */
    GeneralResponse userLogin(CustomerLoginReq customerLoginReq);

    /**
     *
     * @param driverRegistrationReq
     * @return
     */
    GeneralResponse driverRegistration(DriverRegistrationReq driverRegistrationReq);

}
