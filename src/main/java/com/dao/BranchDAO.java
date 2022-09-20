package com.dao;

import com.dto.request.BranchReq;
import com.dto.response.GeneralResponse;

public interface BranchDAO {
    GeneralResponse createBranch(BranchReq branchReq);

    GeneralResponse getBranchDetails();
}
