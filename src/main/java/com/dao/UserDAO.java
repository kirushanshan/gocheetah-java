package com.dao;

import com.dto.request.UserLoginReq;
import com.dto.request.DriverRegistrationReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.CommonResponse;
import com.dto.response.GeneralResponse;
import com.dto.response.UserRegistrationRes;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface UserDAO {
    /**
     *
     * @param userRegistrationReq
     * @return
     */
    GeneralResponse userRegistration(UserRegistrationReq userRegistrationReq);

    /**
     *
     * @param emailAddress
     * @return
     */
    public UserRegistrationRes getUserByEmail(String emailAddress);

    /**
     *
     * @param passcode
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public String passcodeEncrypt(String passcode) throws NoSuchAlgorithmException, IOException;

    /**
     *
     * @param userLoginReq
     * @return
     */
    public int userLogin(UserLoginReq userLoginReq);

    /**
     *
     * @param driverRegistrationReq
     * @return
     */
    CommonResponse driverRegistration(DriverRegistrationReq driverRegistrationReq);
}
