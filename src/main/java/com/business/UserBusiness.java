package com.business;

import com.dto.request.UserLoginReq;
import com.dto.request.DriverRegistrationReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;

public interface UserBusiness {

    /**
     *
     * @param userRegistrationReq
     * @return
     */
    GeneralResponse userRegistration( UserRegistrationReq userRegistrationReq);

    /**
     *
     * @param userLoginReq
     * @return
     */
    GeneralResponse userLogin(UserLoginReq userLoginReq);

    /**
     *
     * @param driverRegistrationReq
     * @return
     */
    GeneralResponse driverRegistration(DriverRegistrationReq driverRegistrationReq);

}
