package com.business;

import com.dto.request.BranchReq;
import com.dto.response.GeneralResponse;

public interface BranchBusiness {
    GeneralResponse createBranch(BranchReq branchReq);


    GeneralResponse getBranchDetails();
}
