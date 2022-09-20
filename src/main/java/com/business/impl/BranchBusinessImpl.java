package com.business.impl;

import com.business.BranchBusiness;
import com.dao.BranchDAO;
import com.dto.request.BranchReq;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchBusinessImpl implements BranchBusiness {
    @Autowired
    BranchDAO branchDAO;

    @Override
    public GeneralResponse createBranch(BranchReq branchReq) {
        return branchDAO.createBranch(branchReq) ;
    }

    @Override
    public GeneralResponse getBranchDetails() {
        return branchDAO.getBranchDetails();
    }
}
